package io.jkit.apiserver.service.ansible;

import io.jkit.apiserver.model.role.Role;

import javax.enterprise.context.ApplicationScoped;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;



@ApplicationScoped
public class AnsibleService {
	public AnsibleService() {
		
	}
	public void generatePlaybook(ArrayList<Role> roleList, String ansibleOptions, String playbookFilePath)
			throws FileNotFoundException, IOException {
		StringBuffer playbookContent = new StringBuffer();

		try{
			ClassLoader url1 = getClass().getClassLoader();
			System.out.println("+++++++++++++++++++"+url1.getResource("ansible/templates/ansible.cfg").getFile());
			String url2 = url1.getResource("ansible/templates/expected-playbook.yml").getFile();
			System.out.println("+++++++++++++++++++++++"+url2);
			FileReader fileReader = new FileReader(url2);
			BufferedReader reader = new BufferedReader(fileReader);
			String line=reader.readLine();
			System.out.println("+++++++++++++"+line);
		}catch (Exception e){
			System.out.println("ERRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR");
			e.printStackTrace();
		}



		try (BufferedReader reader = new BufferedReader(new FileReader(
				getClass().getClassLoader().getResource("ansible/templates/jkit-playbook-template.yml").getFile()))) {
			String line = reader.readLine();
			while (line != null) {
				if (line.contains("#ROLE")) {
					playbookContent
							.append(line.replaceAll("#ROLE", generateRoleListForPlaybook(roleList, ansibleOptions)));
				} else if (!line.isEmpty()) {
					playbookContent.append(line);
				}
				playbookContent.append(System.getProperty("line.separator"));
				line = reader.readLine();
			}
		}

		try (FileWriter playbookFile = new FileWriter(new File(playbookFilePath))) {
			playbookFile.write(playbookContent.toString());
			playbookFile.flush();
		}

	}

	private String generateRoleListForPlaybook(ArrayList<Role> roleList, String ansibleOptions) throws IOException {

		StringBuffer roleTemplateList = new StringBuffer();

		for (Role role : roleList) {
			roleTemplateList.append(generateRoleTemplate(role, ansibleOptions));
		}

		return roleTemplateList.toString();
	}

	private String generateRoleTemplate(Role role, String ansibleOptions) throws IOException {
		StringBuffer roleTemplate = new StringBuffer();

		try (BufferedReader reader = new BufferedReader(new FileReader(
				getClass().getClassLoader().getResource("ansible/templates/jkit-role-template.yml").getFile()))) {
			String line = reader.readLine();
			while (line != null) {
				if (line.contains("#ROLE_SHORT_DESC")) {
					roleTemplate.append(line.replaceAll("#ROLE_SHORT_DESC", role.getRoleShortDesc()));

				} else if (line.contains("#HOSTS")) {
					StringBuffer hosts = new StringBuffer();
					String[] roleHosts = role.getRoleTargetHosts().split(":");
					for (int i = 0; i < roleHosts.length; i++) {

						if (roleHosts[i].equalsIgnoreCase("master") || roleHosts[i].equalsIgnoreCase("node")) {
							hosts.append(roleHosts[i] + "s[0]");
						} else
							hosts.append(roleHosts[i]);

						if (i != roleHosts.length - 1) {
							hosts.append(":");
						}
					}
					roleTemplate.append(line.replaceAll("#HOSTS", hosts.toString()));
				} else if (line.contains("#ROLE_NAME")) {
					roleTemplate.append(line.replaceAll("#ROLE_NAME", role.getRoleName()));
				} else if (line.contains("#ANSILBE_OPTIONS")) {
					roleTemplate.append(line.replaceAll("#ANSILBE_OPTIONS", ansibleOptions));
				} else {
					if (!line.isEmpty())
						roleTemplate.append(line);
				}
				line = reader.readLine();
				roleTemplate.append(System.getProperty("line.separator"));
			}
		}
		roleTemplate.append(System.getProperty("line.separator"));
		return roleTemplate.toString();
	}

}
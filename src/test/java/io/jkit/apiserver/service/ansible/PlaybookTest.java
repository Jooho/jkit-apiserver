package io.jkit.apiserver.service.ansible;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Properties;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.arquillian.CreateSwarm;

import io.jkit.apiserver.model.role.Role;

@RunWith(Arquillian.class)
public class PlaybookTest {

	// private AnsibleService ansibleService = new AnsibleService();

	@Inject
	private AnsibleService ansibleService;

	private static String port = "18080";

	@CreateSwarm
	public static Swarm newContainer() throws Exception {

		Properties properties = new Properties();
		properties.put("swarm.http.port", port);
		return new Swarm(properties).withProfile("local");
	}

	@Deployment
	public static Archive<?> createDeployment() {

		return ShrinkWrap.create(WebArchive.class).addPackages(true, AnsibleService.class.getPackage())
				.addPackages(true, "io.jkit.apiserver.model")
				.addAsResource("WEB-INF/ansible/templates/ansible.cfg", "ansible/templates/ansible.cfg")
				.addAsResource("WEB-INF/ansible/templates/jkit-playbook-template.yml", "ansible/templates/jkit-playbook-template.yml")
				.addAsResource("WEB-INF/ansible/templates/jkit-role-template.yml", "ansible/templates/jkit-role-template.yml")
				.addAsResource("WEB-INF/junit-data/expected-playbook.yml", "ansible/templates/expected-playbook.yml")
				.addAsResource("project-local.yml", "project-local.yml")
				.addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml");
	
	}


	@Test
	public void writePlaybook() throws Exception {
		ArrayList<Role> roleList = new ArrayList<>();
		roleList.add(new Role(1, "master_controller_lead_varification", "master", "Master Controller Lead Verification",
				"Who is the lead controller among masters?"));
		roleList.add(new Role(2, "api_server_health_check", "master", "Check API Server/Web Console health",
				"API Server/Web Console health Check using RESTful API."));
		roleList.add(new Role(3, "openshift_daemons_status_check", "masters:nodes:etcd",
				"Check OpenShift Daemons Status", "On master node, there are several services related to OpenShift."));

		// To-do
		String ansibleOptions = "gather_facts: false";
		String playbookFilePath = "/tmp/playbook.yml";
		ansibleService.generatePlaybook(roleList, ansibleOptions, playbookFilePath);

		try (BufferedReader expected_file = new BufferedReader(new FileReader(getClass().getClassLoader()
				.getResource("ansible/templates/expected-playbook.yml").getFile()));
				BufferedReader actual_file = new BufferedReader(new FileReader(playbookFilePath))) {

			String expected_file_line = expected_file.readLine();
			String actual_file_line = actual_file.readLine();
			while (expected_file_line != null) {
				assertThat(expected_file_line, equalTo(actual_file_line));
				expected_file_line = expected_file.readLine();
				actual_file_line = actual_file.readLine();
			}

		}

	}

	// @Test
	// public void updateRolesFromReadmeUnderFolder() {
	//
	// }

}

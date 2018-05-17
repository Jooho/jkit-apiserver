package io.jkit.apiserver.controller;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import io.jkit.apiserver.model.config.AnsibleControllerModel;
import io.jkit.apiserver.model.role.RoleProfile;
import io.jkit.apiserver.service.ConfigService;
import io.jkit.apiserver.service.RoleService;
import io.jkit.apiserver.service.ansible.AnsibleService;
import io.jkit.apiserver.util.FileUtil;

@ApplicationScoped
public class HealthCheckController {

	public HealthCheckController() {

	}

	@Inject
	private ConfigService configService;
	@Inject
	private RoleService roleService;
	@Inject
	private AnsibleService ansibleService;

	public void executeHealthCheck(String ansibleCotrollerName, String roleProfileName) throws Exception {

		// Get Ansible controller information
		AnsibleControllerModel ansibleControllerInfo = configService.getAnsibleController(ansibleCotrollerName);

		// To-Do Check connectivity with Ansible controller

		// To-Do Hard Coded targetfilepath
		// Create hosts file to Jkit default folder.
		FileUtil.writeFile("/tmp/jkit_hosts", ansibleControllerInfo.getHostsFile());

		// Get RoleList by role profile
		RoleProfile roleProfile = roleService.getRoleProfile(roleProfileName);

		// Generate Ansible playbook and place it to Jkit default folder.
		ansibleService.generatePlaybook(roleProfile.getRoleList(), "", "/tmp/jkit_playbook.yml");
		// Archive Jkit default folder
		
//		FileUtil.compress(tarPath, files);
		// Copy it to Ansible controller under Jkit default folder
		// Untar the archive file
		// Execute Ansible playbook
		// When the ansible plabyook finished, after.yml will call "Finish" api.
		// Archieve result data
		// Get the result data to local
		// Analyze it and update DB and places log files to Jkit default folder.

	}

}

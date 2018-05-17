package io.jkit.apiserver.controller;

import java.net.URL;
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
import org.wildfly.swarm.spi.api.JARArchive;

import io.jkit.apiserver.service.ConfigService;

@RunWith(Arquillian.class)
public class HealthCheckTest {

	private static String port = "18080";

	@Inject
	private HealthCheckController healthCheckController;

	@CreateSwarm
	public static Swarm newContainer() throws Exception {

		Properties properties = new Properties();
		properties.put("swarm.http.port", port);
		return new Swarm(properties).withProfile("local");
	}

	@Deployment
	public static Archive<?> createDeployment() {

		return ShrinkWrap.create(WebArchive.class).addPackages(true, "io.jkit")
				.addPackages(true, HealthCheckController.class.getPackage())
				.addPackages(true, ConfigService.class.getPackage())
				.addAsResource("project-local.yml", "project-local.yml")
				.addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml");
//				.addAsResource("/ansible/templates/jkit-playbook-template.yml")
//				.addAsResource("WEB-INF/ansible/templates/ansible.cfg");
	}

	@Test
	public void setupHealthCheck() {
		// Base on Config properties.
		// Create Jkit default folder
		// Clone Jkit Git Repository
		// update ansible.cfg file
	}

	@Test
	public void executeHealthCheck() throws Exception {
		 URL resource1 = getClass().getResource("jkit-playbook-template.yml");
//		 URL resource2 = getClass().getResource("ansible/templates/jkit-playbook-template.yml");
//		 URL resource3 = getClass().getResource("jkit-playbook-template.yml");		    
//		System.out.println("resource1: " +resource1.getFile());
//		System.out.println("resource2: " +resource2.getFile());
//		System.out.println("resource3: " +resource3.getFile());
		
		    
		healthCheckController.executeHealthCheck("cee-ops", "master");
	}
}



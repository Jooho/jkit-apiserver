package io.jkit.apiserver.model.role;

import io.jkit.apiserver.service.RoleService;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.arquillian.CreateSwarm;
import org.wildfly.swarm.arquillian.DefaultDeployment;

import javax.inject.Inject;

import java.util.Properties;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(Arquillian.class)
@DefaultDeployment
public class RoleServiceTest {

	private static String port = "5005";
	
	@Inject
	private RoleService roleService;

	@CreateSwarm
	public static Swarm newContainer() throws Exception {

		Properties properties = new Properties();
		properties.put("swarm.http.port", port);

		return new Swarm(properties).withProfile("local");
	}

//	@Deployment
	public static Archive<?> createDeployment() {

		return ShrinkWrap.create(WebArchive.class).addPackages(true, RoleService.class.getPackage())
				.addPackages(true, Role.class.getPackage())
				.addPackages(true, RoleProfile.class.getPackage())
				.addAsResource("project-local.yml", "project-local.yml")
				.addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
				.addAsResource("META-INF/create.sql", "META-INF/create.sql")
				.addAsResource("META-INF/drop.sql", "META-INF/drop.sql")
				.addAsResource("META-INF/test-data-role.sql", "META-INF/test-data-role.sql");
	}

	
	
	@Test
	public void getRoleListByRoleProfile() {
		RoleProfile roleProfile = roleService.getRoleProfile("master");

		assertThat(roleProfile.getRoleList().get(2).getRoleName(), equalTo("openshift_daemons_status_check"));
		
	}
	
//	
//	@Test
//	public void insertRole() {
//		
//	}
//	
//	@Test
//	public void getRole() {
//		
//	}
//	
//	@Test
//	public void updateRole() {
//		
//	}
//	
//	@Test
//	public void deleteRole() {
//		
//	}
//	
//	@Test
//	public void insertRoleExpectResult() {
//		
//	}
//	
//	@Test
//	public void updateRoleExpectResult() {
//		
//	}
//	
//	@Test
//	public void insertRoleActualResult() {
//		
//	}
//	
//	@Test
//	public void deleteRoleActualResult() {
//		
//	}
//	
//	@Test
//	public void updateRoleActualResult() {
//		
//	
//	}
//	
//	@Test
//	public void getRoleActualResultRawData() {
//		
//	}
//	
//		
//	@Test
//	public void getRoleProfileHistory() {
//		
//	}
//	
//	
//	@Test
//	public void getRoleOperateList() {
//		
//	}
//	
//	@Test 
//	public void checkRoleOperateInputType() {
//		
//	}
//	
	
	
	
	
	
}

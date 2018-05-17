package io.jkit.apiserver.config.model;

import io.jkit.apiserver.model.config.AnsibleControllerModel;
import io.jkit.apiserver.service.ConfigService;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.arquillian.CreateSwarm;

import javax.inject.Inject;
import java.util.Properties;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(Arquillian.class)
public class ConfigServiceTest {

	private static String port = "18080";

	@Inject
	private ConfigService configService;

	@CreateSwarm
	public static Swarm newContainer() throws Exception {

		Properties properties = new Properties();
		properties.put("swarm.http.port", port);
		return new Swarm(properties).withProfile("local");
	}

	@Deployment
	public static Archive<?> createDeployment() {

		return ShrinkWrap.create(WebArchive.class).addPackages(true, ConfigService.class.getPackage())
				.addPackages(true, AnsibleControllerModel.class.getPackage())
				.addAsResource("project-local.yml", "project-local.yml")
				.addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
				.addAsResource("META-INF/test-load.sql", "META-INF/test-load.sql");
	}

	@Test
	public void getAnsibleControllerInfo() {
		AnsibleControllerModel ansibleController = configService.getAnsibleController("sandbox");

		assertThat(ansibleController.getHostIp(), equalTo("10.10.12.21"));
		assertThat(ansibleController.getUserId(), equalTo("root"));
		assertThat(ansibleController.getUserPw(), equalTo("redhat"));
		assertThat(ansibleController.getHostsFile(), equalTo("master.example.com 10.10.10.10"));

	}
	


	@Test
	public void updateAnsibleController() {
		
	}
//	
//	@Test
//	public void getConditionResult() {
//		
//		List<ConditionResultModel> expectedValueList= new ArrayList<>();
//		expectedValueList.add(new ConditionResultModel(1,"sandbox",1,0,0,"Ansible Installation","none"));
//		expectedValueList.add(new ConditionResultModel(2,"sandbox",1,1,0,"Ansible Installed","none"));
//		expectedValueList.add(new ConditionResultModel(3,"sandbox",1,2,2,"Docker Installed","none"));
//		expectedValueList.add(new ConditionResultModel(4,"sandbox",1,3,2,"Docker Image Downloadable","none"));
//		expectedValueList.add(new ConditionResultModel(5,"sandbox",1,4,2,"Docker Image Runnable","none"));
//		expectedValueList.add(new ConditionResultModel(6,"sandbox",2,0,1,"Host Accessibility","none"));
//		expectedValueList.add(new ConditionResultModel(7,"sandbox",2,1,1,"Master Hosts Accessible","master1.example.com ok\\\\n master2.example.com no"));
//		expectedValueList.add(new ConditionResultModel(8,"sandbox",2,2,0,"Node Hosts Accessible","node1.example.com ok\\n node2.example.com ok"));
//		expectedValueList.add(new ConditionResultModel(9,"sandbox",2,3,0,"ETCD Host Accessible","etcd1.example.com ok\\n etcd2.example.com ok"));
//		
//		
//		
//		List<ConditionResultModel> conditionResultList = configService.getConditionResults("sandbox");
//		
//		for (int i =0; i< conditionResultList.size(); i++) {
//			ConditionResultModel actual = conditionResultList.get(i);
//			ConditionResultModel expected = expectedValueList.get(i);
//			assertThat(actual.getAcName(), equalTo(expected.getAcName()));
//			assertThat(actual.getCondSubId(), equalTo(expected.getCondSubId()));
//			assertThat(actual.getCondResult(), equalTo(expected.getCondResult()));
//			
//		}
//				
//	}

}

package io.jkit.apiserver.model.config;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "ANSIBLE_CONTROLLER", uniqueConstraints = @UniqueConstraint(columnNames = "ac_name"))
public class AnsibleControllerModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4383701989263718964L;

	public AnsibleControllerModel() {

	}

	public AnsibleControllerModel(String acName, String hostIp, String userId, String userPw,
			String hostsFile) {
		super();
		this.acName = acName;
		this.hostIp = hostIp;
		this.userId = userId;
		this.userPw = userPw;
		this.hostsFile = hostsFile;
	}

	@Id
	@Column(name="ac_name")
	private String acName;
	@Column(name="host_ip")
	private String hostIp;
	@Column(name="user_id")
	private String userId;
	@Column(name="user_pw")
	private String userPw;
	@Column(name="hosts_file")
	private String hostsFile;


	public String getName() {
		return acName;
	}

	public void setName(String acName) {
		this.acName = acName;
	}

	public String getHostIp() {
		return hostIp;
	}

	public void setHostIp(String hostIp) {
		this.hostIp = hostIp;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getHostsFile() {
		return hostsFile;
	}

	public void setHostsFile(String hostsFile) {
		this.hostsFile = hostsFile;
	}

}

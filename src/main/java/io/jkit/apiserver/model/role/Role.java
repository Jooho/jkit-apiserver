package io.jkit.apiserver.model.role;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ROLE")
public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5216736287637622091L;

	public Role() {

	}

	public Role(int roleIndex, String roleName, String roleTargetHosts, String roleShortDesc, String roleLongDesc) {
		super();
		this.roleIndex = roleIndex;
		this.roleName = roleName;
		this.roleTargetHosts = roleTargetHosts;
		this.roleShortDesc = roleShortDesc;
		this.roleLongDesc = roleLongDesc;
	}

	@Id
	@Column(name = "role_index")
	private int roleIndex;
	@Column(name = "role_name")
	private String roleName;
	@Column(name = "role_target_hosts")
	private String roleTargetHosts;
	@Column(name = "role_short_desc")
	private String roleShortDesc;
	@Column(name = "role_long_desc")
	private String roleLongDesc;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleTargetHosts() {
		return roleTargetHosts;
	}

	public void setRoleTargetHosts(String roleTargetHosts) {
		this.roleTargetHosts = roleTargetHosts;
	}

	public String getRoleShortDesc() {
		return roleShortDesc;
	}

	public void setRoleShortDesc(String roleShortDesc) {
		this.roleShortDesc = roleShortDesc;
	}

	public String getRoleLongDesc() {
		return roleLongDesc;
	}

	public void setRoleLongDesc(String roleLongDesc) {
		this.roleLongDesc = roleLongDesc;
	}

	public int getRoleIndex() {
		return roleIndex;
	}

	public void setRoleIndex(int roleIndex) {
		this.roleIndex = roleIndex;
	}
}

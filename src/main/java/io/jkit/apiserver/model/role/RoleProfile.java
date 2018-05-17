package io.jkit.apiserver.model.role;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="ROLE_PROFILE")
public class RoleProfile {

	
	public RoleProfile() {
		
	}
	public RoleProfile(String roleProfileName, String roleProfileDesc, ArrayList<Role> roleList) {
		super();
		this.roleProfileName = roleProfileName;
		this.roleProfileDesc = roleProfileDesc;
		this.roleList = roleList;
	}

	@Id
	@Column(name="rp_name")
	private String roleProfileName;
	
	@Column(name="rp_desc")
	private String roleProfileDesc;
	
	@Transient 
	private ArrayList<Role> roleList = null;

	public String getRoleProfileName() {
		return roleProfileName;
	}

	public void setRoleProfileName(String roleProfileName) {
		this.roleProfileName = roleProfileName;
	}

	public String getRoleProfileDesc() {
		return roleProfileDesc;
	}

	public void setRoleProfileDesc(String roleProfileDesc) {
		this.roleProfileDesc = roleProfileDesc;
	}
	@Transient 
	public ArrayList<Role> getRoleList() {
		return roleList;
	}
	public void setRoleList(ArrayList<Role> roleList) {
		this.roleList = roleList;
	}
}

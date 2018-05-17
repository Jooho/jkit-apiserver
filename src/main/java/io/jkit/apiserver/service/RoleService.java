package io.jkit.apiserver.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import io.jkit.apiserver.model.role.Role;
import io.jkit.apiserver.model.role.RoleProfile;

@ApplicationScoped
public class RoleService {
	@PersistenceContext(unitName = "primary")
	private EntityManager entityManager;

	
	public RoleProfile getRoleProfile(String roleProfileName) {
		ArrayList<Role> roleList = new ArrayList<>();

		Query roleProfileIndexQuery = entityManager.createNativeQuery(
				"select rpb.role_index from role_profile as rp LEFT JOIN role_profile_bind as rpb ON rp.rp_index= rpb.rp_index where rp.rp_name='"
						+ roleProfileName+"'");
		List<?> roleIndexList = roleProfileIndexQuery.getResultList();

		for (int i=0; i < roleIndexList.size(); i++) {
			roleList.add(entityManager.find(Role.class, roleIndexList.get(i)));
		}
		
		RoleProfile roleProfile = entityManager.find(RoleProfile.class, roleProfileName);
		roleProfile.setRoleList(roleList);

		return roleProfile;
	}

}

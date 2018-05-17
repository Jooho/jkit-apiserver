package io.jkit.apiserver.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import io.jkit.apiserver.model.config.AnsibleControllerModel;
import io.jkit.apiserver.model.config.ConditionResultModel;

@ApplicationScoped
public class ConfigService {

	public ConfigService() {
	}

	@PersistenceContext(unitName = "primary")
	private EntityManager entityManager;

	public AnsibleControllerModel getAnsibleController(String acName) {
		AnsibleControllerModel ansibleController = entityManager.find(AnsibleControllerModel.class, acName);
		return ansibleController;
	}

	public List<ConditionResultModel> getConditionResults(String string) {

		Query q = entityManager.createNativeQuery(
				"select cr.condResultIndex, cr.acName, cr.condId, cr.condSubId, cr.condResult, cond.condDesc, cr.msg from CONDITION_RESULT as cr LEFT JOIN CONDITION as cond ON cr.condId=cond.condId AND cr.condSubId = cond.condSubId",
				ConditionResultModel.class);

		return q.getResultList();
	}

}

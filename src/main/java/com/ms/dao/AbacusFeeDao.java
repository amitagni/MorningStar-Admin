package com.ms.dao;

import com.ms.dao.GenericDao;
import com.ms.entity.AbacusFee;
import com.ms.util.MSException;
import java.util.List;
import javax.persistence.Query;

public class AbacusFeeDao extends GenericDao<Integer, AbacusFee> {
	private static final long serialVersionUID = 1L;

	public void save(AbacusFee abacusFee) {
		if (abacusFee.getId() == null) {
			this.persist(abacusFee);
		} else {
			this.merge(abacusFee);
		}

	}

	public List<AbacusFee> findByStudentId(Integer studentId) throws MSException {
		Query jpaQuery = this.getEntityManager()
				.createQuery("Select af from AbacusFee af where af.studentId = :studentId  and af.status=1");
		jpaQuery.setParameter("studentId", studentId);
		List list = jpaQuery.getResultList();
		return list.size() > 0 ? list : null;
	}
}
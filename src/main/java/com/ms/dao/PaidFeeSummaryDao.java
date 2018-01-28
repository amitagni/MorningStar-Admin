package com.ms.dao;

import com.ms.dao.GenericDao;
import com.ms.entity.PaidFeeSummary;
import com.ms.util.MSException;
import java.util.List;
import javax.persistence.Query;

public class PaidFeeSummaryDao extends GenericDao<Integer, PaidFeeSummary> {
	private static final long serialVersionUID = 1L;

	public void save(PaidFeeSummary paidFeeSummary) {
		if (paidFeeSummary.getId() == null) {
			this.persist(paidFeeSummary);
		} else {
			this.merge(paidFeeSummary);
		}

	}

	public PaidFeeSummary findByStudentId(Integer studentId) throws MSException {
		Query jpaQuery = this.getEntityManager()
				.createQuery("Select fs from PaidFeeSummary fs where fs.studentId = :studentId");
		jpaQuery.setParameter("studentId", studentId);
		List list = jpaQuery.getResultList();
		return list.size() > 0 ? (PaidFeeSummary) list.get(0) : null;
	}
}
package com.ms.dao;

import com.ms.dao.GenericDao;
import com.ms.entity.FeeStructure;
import java.util.List;
import javax.persistence.Query;

public class FeeStructureDao extends GenericDao<Integer, FeeStructure> {
	private static final long serialVersionUID = 1L;

	public List<FeeStructure> findFeeForClassAndSession(Byte selClass, Byte session) {
		Query query = this.getEntityManager().createQuery(
				"Select x from FeeStructure x where x.className= :className and x.sessionName =:sessionName");
		query.setParameter("className", selClass);
		query.setParameter("sessionName", session);
		List list = query.getResultList();
		return list != null && list.size() > 0 ? list : null;
	}
}
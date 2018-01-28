package com.ms.dao;

import com.ms.dao.GenericDao;
import com.ms.entity.InventoryCateoryEntity;
import java.util.List;
import javax.persistence.Query;

public class CategoryDao extends GenericDao<Integer, InventoryCateoryEntity> {
	private static final long serialVersionUID = 1L;

	public List<InventoryCateoryEntity> findCateoriesByName(String categoryName) {
		Query query = this.getEntityManager().createQuery(
				"Select ct from InventoryCateoryEntity ct where ct.categoryName like (\'" + categoryName + "%\')");
		List list = query.getResultList();
		return list != null && list.size() > 0 ? list : null;
	}

	public InventoryCateoryEntity findCateoryByName(String categoryName) {
		Query query = this.getEntityManager().createQuery(
				"Select ct from InventoryCateoryEntity ct where ct.categoryName =\'" + categoryName + "\')");
		List list = query.getResultList();
		return list != null && list.size() > 0 ? (InventoryCateoryEntity) list.get(0) : null;
	}
}
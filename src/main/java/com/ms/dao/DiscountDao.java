package com.ms.dao;

import com.ms.dao.GenericDao;
import com.ms.entity.Discount;
import java.util.List;
import javax.persistence.Query;

public class DiscountDao extends GenericDao<Integer, Discount> {
	private static final long serialVersionUID = 1L;

	public void save(Discount discount) {
		if (discount.getId() == null) {
			this.persist(discount);
		} else {
			this.merge(discount);
		}

	}

	public List<Discount> findAllByType(Byte type) {
		Query query = this.getEntityManager()
				.createQuery("Select dis from Discount dis where dis.type=" + type + " and dis.active = 1");
		List list = query.getResultList();
		return list != null && list.size() > 0 ? list : null;
	}
}
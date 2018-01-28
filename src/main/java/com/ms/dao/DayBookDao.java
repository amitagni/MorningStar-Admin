package com.ms.dao;

import com.ms.dao.GenericDao;
import com.ms.entity.DayBook;
import com.ms.enums.TransactionType;
import java.sql.Date;
import java.util.List;
import javax.persistence.Query;

public class DayBookDao extends GenericDao<Integer, DayBook> {
	private static final long serialVersionUID = 1L;

	public List<DayBook> findDayBookEntryByDate(Date date) {
		Query query = this.getEntityManager()
				.createQuery("Select dbk from DayBook dbk where dbk.active = 1 and dbk.createdAt > \'" + date + "\'");
		List list = query.getResultList();
		return list != null && list.size() > 0 ? list : null;
	}

	public List<DayBook> findDayBookEntryByDateAndAccountId(Integer id, Byte trType, Date startDate, Date endDate) {
		Query query = null;
		if (trType == TransactionType.ALL.getCode()) {
			query = this.getEntityManager()
					.createQuery("Select dbk from DayBook dbk where dbk.accountId = " + id
							+ " and dbk.active = 1 and  dbk.createdAt >= \'" + startDate + "\' and dbk.createdAt <= \'"
							+ endDate + "\'");
		} else {
			query = this.getEntityManager()
					.createQuery("Select dbk from DayBook dbk where dbk.accountId = " + id
							+ " and dbk.active = 1 and dbk.transactionType =" + trType + " and dbk.createdAt >= \'"
							+ startDate + "\' and dbk.createdAt <= \'" + endDate + "\'");
		}

		List list = query.getResultList();
		return list != null && list.size() > 0 ? list : null;
	}
}
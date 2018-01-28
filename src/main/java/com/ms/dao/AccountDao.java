package com.ms.dao;

import com.ms.dao.GenericDao;
import com.ms.entity.Account;
import java.util.List;
import javax.persistence.Query;

public class AccountDao extends GenericDao<Integer, Account> {
	private static final long serialVersionUID = 1L;

	public List<Account> findAccountsByName(String accountName) {
		Query query = this.getEntityManager().createQuery(
				"Select ac from Account ac where ac.accountName like (\'" + accountName + "%\') and ac.active = 1 ");
		List list = query.getResultList();
		return list != null && list.size() > 0 ? list : null;
	}

	public Account findAccountByName(String accountName) {
		Query query = this.getEntityManager()
				.createQuery("Select ac from Account ac where ac.accountName =\'" + accountName + "\')");
		List list = query.getResultList();
		return list != null && list.size() > 0 ? (Account) list.get(0) : null;
	}
}
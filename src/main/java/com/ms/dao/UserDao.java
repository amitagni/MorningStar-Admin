package com.ms.dao;

import com.ms.dao.GenericDao;
import com.ms.entity.User;
import com.ms.util.MSException;
import java.util.List;
import javax.persistence.Query;

public class UserDao extends GenericDao<Integer, User> {
	private static final long serialVersionUID = 1L;

	public User findByEmailAndPassword(String email, String password) throws MSException {
		Query jpaQuery = this.getEntityManager()
				.createQuery("Select u from User u where u.email = :email and u.password = :password and u.status=1");
		jpaQuery.setParameter("email", email);
		jpaQuery.setParameter("password", password);
		List list = jpaQuery.getResultList();
		return list.size() > 0 ? (User) list.get(0) : null;
	}
}
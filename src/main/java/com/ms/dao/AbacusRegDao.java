package com.ms.dao;

import com.ms.dao.GenericDao;
import com.ms.entity.AbacusRegEntity;
import com.ms.entity.StudentReg;
import com.ms.util.MSException;
import java.util.List;
import javax.persistence.Query;

public class AbacusRegDao extends GenericDao<Integer, AbacusRegEntity> {
	private static final long serialVersionUID = 1L;

	public void save(AbacusRegEntity abacusRegEntity) {
		if (abacusRegEntity.getId() == null) {
			this.persist(abacusRegEntity);
		} else {
			this.merge(abacusRegEntity);
		}

	}

	public StudentReg findIdByNumber(String regNumber) throws MSException {
		Query jpaQuery = this.getEntityManager()
				.createQuery("Select r from StudentReg r where r.regNumber = " + regNumber);
		StudentReg studentReg = (StudentReg) jpaQuery.getSingleResult();
		return studentReg;
	}

	public List<AbacusRegEntity> findStudentByName(String studentName) throws MSException {
		Query jpaQuery = this.getEntityManager()
				.createQuery("Select r from AbacusRegEntity r where r.firstName like (\'" + studentName + "%\')");
		List studentList = jpaQuery.getResultList();
		return studentList;
	}
}
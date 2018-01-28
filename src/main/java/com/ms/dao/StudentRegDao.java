package com.ms.dao;

import com.ms.dao.GenericDao;
import com.ms.entity.StudentReg;
import com.ms.util.MSException;
import javax.persistence.Query;

public class StudentRegDao extends GenericDao<Integer, StudentReg> {
	private static final long serialVersionUID = 1L;

	public void save(StudentReg studentReg) {
		if (studentReg.getId() == null) {
			this.persist(studentReg);
		} else {
			this.merge(studentReg);
		}

	}

	public StudentReg findIdByNumber(String regNumber) throws MSException {
		Query jpaQuery = this.getEntityManager()
				.createQuery("Select r from StudentReg r where r.regNumber = " + regNumber);
		StudentReg studentReg = (StudentReg) jpaQuery.getSingleResult();
		return studentReg;
	}
}
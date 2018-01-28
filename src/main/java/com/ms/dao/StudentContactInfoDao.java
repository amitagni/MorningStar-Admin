package com.ms.dao;

import com.ms.dao.GenericDao;
import com.ms.entity.StudentContactInfo;
import javax.persistence.Query;

public class StudentContactInfoDao extends GenericDao<Integer, StudentContactInfo> {
	private static final long serialVersionUID = 1L;

	public void save(StudentContactInfo studentContactInfo) {
		if (studentContactInfo.getId() == null) {
			this.persist(studentContactInfo);
		} else {
			this.merge(studentContactInfo);
		}

	}

	public StudentContactInfo findStudentContactInfoByStudentId(Integer studentId) {
		Query query = this.getEntityManager()
				.createQuery("Select st from StudentContactInfo st where st.studentId =" + studentId);
		StudentContactInfo studentContactInfo = (StudentContactInfo) query.getSingleResult();
		return studentContactInfo;
	}
}
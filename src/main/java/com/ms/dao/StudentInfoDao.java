package com.ms.dao;

import com.ms.dao.GenericDao;
import com.ms.entity.StudentInfo;
import java.util.List;
import javax.persistence.Query;

public class StudentInfoDao extends GenericDao<Integer, StudentInfo> {
	private static final long serialVersionUID = 1L;

	public void save(StudentInfo studentInfo) {
		if (studentInfo.getId() == null) {
			this.persist(studentInfo);
		} else {
			this.merge(studentInfo);
		}

	}

	public List<StudentInfo> findStudentsByName(String studentName) {
		Query query = this.getEntityManager()
				.createQuery("Select st from StudentInfo st where st.firstName like (\'" + studentName + "%\')");
		List list = query.getResultList();
		return list != null && list.size() > 0 ? list : null;
	}

	public StudentInfo findStudentByRegNum(String regNum) throws Exception {
		Query query = this.getEntityManager().createQuery("Select st from StudentInfo st where st.regId =" + regNum);
		StudentInfo studentInfo = (StudentInfo) query.getSingleResult();
		return studentInfo;
	}
}
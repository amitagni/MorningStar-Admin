package com.ms.service;

import com.ms.dao.AbacusRegDao;
import com.ms.dao.StudentInfoDao;
import com.ms.entity.AbacusRegEntity;
import com.ms.entity.StudentInfo;
import com.ms.util.MSException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchService {
	@Autowired
	private StudentInfoDao studentInfoDao;
	@Autowired
	private AbacusRegDao abacusRegDao;

	public List<StudentInfo> findStudentsByName(String studentName) {
		return this.studentInfoDao.findStudentsByName(studentName);
	}

	public List<AbacusRegEntity> findAbacusStudentsByName(String studentName) {
		try {
			return this.abacusRegDao.findStudentByName(studentName);
		} catch (MSException arg2) {
			arg2.printStackTrace();
			return null;
		}
	}

	public StudentInfo findStudentsById(Integer id) {
		List studentList = null;

		try {
			studentList = this.studentInfoDao.findByID(id, StudentInfo.class);
		} catch (MSException arg3) {
			arg3.printStackTrace();
		}

		return studentList != null && studentList.size() > 0 ? (StudentInfo) studentList.get(0) : null;
	}

	public AbacusRegEntity findAbacusStudentsById(Integer id) {
		List studentList = null;

		try {
			studentList = this.abacusRegDao.findByID(id, AbacusRegEntity.class);
		} catch (MSException arg3) {
			arg3.printStackTrace();
		}

		return studentList != null && studentList.size() > 0 ? (AbacusRegEntity) studentList.get(0) : null;
	}
}
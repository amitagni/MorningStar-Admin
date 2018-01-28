package com.ms.service;

import com.ms.dao.StudentContactInfoDao;
import com.ms.dao.StudentInfoDao;
import com.ms.dao.StudentRegDao;
import com.ms.entity.StudentContactInfo;
import com.ms.entity.StudentInfo;
import com.ms.entity.StudentReg;
import com.ms.util.MSException;
import javax.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrationService {
	@Autowired
	private StudentRegDao studentRegDao;
	@Autowired
	private StudentInfoDao studentInfoDao;
	@Autowired
	private StudentContactInfoDao studentContactInfoDao;

	@Transactional(rollbackFor = {Exception.class})
	public void save(StudentReg studentReg, StudentInfo studentInfo, StudentContactInfo studentContactInfo)
			throws MSException {
		this.studentRegDao.save(studentReg);
		studentInfo.setRegId(studentReg.getId());
		this.studentInfoDao.save(studentInfo);
		studentContactInfo.setStudentId(studentInfo.getId());
		this.studentContactInfoDao.save(studentContactInfo);
		this.studentContactInfoDao.flush();
	}

	public StudentReg findIdByNumber(String regNumber) throws MSException {
		StudentReg studentReg = null;

		try {
			studentReg = this.studentRegDao.findIdByNumber(regNumber);
		} catch (NoResultException arg3) {
			;
		}

		return studentReg;
	}

	public StudentReg findId(Integer id) throws MSException {
		StudentReg studentReg = null;

		try {
			studentReg = (StudentReg) this.studentRegDao.findById(id, StudentReg.class);
		} catch (NoResultException arg3) {
			;
		}

		return studentReg;
	}
}
package com.ms.service;

import com.ms.dao.DiscountDao;
import com.ms.dao.StudentContactInfoDao;
import com.ms.dao.StudentInfoDao;
import com.ms.entity.Discount;
import com.ms.entity.StudentContactInfo;
import com.ms.entity.StudentInfo;
import com.ms.util.MSException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdmissionService {
	@Autowired
	public StudentInfoDao studentInfoDao;
	@Autowired
	public StudentContactInfoDao studentContactInfoDao;
	@Autowired
	public DiscountDao discountDao;

	@Transactional(rollbackFor = {Exception.class})
	public void save(StudentInfo studentInfo, StudentContactInfo studentContactInfo) throws MSException {
		this.studentInfoDao.save(studentInfo);
		studentContactInfo.setStudentId(studentInfo.getId());
		this.studentContactInfoDao.save(studentContactInfo);
		this.studentContactInfoDao.flush();
	}

	@Transactional(rollbackFor = {Exception.class})
	public void save(StudentInfo studentInfo) throws MSException {
		this.studentInfoDao.save(studentInfo);
	}

	public StudentInfo findStudentById(Integer id) {
		try {
			List e = this.studentInfoDao.findByID(id, StudentInfo.class);
			return e != null && e.size() > 0 ? (StudentInfo) e.get(0) : null;
		} catch (MSException arg2) {
			arg2.printStackTrace();
			return null;
		}
	}

	public StudentInfo findStudentByRegNum(String regNum) {
		StudentInfo studentInfo = null;

		try {
			studentInfo = this.studentInfoDao.findStudentByRegNum(regNum);
		} catch (Exception arg3) {
			arg3.printStackTrace();
		}

		return studentInfo;
	}

	public StudentContactInfo findStudentContactInfoByStudentId(Integer studentId) {
		StudentContactInfo studentContactInfo = null;

		try {
			studentContactInfo = this.studentContactInfoDao.findStudentContactInfoByStudentId(studentId);
		} catch (Exception arg3) {
			arg3.printStackTrace();
		}

		return studentContactInfo;
	}

	public List<Discount> findAllDiscountsByPredefinedType() {
		List discountList = null;

		try {
			discountList = this.discountDao.findAllByType(Byte.valueOf((byte) 0));
		} catch (Exception arg2) {
			arg2.printStackTrace();
		}

		return discountList;
	}

	public List<Discount> findAllDiscountsByMagmt() {
		List discountList = null;

		try {
			discountList = this.discountDao.findAllByType(Byte.valueOf((byte) 1));
		} catch (Exception arg2) {
			arg2.printStackTrace();
		}

		return discountList;
	}
}
package com.ms.service;

import com.ms.dao.PaymentDao;
import com.ms.entity.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentService {
	@Autowired
	public PaymentDao paymentDao;

	@Transactional(rollbackFor = {Exception.class})
	public void save(Payment payment) {
		this.paymentDao.save(payment);
	}

	public Payment findByStudentId(Integer studentId, Byte feeType) {
		return this.paymentDao.findByStudentId(studentId, feeType);
	}
}
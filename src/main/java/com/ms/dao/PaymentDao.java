package com.ms.dao;

import com.ms.dao.GenericDao;
import com.ms.entity.Payment;
import javax.persistence.Query;

public class PaymentDao extends GenericDao<Integer, Payment> {
	private static final long serialVersionUID = 1L;

	public void save(Payment payment) {
		if (payment.getId() == null) {
			this.persist(payment);
		} else {
			this.merge(payment);
		}

	}

	public Payment findByStudentId(Integer studentId, Byte feeType) {
		Payment payment = null;
		Query jpaQuery = this.getEntityManager().createQuery(
				"Select p from Payment p where p.studentId = " + studentId + " and p.feeType = " + feeType);

		try {
			payment = (Payment) jpaQuery.getSingleResult();
		} catch (Exception arg5) {
			arg5.printStackTrace();
		}

		return payment;
	}
}
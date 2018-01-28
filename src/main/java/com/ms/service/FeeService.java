package com.ms.service;

import com.ms.dao.FeeSlipDao;
import com.ms.dao.FeeStructureDao;
import com.ms.dao.PaidFeeSummaryDao;
import com.ms.entity.FeeSlip;
import com.ms.entity.FeeStructure;
import com.ms.entity.PaidFeeSummary;
import com.ms.util.MSException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FeeService {
	@Autowired
	private FeeStructureDao feeStructureDao;
	@Autowired
	private FeeSlipDao feeSlipDao;
	@Autowired
	private PaidFeeSummaryDao paidFeeSummaryDao;

	public List<FeeStructure> findFeeForClassAndSession(Byte selClass, Byte session) {
		return this.feeStructureDao.findFeeForClassAndSession(selClass, session);
	}

	@Transactional(rollbackFor = {Exception.class})
	public void save(FeeSlip feeSlip) {
		this.feeSlipDao.save(feeSlip);
	}

	@Transactional(rollbackFor = {Exception.class})
	public void save(PaidFeeSummary paidFeeSummary) {
		this.paidFeeSummaryDao.save(paidFeeSummary);
	}

	public List<FeeSlip> findFeeSlips(String ids) throws MSException {
		return this.feeSlipDao.findFeeSlips(ids);
	}

	public PaidFeeSummary findByStudentId(Integer studentId) throws MSException {
		return this.paidFeeSummaryDao.findByStudentId(studentId);
	}

	public List<Object> generateFeeSlipData(String paymentId) throws MSException {
		return this.feeSlipDao.generateFeeSlipData(paymentId);
	}
}
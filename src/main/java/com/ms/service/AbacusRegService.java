package com.ms.service;

import com.ms.dao.AbacusFeeDao;
import com.ms.dao.AbacusRegDao;
import com.ms.entity.AbacusFee;
import com.ms.entity.AbacusRegEntity;
import com.ms.util.MSException;
import java.util.List;
import javax.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AbacusRegService {
	@Autowired
	private AbacusRegDao abacusRegDao;
	@Autowired
	private AbacusFeeDao abacusFeeDao;

	@Transactional(rollbackFor = {Exception.class})
	public void saveAbacusRegBean(AbacusRegEntity abacusRegEntity) throws MSException {
		this.abacusRegDao.save(abacusRegEntity);
	}

	@Transactional(rollbackFor = {Exception.class})
	public void saveAbacusFee(AbacusFee abacusFee) throws MSException {
		this.abacusFeeDao.save(abacusFee);
	}

	public AbacusRegEntity findId(Integer id) throws MSException {
		AbacusRegEntity abacusRegEntity = null;

		try {
			abacusRegEntity = (AbacusRegEntity) this.abacusRegDao.findById(id, AbacusRegEntity.class);
		} catch (NoResultException arg3) {
			;
		}

		return abacusRegEntity;
	}

	public AbacusFee findFeeById(Integer id) throws MSException {
		AbacusFee abacusFee = null;

		try {
			abacusFee = (AbacusFee) this.abacusFeeDao.findById(id, AbacusFee.class);
		} catch (NoResultException arg3) {
			;
		}

		return abacusFee;
	}

	public List<AbacusFee> findByStudentId(Integer studentId) throws MSException {
		List abacusFeeList = null;

		try {
			abacusFeeList = this.abacusFeeDao.findByStudentId(studentId);
		} catch (NoResultException arg3) {
			;
		}

		return abacusFeeList;
	}
}
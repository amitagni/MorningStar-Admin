package com.ms.dao;

import com.ms.dao.GenericDao;
import com.ms.entity.FeeSlip;
import com.ms.util.MSException;
import java.util.List;
import javax.persistence.Query;

public class FeeSlipDao extends GenericDao<Integer, FeeSlip> {
	private static final long serialVersionUID = 1L;

	public void save(FeeSlip feeSlip) {
		if (feeSlip.getId() == null) {
			this.persist(feeSlip);
		} else {
			this.merge(feeSlip);
		}

	}

	public List<FeeSlip> findFeeSlips(String ids) throws MSException {
		Query jpaQuery = this.getEntityManager().createQuery("Select f from FeeSlip f where f.id in(" + ids + ")");
		List list = jpaQuery.getResultList();
		return list;
	}

	public List<Object> generateFeeSlipData(String paymentId) throws MSException {
		Query jpaQuery = this.getEntityManager().createNativeQuery(
				"select fs.amount,fs.discount,f_st.fee_freq_type,f_st.abbr_name,fs.month,py.student_id,py.add_discount_amt from fee_slip fs,fee_structure f_st,payment py where fs.fee_structure_id = f_st.id && py.id = fs.payment_id && py.id = "
						+ paymentId);
		List list = jpaQuery.getResultList();
		return list;
	}
}
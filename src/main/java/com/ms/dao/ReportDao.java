package com.ms.dao;

import com.ms.util.DBUtil;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReportDao {
	@Autowired
	private DBUtil dbUtil;

	public ResultSet fetchAllStudentFeeReport(Byte feeType, Integer offset) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		try {
			con = this.dbUtil.getConnection();
			ps = con.prepareStatement(
					"select st.id,st.first_name, st.last_name,st.father_name,sci.phone,st.current_class,st.section,sum(amount) amount,sum(discount_amt) discount,pfs.monthly_freq monthly,pfs.quaterly_freq quaterly,pfs.halfyearly_freq halfyearly,pfs.annually_freq anually from student_info st left join student_contact_info sci on sci.student_id = st.id left join payment p on p.student_id = st.id and p.fee_type = "
							+ feeType + " left join paid_fee_summary pfs on pfs.student_id = st.id group by st.id");
			rs = ps.executeQuery();
		} catch (Exception arg6) {
			arg6.printStackTrace();
		}

		return rs;
	}

	public ResultSet fetchStudentFeeReport(String studentId, Byte feeType) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		try {
			con = this.dbUtil.getConnection();
			ps = con.prepareStatement(
					"select st.id,st.first_name, st.last_name,st.father_name,sci.phone,st.current_class,st.section,sum(amount) amount,sum(discount_amt) discount,pfs.monthly_freq monthly,pfs.quaterly_freq quaterly,pfs.halfyearly_freq halfyearly,pfs.annually_freq anually from student_info st left join student_contact_info sci on sci.student_id = st.id  left join payment p on p.student_id = st.id and p.fee_type = "
							+ feeType + " left join paid_fee_summary pfs on pfs.student_id = st.id where st.id = "
							+ studentId + "  group by st.id");
			rs = ps.executeQuery();
		} catch (Exception arg6) {
			arg6.printStackTrace();
		}

		return rs;
	}

	public ResultSet fetchAllStudentFeeReport(String currentClass, Byte feeType) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		try {
			con = this.dbUtil.getConnection();
			ps = con.prepareStatement(
					"select st.id,st.first_name, st.last_name,st.father_name,sci.phone,st.current_class,st.section,sum(amount) amount,sum(discount_amt) discount,pfs.monthly_freq monthly,pfs.quaterly_freq quaterly,pfs.halfyearly_freq halfyearly,pfs.annually_freq anually from student_info st left join student_contact_info sci on sci.student_id = st.id  left join payment p on p.student_id = st.id and p.fee_type = "
							+ feeType
							+ " left join paid_fee_summary pfs on pfs.student_id = st.id where st.current_class = "
							+ currentClass + " group by st.id");
			rs = ps.executeQuery();
		} catch (Exception arg6) {
			arg6.printStackTrace();
		}

		return rs;
	}

	public ResultSet fetchFeeStructureDataForCache() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		try {
			con = this.dbUtil.getConnection();
			ps = con.prepareStatement("select id,abbr_name from fee_structure where fee_freq_type != 4");
			rs = ps.executeQuery();
		} catch (Exception arg4) {
			arg4.printStackTrace();
		}

		return rs;
	}

	public ResultSet fetchStudentNotTakenAdmission() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Connection con = null;

		try {
			con = this.dbUtil.getConnection();
			ps = con.prepareStatement(
					"select * from student_reg sr ,student_info sf  where not exists (select 1 from student_info si where si.reg_id = sr.id limit 1");
			rs = ps.executeQuery();
		} catch (Exception arg4) {
			arg4.printStackTrace();
		}

		return rs;
	}
}
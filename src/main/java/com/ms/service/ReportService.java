package com.ms.service;

import com.ms.dao.ReportDao;
import com.ms.dto.StudentFeeReportDTO;
import com.ms.enums.FeeType;
import com.ms.enums.Month;
import com.ms.enums.Section;
import com.ms.enums.StudentClass;
import com.ms.util.MSUtil;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService {
	Map<String, String> map = null;
	@Autowired
	private ReportDao reportDao;

	public List<Object> fetchAllStudentFeeReport(Integer offset) {
		ArrayList dataList = new ArrayList();
		ResultSet rs = this.reportDao.fetchAllStudentFeeReport(FeeType.REGULARFEES.getCode(), offset);
		double amount = 0.0D;
		double disAmount = 0.0D;
		int notPaid_recordCount = 0;
		if (rs != null) {
			ArrayList dtoList = new ArrayList();

			StudentFeeReportDTO e;
			try {
				for (; rs.next(); dtoList.add(e)) {
					e = new StudentFeeReportDTO();
					e.setStudentName(rs.getString("first_name") + " " + rs.getString("last_name"));
					e.setStudentFatherName(rs.getString("father_name"));
					e.setPaidAmount(MSUtil.formatValue(rs.getString("amount")));
					e.setDiscAmount(MSUtil.formatValue(rs.getString("discount")));
					e.setPhone(rs.getString("phone"));
					e.setMonthlyPaid(this.getAbbrebiation(rs.getString("monthly"), true));
					e.setQuterlyPaid(this.getAbbrebiation(rs.getString("quaterly"), false));
					e.setHalfyearlyPaid(this.getAbbrebiation(rs.getString("halfyearly"), false));
					e.setAnuallyPaid(this.getAbbrebiation(rs.getString("anually"), false));
					e.setStudentClass(StudentClass.findNameByCode(Byte.valueOf(rs.getByte("current_class"))));
					e.setSection(Section.findNameByCode(Byte.valueOf(rs.getByte("section"))));
					if (rs.getString("amount") != null) {
						amount += Double.parseDouble(rs.getString("amount"));
					}

					if (rs.getString("discount") != null) {
						disAmount += Double.parseDouble(rs.getString("discount"));
					}

					if (e.getMonthlyPaid() == null && e.getQuterlyPaid() == null && e.getHalfyearlyPaid() == null
							&& e.getAnuallyPaid() == null) {
						e.setNotPaid(true);
						++notPaid_recordCount;
					}
				}
			} catch (SQLException arg10) {
				arg10.printStackTrace();
			}

			dataList.add(dtoList);
			dataList.add(MSUtil.formatValue(String.valueOf(amount)));
			dataList.add(MSUtil.formatValue(String.valueOf(disAmount)));
			dataList.add(Integer.valueOf(dtoList.size() - notPaid_recordCount));
			dataList.add(Integer.valueOf(notPaid_recordCount));
		}

		return dataList;
	}

	public List<Object> fetchAllStudentFeeReport(String currentClass) {
		ArrayList dataList = new ArrayList();
		ResultSet rs = this.reportDao.fetchAllStudentFeeReport(currentClass, FeeType.REGULARFEES.getCode());
		double amount = 0.0D;
		double disAmount = 0.0D;
		int notPaid_recordCount = 0;
		if (rs != null) {
			ArrayList dtoList = new ArrayList();

			StudentFeeReportDTO e;
			try {
				for (; rs.next(); dtoList.add(e)) {
					e = new StudentFeeReportDTO();
					e.setStudentName(rs.getString("first_name") + " " + rs.getString("last_name"));
					e.setStudentFatherName(rs.getString("father_name"));
					e.setPaidAmount(MSUtil.formatValue(rs.getString("amount")));
					e.setDiscAmount(MSUtil.formatValue(rs.getString("discount")));
					e.setMonthlyPaid(this.getAbbrebiation(rs.getString("monthly"), true));
					e.setQuterlyPaid(this.getAbbrebiation(rs.getString("quaterly"), false));
					e.setHalfyearlyPaid(this.getAbbrebiation(rs.getString("halfyearly"), false));
					e.setAnuallyPaid(this.getAbbrebiation(rs.getString("anually"), false));
					e.setPhone(rs.getString("phone"));
					e.setStudentClass(StudentClass.findNameByCode(Byte.valueOf(rs.getByte("current_class"))));
					e.setSection(Section.findNameByCode(Byte.valueOf(rs.getByte("section"))));
					if (rs.getString("amount") != null) {
						amount += Double.parseDouble(rs.getString("amount"));
					}

					if (rs.getString("discount") != null) {
						disAmount += Double.parseDouble(rs.getString("discount"));
					}

					if (e.getMonthlyPaid() == null && e.getQuterlyPaid() == null && e.getHalfyearlyPaid() == null
							&& e.getAnuallyPaid() == null) {
						e.setNotPaid(true);
						++notPaid_recordCount;
					}
				}
			} catch (SQLException arg10) {
				arg10.printStackTrace();
			}

			dataList.add(dtoList);
			dataList.add(MSUtil.formatValue(String.valueOf(amount)));
			dataList.add(MSUtil.formatValue(String.valueOf(disAmount)));
			dataList.add(Integer.valueOf(dtoList.size() - notPaid_recordCount));
			dataList.add(Integer.valueOf(notPaid_recordCount));
		}

		return dataList;
	}

	public List<Object> fetchStudentFeeReport(String studentId) {
		ArrayList dataList = new ArrayList();
		ResultSet rs = this.reportDao.fetchStudentFeeReport(studentId, FeeType.REGULARFEES.getCode());
		double amount = 0.0D;
		double disAmount = 0.0D;
		int notPaid_recordCount = 0;
		if (rs != null) {
			ArrayList dtoList = new ArrayList();

			StudentFeeReportDTO e;
			try {
				for (; rs.next(); dtoList.add(e)) {
					e = new StudentFeeReportDTO();
					e.setStudentName(rs.getString("first_name") + " " + rs.getString("last_name"));
					e.setStudentFatherName(rs.getString("father_name"));
					e.setPaidAmount(MSUtil.formatValue(rs.getString("amount")));
					e.setDiscAmount(MSUtil.formatValue(rs.getString("discount")));
					e.setMonthlyPaid(this.getAbbrebiation(rs.getString("monthly"), true));
					e.setQuterlyPaid(this.getAbbrebiation(rs.getString("quaterly"), false));
					e.setHalfyearlyPaid(this.getAbbrebiation(rs.getString("halfyearly"), false));
					e.setAnuallyPaid(this.getAbbrebiation(rs.getString("anually"), false));
					e.setStudentClass(StudentClass.findNameByCode(Byte.valueOf(rs.getByte("current_class"))));
					e.setSection(Section.findNameByCode(Byte.valueOf(rs.getByte("section"))));
					e.setPhone(rs.getString("phone"));
					if (rs.getString("amount") != null) {
						amount += Double.parseDouble(rs.getString("amount"));
					}

					if (rs.getString("discount") != null) {
						disAmount += Double.parseDouble(rs.getString("discount"));
					}

					if (e.getMonthlyPaid() == null && e.getQuterlyPaid() == null && e.getHalfyearlyPaid() == null
							&& e.getAnuallyPaid() == null) {
						e.setNotPaid(true);
						++notPaid_recordCount;
					}
				}
			} catch (SQLException arg10) {
				arg10.printStackTrace();
			}

			dataList.add(dtoList);
			dataList.add(MSUtil.formatValue(String.valueOf(amount)));
			dataList.add(MSUtil.formatValue(String.valueOf(disAmount)));
			dataList.add("N/A");
			dataList.add("N/A");
		}

		return dataList;
	}

	public List<StudentFeeReportDTO> fetchStudentNotTakenAdmission() {
		ArrayList dataList = new ArrayList();
		ResultSet rs = this.reportDao.fetchStudentNotTakenAdmission();
		if (rs != null) {
			try {
				while (rs.next()) {
					StudentFeeReportDTO e = new StudentFeeReportDTO();
					e.setStudentName(rs.getString("first_name") + " " + rs.getString("last_name"));
					e.setStudentFatherName(rs.getString("father_name"));
					e.setPhone(rs.getString("phone"));
					e.setAdmissionClass("admission_class");
					e.setLastSchool("last_school");
					dataList.add(e);
				}
			} catch (SQLException arg3) {
				arg3.printStackTrace();
			}
		}

		return dataList;
	}

	private String getAbbrebiation(String paiddata, boolean isMontly) {
		if (paiddata != null && !paiddata.equals("null")) {
			List list = MSUtil.tokenizeList(paiddata);
			StringBuilder data = new StringBuilder();
			int i;
			if (isMontly) {
				i = 1;

				for (Iterator str = list.iterator(); str.hasNext(); ++i) {
					String feeStructureCache = (String) str.next();
					data.append(Month.findAbbrByCode(Byte.valueOf(Byte.parseByte(feeStructureCache))));
					data.append(',');
					if (i % 4 == 0) {
						data.append(' ');
					}
				}
			} else {
				i = 1;
				Map arg8 = this.fetchFeeStructureDataForCache();

				for (Iterator arg7 = list.iterator(); arg7.hasNext(); ++i) {
					String arg9 = (String) arg7.next();
					data.append((String) arg8.get(arg9));
					data.append(',');
					if (i % 4 == 0) {
						data.append(' ');
					}
				}
			}

			return data.toString();
		} else {
			return null;
		}
	}

	public Map<String, String> fetchFeeStructureDataForCache() {
		if (this.map == null) {
			ResultSet rs = this.reportDao.fetchFeeStructureDataForCache();
			if (rs != null) {
				this.map = new HashMap();

				try {
					while (rs.next()) {
						this.map.put(String.valueOf(rs.getInt("id")), rs.getString("abbr_name"));
					}
				} catch (SQLException arg2) {
					arg2.printStackTrace();
				}
			}
		}

		return this.map;
	}
}
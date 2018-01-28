package com.ms.util;

import com.ms.bean.ContactDetails;
import com.ms.bean.StudentDetails;
import com.ms.entity.StudentContactInfo;
import com.ms.entity.StudentInfo;
import com.ms.enums.Category;
import com.ms.enums.House;
import com.ms.enums.Month;
import com.ms.enums.Nationality;
import com.ms.enums.Religion;
import com.ms.enums.Result;
import com.ms.enums.Section;
import com.ms.enums.State;
import com.ms.enums.StudentClass;
import com.ms.util.SessionUtil;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class MSUtil {
	private static DecimalFormat grpdf = new DecimalFormat("####,###,##0.00");

	public static List<Category> populateCategoryList() {
		ArrayList categorieList = new ArrayList();
		Category[] arg3;
		int arg2 = (arg3 = Category.values()).length;

		for (int arg1 = 0; arg1 < arg2; ++arg1) {
			Category category = arg3[arg1];
			categorieList.add(category);
		}

		return categorieList;
	}

	public static List<State> populateStateList() {
		ArrayList stateList = new ArrayList();
		State[] arg3;
		int arg2 = (arg3 = State.values()).length;

		for (int arg1 = 0; arg1 < arg2; ++arg1) {
			State state = arg3[arg1];
			stateList.add(state);
		}

		return stateList;
	}

	public static List<StudentClass> populateClassList() {
		ArrayList classList = new ArrayList();
		StudentClass[] arg3;
		int arg2 = (arg3 = StudentClass.values()).length;

		for (int arg1 = 0; arg1 < arg2; ++arg1) {
			StudentClass stClass = arg3[arg1];
			classList.add(stClass);
		}

		return classList;
	}

	public static List<Section> populateSectionList() {
		ArrayList sectionList = new ArrayList();
		Section[] arg3;
		int arg2 = (arg3 = Section.values()).length;

		for (int arg1 = 0; arg1 < arg2; ++arg1) {
			Section section = arg3[arg1];
			sectionList.add(section);
		}

		return sectionList;
	}

	public static List<House> populateHouseList() {
		ArrayList houseList = new ArrayList();
		House[] arg3;
		int arg2 = (arg3 = House.values()).length;

		for (int arg1 = 0; arg1 < arg2; ++arg1) {
			House house = arg3[arg1];
			houseList.add(house);
		}

		return houseList;
	}

	public static List<Month> populateMonthList() {
		ArrayList monthList = new ArrayList();
		Month[] arg3;
		int arg2 = (arg3 = Month.values()).length;

		for (int arg1 = 0; arg1 < arg2; ++arg1) {
			Month month = arg3[arg1];
			monthList.add(month);
		}

		return monthList;
	}

	public static List<Result> populateResultList() {
		ArrayList resultList = new ArrayList();
		Result[] arg3;
		int arg2 = (arg3 = Result.values()).length;

		for (int arg1 = 0; arg1 < arg2; ++arg1) {
			Result result = arg3[arg1];
			resultList.add(result);
		}

		return resultList;
	}

	public static List<Religion> populateReligionList() {
		ArrayList religionList = new ArrayList();
		Religion[] arg3;
		int arg2 = (arg3 = Religion.values()).length;

		for (int arg1 = 0; arg1 < arg2; ++arg1) {
			Religion religion = arg3[arg1];
			religionList.add(religion);
		}

		return religionList;
	}

	public static List<Nationality> populateNationalityList() {
		ArrayList nationalityList = new ArrayList();
		Nationality[] arg3;
		int arg2 = (arg3 = Nationality.values()).length;

		for (int arg1 = 0; arg1 < arg2; ++arg1) {
			Nationality nationality = arg3[arg1];
			nationalityList.add(nationality);
		}

		return nationalityList;
	}

	public static StudentContactInfo populateContactInfo(ContactDetails contactDetails) {
		StudentContactInfo studentContactInfo = new StudentContactInfo();
		studentContactInfo.setId(contactDetails.getId());
		studentContactInfo.setAddress1(contactDetails.getAddress1());
		studentContactInfo.setAddress2(contactDetails.getAddress2());
		studentContactInfo.setArea(contactDetails.getArea());
		studentContactInfo.setCity(contactDetails.getCity());
		studentContactInfo.setState(contactDetails.getState());
		studentContactInfo.setPincode(contactDetails.getPincode());
		studentContactInfo.setPhone(contactDetails.getPhone());
		studentContactInfo.setMobile(contactDetails.getMobile());
		studentContactInfo.setEmail(contactDetails.getEmail());
		studentContactInfo.setCreatedBy(SessionUtil.getUser().getId());
		return studentContactInfo;
	}

	public static String getStudentDocDirectoryPath() {
		String dataDirPath = SessionUtil.getDeploymentPath();
		System.out.println("----------dataDirPath----------------" + dataDirPath);
		String uploadDirPath = dataDirPath + File.separator + "upload_doc";
		System.out.println(
				"----------------------U\tpload Path-------------------------------------------" + uploadDirPath);
		File reportDir = new File(uploadDirPath);
		if (!reportDir.exists()) {
			reportDir.mkdir();
		}

		return uploadDirPath;
	}

	public static StudentInfo populateStudentInfo(StudentDetails studentDetails) {
		StudentInfo studentInfo = new StudentInfo();
		studentInfo.setId(studentDetails.getId());
		studentInfo.setRegId(studentDetails.getRegId());
		studentInfo.setFirstName(studentDetails.getFirstName());
		studentInfo.setLastName(studentDetails.getLastName());
		studentInfo.setDob(studentDetails.getDob());
		studentInfo.setFatherName(studentDetails.getFatherName());
		studentInfo.setMotherName(studentDetails.getMotherName());
		studentInfo.setAdmissionClass(Byte.valueOf(studentDetails.getStudentAdmissionClass()));
		studentInfo.setCurrentClass(Byte.valueOf(studentDetails.getStudentAdmissionClass()));
		studentInfo.setCategory(Byte.valueOf(studentDetails.getCategory()));
		studentInfo.setSection(Byte.valueOf(studentDetails.getSection()));
		studentInfo.setHouse(Byte.valueOf(studentDetails.getHouse()));
		studentInfo.setNationality(studentDetails.getNationality());
		studentInfo.setReligion(studentDetails.getReligion());
		studentInfo.setCaste(studentDetails.getCaste());
		studentInfo.setGender(studentDetails.getGender());
		studentInfo.setFatherOccupation(studentDetails.getFatherOccupation());
		studentInfo.setCreatedBy(SessionUtil.getUser().getId());
		StringBuilder subjects = new StringBuilder();
		if (studentDetails.getSubjects() != null) {
			byte[] arg5;
			int arg4 = (arg5 = studentDetails.getSubjects()).length;

			for (int arg3 = 0; arg3 < arg4; ++arg3) {
				Byte subject = Byte.valueOf(arg5[arg3]);
				subjects.append(subject);
				subjects.append(",");
			}
		}

		studentInfo.setSubjects(subjects.toString());
		return studentInfo;
	}

	public static boolean isEmpty(String value) {
		return value == null ? true : value.trim().equals("");
	}

	public static String formatValue(float value) {
		return grpdf.format((double) value);
	}

	public static List<String> tokenizeList(String str) {
		ArrayList retList = new ArrayList();
		if (str != null) {
			StringTokenizer stringTokenizer = new StringTokenizer(str, ",");

			while (stringTokenizer.hasMoreElements()) {
				retList.add((String) stringTokenizer.nextElement());
			}
		}

		return retList;
	}

	public static String formatValue(String value) {
		if (value != null && !value.equals("N/A") && !value.equals("")) {
			try {
				float e = Float.parseFloat(value);
				String formatVal = grpdf.format((double) e);
				if (formatVal.equals("-0.00")) {
					formatVal = "0.00";
				}

				return formatVal;
			} catch (NumberFormatException arg2) {
				return "N/A";
			}
		} else {
			return "N/A";
		}
	}
}
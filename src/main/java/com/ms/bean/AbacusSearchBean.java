package com.ms.bean;

import com.ms.bean.FormBean;
import com.ms.dto.FeeMonthsDTO;
import java.util.List;

public class AbacusSearchBean extends FormBean {
	private int id;
	private String name;
	private String fatherName;
	private byte regFee;
	private List<FeeMonthsDTO> monthList;
	private String selMonth;
	private Integer regAmt;
	private Integer monthlyAmt;
	private Integer totalAmt;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFatherName() {
		return this.fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public List<FeeMonthsDTO> getMonthList() {
		return this.monthList;
	}

	public void setMonthList(List<FeeMonthsDTO> monthList) {
		this.monthList = monthList;
	}

	public String getSelMonth() {
		return this.selMonth;
	}

	public void setSelMonth(String selMonth) {
		this.selMonth = selMonth;
	}

	public Integer getTotalAmt() {
		return this.totalAmt;
	}

	public void setTotalAmt(Integer totalAmt) {
		this.totalAmt = totalAmt;
	}

	public byte getRegFee() {
		return this.regFee;
	}

	public void setRegFee(byte regFee) {
		this.regFee = regFee;
	}

	public Integer getRegAmt() {
		return this.regAmt;
	}

	public void setRegAmt(Integer regAmt) {
		this.regAmt = regAmt;
	}

	public Integer getMonthlyAmt() {
		return this.monthlyAmt;
	}

	public void setMonthlyAmt(Integer monthlyAmt) {
		this.monthlyAmt = monthlyAmt;
	}
}
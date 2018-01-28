package com.ms.bean;

import com.ms.bean.FormBean;
import com.ms.dto.AccountDTO;
import com.ms.dto.DayBookDTO;
import java.util.List;

public class LedgerBean extends FormBean {
	private Integer id;
	private Byte transactionType;
	private String startDate;
	private String endDate;
	private List<DayBookDTO> dayBookDTOList;
	private List<AccountDTO> accountList;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStartDate() {
		return this.startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return this.endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public List<DayBookDTO> getDayBookDTOList() {
		return this.dayBookDTOList;
	}

	public void setDayBookDTOList(List<DayBookDTO> dayBookDTOList) {
		this.dayBookDTOList = dayBookDTOList;
	}

	public Byte getTransactionType() {
		return this.transactionType;
	}

	public void setTransactionType(Byte transactionType) {
		this.transactionType = transactionType;
	}

	public List<AccountDTO> getAccountList() {
		return this.accountList;
	}

	public void setAccountList(List<AccountDTO> accountList) {
		this.accountList = accountList;
	}
}
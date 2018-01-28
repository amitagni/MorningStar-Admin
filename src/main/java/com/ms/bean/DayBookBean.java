package com.ms.bean;

import com.ms.bean.AccountBean;
import com.ms.bean.FormBean;
import com.ms.dto.AccountDTO;
import com.ms.dto.DayBookDTO;
import java.util.List;

public class DayBookBean extends FormBean {
	private Integer id;
	private String userAction;
	private Byte transactionType;
	private Byte paymentType;
	private String chequeEpayNo;
	private String amount;
	private String comments;
	private List<AccountDTO> accountList;
	private AccountBean accountBean;
	private List<DayBookDTO> dayBookDTOList;
	private String dayBookDate;

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getUserAction() {
		return this.userAction;
	}

	public void setUserAction(String userAction) {
		this.userAction = userAction;
	}

	public AccountBean getAccountBean() {
		return this.accountBean;
	}

	public void setAccountBean(AccountBean accountBean) {
		this.accountBean = accountBean;
	}

	public Byte getTransactionType() {
		return this.transactionType;
	}

	public void setTransactionType(Byte transactionType) {
		this.transactionType = transactionType;
	}

	public Byte getPaymentType() {
		return this.paymentType;
	}

	public void setPaymentType(Byte paymentType) {
		this.paymentType = paymentType;
	}

	public String getChequeEpayNo() {
		return this.chequeEpayNo;
	}

	public void setChequeEpayNo(String chequeEpayNo) {
		this.chequeEpayNo = chequeEpayNo;
	}

	public String getAmount() {
		return this.amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public List<DayBookDTO> getDayBookDTOList() {
		return this.dayBookDTOList;
	}

	public void setDayBookDTOList(List<DayBookDTO> dayBookDTOList) {
		this.dayBookDTOList = dayBookDTOList;
	}

	public List<AccountDTO> getAccountList() {
		return this.accountList;
	}

	public void setAccountList(List<AccountDTO> accountList) {
		this.accountList = accountList;
	}

	public String getDayBookDate() {
		return this.dayBookDate;
	}

	public void setDayBookDate(String dayBookDate) {
		this.dayBookDate = dayBookDate;
	}
}
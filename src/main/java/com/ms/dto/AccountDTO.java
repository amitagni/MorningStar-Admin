package com.ms.dto;

import java.io.Serializable;

public class AccountDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String accountName;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAccountName() {
		return this.accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
}
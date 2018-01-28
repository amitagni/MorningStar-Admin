package com.ms.dto;

public class FeeMonthsDTO {
	private Byte code;
	private String name;
	private boolean isPaid;

	public Byte getCode() {
		return this.code;
	}

	public void setCode(Byte code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isPaid() {
		return this.isPaid;
	}

	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}
}
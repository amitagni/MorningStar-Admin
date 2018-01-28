package com.ms.dto;

import com.ms.entity.FeeSlip;
import java.util.List;

public class FeeSummaryDTO {
	private List<FeeSlip> feeSlipList;
	private String monthIds;
	private String quarterlyIds;
	private String halsyrlyIds;
	private String anuallyIds;

	public List<FeeSlip> getFeeSlipList() {
		return this.feeSlipList;
	}

	public void setFeeSlipList(List<FeeSlip> feeSlipList) {
		this.feeSlipList = feeSlipList;
	}

	public String getMonthIds() {
		return this.monthIds;
	}

	public void setMonthIds(String monthIds) {
		this.monthIds = monthIds;
	}

	public String getQuarterlyIds() {
		return this.quarterlyIds;
	}

	public void setQuarterlyIds(String quarterlyIds) {
		this.quarterlyIds = quarterlyIds;
	}

	public String getHalsyrlyIds() {
		return this.halsyrlyIds;
	}

	public void setHalsyrlyIds(String halsyrlyIds) {
		this.halsyrlyIds = halsyrlyIds;
	}

	public String getAnuallyIds() {
		return this.anuallyIds;
	}

	public void setAnuallyIds(String anuallyIds) {
		this.anuallyIds = anuallyIds;
	}
}
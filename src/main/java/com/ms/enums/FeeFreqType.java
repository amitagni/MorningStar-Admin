/**
 * 
 */
package com.ms.enums;

/**
 * @author Amit.Agnihotri
 *
 */
public enum FeeFreqType {
	ANUALLY ((byte)1,"Anually"),
	HALFYEARLY((byte)2,"Half Yearly"),
	QUARTERLY((byte)3,"Quarterly"),
	MONTHLY ((byte)4,"Monthly");
	
	
	private Byte code;
	private String name;
	
	/**
	 * 
	 */
	private FeeFreqType(Byte code,String name) {
		this.code = code;
		this.name = name;
	}

	/**
	 * @return the code
	 */
	public Byte getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(Byte code) {
		this.code = code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}

/**
 * 
 */
package com.ms.enums;

/**
 * @author Amit.Agnihotri
 *
 */
public enum FeeType {
	REGFEES ((byte)1,"Registration Fees"),
	EEXAMFEES((byte)2,"Entrance Exam Fees"),
	REGULARFEES((byte)3,"Regular Fees");
	
	
	private Byte code;
	private String name;
	
	/**
	 * 
	 */
	private FeeType(Byte code,String name) {
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

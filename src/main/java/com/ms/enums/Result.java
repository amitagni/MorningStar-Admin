/**
 * 
 */
package com.ms.enums;

import com.ms.util.MSConstant;

/**
 * @author Amit.Agnihotri
 *
 */
public enum Result {
	NOTAVAILABLE((byte)0,MSConstant.NOTAVAILABLE),
	PASSED((byte)1,"PASS"),
	FAILED((byte)2,"FAIL"),
	AWAITED((byte)3,"AWAITED");
	
	private Byte code;
	private String name;
	
	/**
	 * 
	 */
	private Result(byte code, String name) {
		this.code = code;
		this.name = name;
	}

	
	public static Byte findCodeByName(String  name){
		for(Result result : Result.values()){
			if(result.name.equals(name)){
				return result.code;
			}
		}
		return null;
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

/**
 * 
 */
package com.ms.enums;

/**
 * @author Amit.Agnihotri
 *
 */
public enum Role {
	ADMIN((byte)1,"Admin"),
	ACCOUNTS((byte)2,"Accounts"),
	ADMISSION((byte)3,"Admission");
	
	private Byte code;
	private String name;
	
	/**
	 * 
	 */
	private Role(byte code, String name) {
		this.code = code;
		this.name = name;
	}

	
	public static Byte findCodeByName(String  name){
		for(Role category : Role.values()){
			if(category.name.equals(name)){
				return category.code;
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

/**
 * 
 */
package com.ms.enums;

/**
 * @author Amit.Agnihotri
 *
 */
public enum ReportType {
	STUDENT((byte)1,"S"),
	CLASSWISE((byte)2,"CW");
	
	private Byte code;
	private String name;
	
	/**
	 * 
	 */
	private ReportType(byte code, String name) {
		this.code = code;
		this.name = name;
	}

	
	public static Byte findCodeByName(String  name){
		for(ReportType category : ReportType.values()){
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

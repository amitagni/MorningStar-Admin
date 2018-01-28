/**
 * 
 */
package com.ms.enums;

/**
 * @author Amit.Agnihotri
 *
 */
public enum Section {
	

	A ((byte)1,"A"),
	B((byte)2,"B"),
	C((byte)3,"C");
	
	
	private Byte code;
	private String name;
	
	private Section(Byte code,String name) {
		this.code = code;
		this.name = name;
	}

	
	public static Byte findCodeByName(String  name){
		for(Section section : Section.values()){
			if(section.name.equals(name)){
				return section.code;
			}
		}
		return null;
	}
	
	public static String findNameByCode(Byte  code){
		for(Section section : Section.values()){
			if(section.code.byteValue() == code.byteValue()){
				return section.name;
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

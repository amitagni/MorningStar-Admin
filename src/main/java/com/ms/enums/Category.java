/**
 * 
 */
package com.ms.enums;

/**
 * @author Amit.Agnihotri
 *
 */
public enum Category {
	GENERAL((byte)1,"General"),
	SC((byte)2,"SC"),
	ST((byte)3,"ST"),
	OBC((byte)4,"OBC");
	
	private Byte code;
	private String name;
	
	/**
	 * 
	 */
	private Category(byte code, String name) {
		this.code = code;
		this.name = name;
	}

	
	public static Byte findCodeByName(String  name){
		for(Category category : Category.values()){
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

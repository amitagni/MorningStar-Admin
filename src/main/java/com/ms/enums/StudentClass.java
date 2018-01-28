/**
 * 
 */
package com.ms.enums;

/**
 * @author Amit.Agnihotri
 *
 */
public enum StudentClass {

	PRE_NUR((byte)1,"Play Group"),
	NUR((byte)2,"L.K.G"),
	KG((byte)3,"U.K.G"),
	I((byte)4,"Ist"),
	II((byte)5,"IInd"),
	III((byte)6,"IIIrd"),
	IV((byte)7,"IVth"),
	V((byte)8,"Vth"),
	VI((byte)9,"VIth"),
	VII((byte)10,"VIIth"),
	VIII((byte)11,"VIIIth"),
	IX((byte)12,"IXth"),
	X((byte)13,"Xth"),
	XI_SCIENCE((byte)14,"XI-Science"),
	XI_COMMERCE((byte)15,"XI-Commerce"),
	XII_SCIENCE((byte)16,"XII-Science"),
	XII_COMMERCE((byte)17,"XII-Commerce");

	
	private Byte code;
	private String name;
	
	/**
	 * 
	 */
	private StudentClass(byte code, String name) {
		this.code = code;
		this.name = name;
	}
	
	public static Byte findCodeByName(String  name){
		for(StudentClass studentClass : StudentClass.values()){
			if(studentClass.name.equals(name)){
				return studentClass.code;
			}
		}
		return null;
	}

	
	public static String findNameByCode(Byte  code){
		for(StudentClass studentClass : StudentClass.values()){
			if(studentClass.code.byteValue() == code.byteValue()){
				return studentClass.name;
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

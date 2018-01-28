/**
 * 
 */
package com.ms.enums;

/**
 * @author Amit.Agnihotri
 *
 */
public enum Month {
	
	APR((byte)1,"APRIL","APR"),
	MAY((byte)2,"MAY","MAY"),
	JUN((byte)3,"JUNE","JUN"),
	JUL((byte)4,"JULY","JUL"),
	AUG((byte)5,"AUGUST","AUG"),
	SEP((byte)6,"SEPTEMBER","SEP"),
	OCT((byte)7,"OCTOBER","OCT"),
	NOV((byte)8,"NOVEMBER","NOV"),
	DEC((byte)9,"DECEMBER","DEC"),
	JAN((byte)10,"JANUARY","JAN"),
	FEB((byte)11,"FEBRUARY","FEB"),
	MAR((byte)12,"MARCH","MAR");
	
	private Byte code;
	private String name;
	private String abbr;
	
	/**
	 * 
	 */
	private Month(byte code, String name,String abbr) {
		this.code = code;
		this.name = name;
		this.abbr = abbr;
	}

	
	public static Byte findCodeByName(String  name){
		for(Month month : Month.values()){
			if(month.name.equals(name)){
				return month.code;
			}
		}
		return null;
	}

	
	public static String findNameByCode(Byte  code){
		for(Month month : Month.values()){
			if(month.code.byteValue() == code.byteValue()){
				return month.name;
			}
		}
		return null;
	}
	
	public static String findAbbrByCode(Byte  code){
		for(Month month : Month.values()){
			if(month.code.byteValue() == code.byteValue()){
				return month.abbr;
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

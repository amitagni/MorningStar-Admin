/**
 * 
 */
package com.ms.enums;

/**
 * @author Amit.Agnihotri
 *
 */
public enum TransactionType {
	


	DEBIT ((byte)1,"Dr"),
	CREDIT((byte)2,"Cr"),
	ALL ((byte)3,"All");
	
	
	private Byte code;
	private String name;
	
	private TransactionType(Byte code,String name) {
		this.code = code;
		this.name = name;
	}

	
	public static Byte findCodeByName(String  name){
		for(TransactionType transactiontype : TransactionType.values()){
			if(transactiontype.name.equals(name)){
				return transactiontype.code;
			}
		}
		return null;
	}
	
	public static String findNameByCode(Byte  code){
		for(TransactionType transactiontype : TransactionType.values()){
			if(transactiontype.code.byteValue() == code.byteValue()){
				return transactiontype.name;
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

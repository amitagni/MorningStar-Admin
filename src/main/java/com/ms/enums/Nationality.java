package com.ms.enums;

public enum Nationality {
	INDIAN(Byte.valueOf((byte) 1), "Indian"), NRI(Byte.valueOf((byte) 2), "NRI");

	private Byte code;
	private String name;

	private Nationality(Byte code, String name) {
		this.code = code;
		this.name = name;
	}

	public static Byte findCodeByName(String name) {
		Nationality[] arg3;
		int arg2 = (arg3 = values()).length;

		for (int arg1 = 0; arg1 < arg2; ++arg1) {
			Nationality nationality = arg3[arg1];
			if (nationality.name.equals(name)) {
				return nationality.code;
			}
		}

		return null;
	}

	public static String findNameByCode(Byte code) {
		Nationality[] arg3;
		int arg2 = (arg3 = values()).length;

		for (int arg1 = 0; arg1 < arg2; ++arg1) {
			Nationality nationality = arg3[arg1];
			if (nationality.code.byteValue() == code.byteValue()) {
				return nationality.name;
			}
		}

		return null;
	}

	public Byte getCode() {
		return this.code;
	}

	public void setCode(Byte code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
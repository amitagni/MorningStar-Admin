package com.ms.enums;

public enum House {
	ARAVALI(Byte.valueOf((byte) 1), "Aravali"), SHIVALIK(Byte.valueOf((byte) 2), "Shivalik"), VINDHYACHAL(Byte.valueOf((byte) 2),
			"Vindhyachal"), NILGIRI(Byte.valueOf((byte) 3), "Nilgiri");

	private Byte code;
	private String name;

	private House(Byte code, String name) {
		this.code = code;
		this.name = name;
	}

	public static Byte findCodeByName(String name) {
		House[] arg3;
		int arg2 = (arg3 = values()).length;

		for (int arg1 = 0; arg1 < arg2; ++arg1) {
			House house = arg3[arg1];
			if (house.name.equals(name)) {
				return house.code;
			}
		}

		return null;
	}

	public static String findNameByCode(Byte code) {
		House[] arg3;
		int arg2 = (arg3 = values()).length;

		for (int arg1 = 0; arg1 < arg2; ++arg1) {
			House house = arg3[arg1];
			if (house.code.byteValue() == code.byteValue()) {
				return house.name;
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
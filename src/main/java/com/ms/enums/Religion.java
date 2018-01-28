package com.ms.enums;

public enum Religion {
	HINDU(Byte.valueOf((byte) 1), "Hindu"), MUSHLIM(Byte.valueOf((byte) 2), "Mushlin"), SIKH(Byte.valueOf((byte) 2),
			"Sikh"), CHRISTIAM(Byte.valueOf((byte) 3), "Christian ");

	private Byte code;
	private String name;

	private Religion(Byte code, String name) {
		this.code = code;
		this.name = name;
	}

	public static Byte findCodeByName(String name) {
		Religion[] arg3;
		int arg2 = (arg3 = values()).length;

		for (int arg1 = 0; arg1 < arg2; ++arg1) {
			Religion religion = arg3[arg1];
			if (religion.name.equals(name)) {
				return religion.code;
			}
		}

		return null;
	}

	public static String findNameByCode(Byte code) {
		Religion[] arg3;
		int arg2 = (arg3 = values()).length;

		for (int arg1 = 0; arg1 < arg2; ++arg1) {
			Religion religion = arg3[arg1];
			if (religion.code.byteValue() == code.byteValue()) {
				return religion.name;
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
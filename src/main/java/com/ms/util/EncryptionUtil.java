package com.ms.util;

import com.ms.util.MSException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptionUtil {
	public static String md5Encrypt(String password) throws MSException {
		try {
			MessageDigest e = MessageDigest.getInstance("MD5");
			e.update((password + "MS#2").getBytes());
			byte[] byteData = e.digest();
			StringBuffer hexString = new StringBuffer();

			for (int i = 0; i < byteData.length; ++i) {
				String hex = Integer.toHexString(255 & byteData[i]);
				if (hex.length() == 1) {
					hexString.append('0');
				}

				hexString.append(hex);
			}

			return hexString.toString();
		} catch (NoSuchAlgorithmException arg5) {
			throw new MSException(arg5);
		}
	}

	public static void main(String[] ar) {
		try {
			System.out.println(md5Encrypt("Abhay!234"));
		} catch (MSException arg1) {
			arg1.printStackTrace();
		}

	}
}
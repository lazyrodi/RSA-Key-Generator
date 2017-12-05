package com.lazyrodi.rsa.keygenerator;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class RSA {
	private final static int KEY_SIZE = 2048;

	public static KeyPair makeKeyPair() {
		KeyPairGenerator keyPairGenerator = null;
		try {
			keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			keyPairGenerator.initialize(KEY_SIZE, new SecureRandom());
			return keyPairGenerator.genKeyPair();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String byteArrToHexStr(byte[] byteArr) {
		if (byteArr == null || byteArr.length == 0) {
			return null;
		}

		StringBuilder hexString = new StringBuilder(byteArr.length + 2);

		for (int i = 0; i < byteArr.length; i++) {
			String hexNum = "0" + Integer.toHexString(0xff & byteArr[i]);
			hexString.append(hexNum.substring(hexNum.length() - 2));
		}
		return hexString.toString();
	}
}
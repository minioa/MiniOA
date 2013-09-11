package org.minioa.core;


import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class DES {

	public static String encryptDES(String encryptString, String encryptKey)
			throws Exception {
		IvParameterSpec zeroIv = new IvParameterSpec(encryptKey.getBytes());
		SecretKeySpec key = new SecretKeySpec(encryptKey.getBytes(), "DES");
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		cipher.init(Cipher.ENCRYPT_MODE, key, zeroIv);
		byte[] encryptedData = cipher.doFinal(encryptString.getBytes());

		return Base64.encode(encryptedData);
	}

	public static String decryptDES(String decryptString, String decryptKey)
			throws Exception {
		new Base64();
		byte[] byteMi = Base64.decode(decryptString);
		IvParameterSpec zeroIv = new IvParameterSpec(decryptKey.getBytes());
		SecretKeySpec key = new SecretKeySpec(decryptKey.getBytes(), "DES");
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, key, zeroIv);
		byte decryptedData[] = cipher.doFinal(byteMi);

		return new String(decryptedData);
	}
}
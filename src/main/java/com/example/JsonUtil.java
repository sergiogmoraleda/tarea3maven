package com.example;

import java.math.BigInteger;
import java.security.MessageDigest;



public interface JsonUtil {

	public static String getHashMD5(String jsonS) {
		String md5 = null;

		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(jsonS.getBytes(),0,jsonS.length());
			md5 = new BigInteger(1,md.digest()).toString(16);
		} catch (Exception e) {
			return null;

			
			}
		
		return md5;
	}

	
}

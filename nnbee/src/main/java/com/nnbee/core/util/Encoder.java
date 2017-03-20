package com.nnbee.core.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

public class Encoder {

	public static String encryptSHA(String inStr)  {
		return encrypt(inStr, "SHA");
    }
	
	public static String encryptMD5(String inStr)  {
		String hexValue = encrypt(inStr, "MD5");
		return hexValue.toUpperCase();
    }

	private static String encrypt(String inStr, String method) {
		MessageDigest sha = null;
        try {
            sha = MessageDigest.getInstance(method);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        byte[] byteArray;
		try {
			byteArray = inStr.getBytes("UTF-8");
			byte[] md5Bytes = sha.digest(byteArray);
	        StringBuffer hexValue = new StringBuffer();
	        for (int i = 0; i < md5Bytes.length; i++) {
	            int val = ((int) md5Bytes[i]) & 0xff;
	            if (val < 16) { 
	                hexValue.append("0");
	            }
	            hexValue.append(Integer.toHexString(val));
	        }
	        return hexValue.toString();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return "";
		}
	}
	
	public static void main(String[] args)  {
		System.out.println(encryptSHA("tiandao321"));
	}
}

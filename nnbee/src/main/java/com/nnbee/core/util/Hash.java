package com.nnbee.core.util;

import org.apache.commons.lang.StringUtils;

public class Hash {
	
	private static char[] HASH_SALT = "vCt01aEF2c34AB56g789D".toCharArray();

	/**
	 * @param hashStr
	 * @return
	 */
	public static String hash(String hashStr){
		if(StringUtils.isBlank(hashStr)){
			return "";
		}
		byte[] hashbytes = hashStr.getBytes();
		StringBuilder sb = new StringBuilder(hashbytes.length * 2);
		for (byte b : hashbytes) {
		    sb.append(HASH_SALT[(b & 0xF0) >> 4]);
		    sb.append(HASH_SALT[b & 0x0F]);
		}
		String hex = sb.toString();
		return hex;
	}
}

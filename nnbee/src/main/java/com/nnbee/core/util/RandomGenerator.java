package com.nnbee.core.util;
/**
 *=====================================================================
 * ACP Random Number Generator 
 *
 * 
 *---------------------------------------------------------------------
 * Update date  Contents
 *=====================================================================
 * 12/10/2012   create
 *
 */


import java.util.*;

public class RandomGenerator {
	
	public static final Random gen = new Random();
	
	/**
	 * @param n
	 * @param maxRange
	 * @param offset
	 * @return
	 */
	public static List<Integer> getRandomInterval(int n, int maxRange, int offset) {
		List<Integer> result = new ArrayList<Integer>(); 
		Set<Integer> used = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {   
			int newRandom;   
			do {   
				newRandom = gen.nextInt(maxRange) + offset; 
				} while (used.contains(newRandom));   
			result.add(new Integer(newRandom));
			used.add(newRandom);
			}
		Collections.sort(result);
		return result;
		}
	
	/**
	 * @param maxRange
	 * @param offset
	 * @return
	 */
	public static int getRandomNumber(int maxRange, int offset) {
		int newRandomNum = gen.nextInt(maxRange) + offset;
		return newRandomNum;
		
	}
	
	/**
	 * 随机生成指定位数的数字字符串
	 * @param length
	 * @return
	 */
	public static String getRandomStr(int length) {
		
		String mulitplayStr = "1";
		
		for (int i = 0; i < length ; i++) {
			mulitplayStr += "0";
		}
		
		Random random = new Random();
		Integer value = random.nextInt() * Integer.valueOf(mulitplayStr);
		
		String valueStr = value.toString();
		
		if (valueStr.contains("-")) {
			valueStr = valueStr.replace("-", "");
		}
		
		if (valueStr.length() > length) {
			valueStr = valueStr.substring(0, valueStr.length() - (valueStr.length() - length));
		}else {
			int tempLength = valueStr.length();
			
			for (int i = 0; i < length - tempLength; i++) {
				valueStr += "0";
			}
		}
		
		return valueStr;
	}
	
	
	public static void main(String[] args) {   
		int num = getRandomNumber(10,0);
		System.out.println(num);  
		List<Integer> result = getRandomInterval(10,50,0);
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));  
		}
	}
}

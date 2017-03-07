package com.kavli.core.utils;

import org.apache.commons.lang.BooleanUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BooleanUtil extends BooleanUtils {

	/**
	 * Method to return boolean value for passed in character
	 * @param value
	 * @return boolean
	 */
	public static boolean toBoolean(Character value) {
		boolean returnValue = false;
		if (value == 'Y' || value == 'y') {
			returnValue = true;
		} else if (value == 'N' || value == 'n') {
			returnValue = false;
		}
		return returnValue;
	}

	/**
	 * Method to return boolean value for passed in character
	 * @param value
	 * @return Boolean
	 */
	public static Boolean toBooleanObject(Character value) {
		Boolean returnValue = null;
		if (value == 'Y' || value == 'y') {
			returnValue = true;
		} else if (value == 'N' || value == 'n') {
			returnValue = false;
		}
		return returnValue;
	}

	/**
	 * Method to return boolean value based on passed in String
	 * @param value
	 * @return boolean
	 */
	public static boolean toBoolean(String value) {
		if (value.equalsIgnoreCase("true")) {
			return true;
		}
		if (value == null) {
			return false;
		}
		switch (value.length()) {
		case 1: {
			if ("y".equalsIgnoreCase(value)) {
				return true;
			} else if ("n".equalsIgnoreCase(value)) {
				return false;
			}
		}
		case 2: {
			char ch0 = value.charAt(0);
			char ch1 = value.charAt(1);
			return 
					(ch0 == 'o' || ch0 == 'O') &&
					(ch1 == 'n' || ch1 == 'N');
		}
		case 3: {
			char ch = value.charAt(0);
			if (ch == 'y') {
				return 
						(value.charAt(1) == 'e' || value.charAt(1) == 'E') &&
						(value.charAt(2) == 's' || value.charAt(2) == 'S');
			}
			if (ch == 'Y') {
				return 
						(value.charAt(1) == 'E' || value.charAt(1) == 'e') &&
						(value.charAt(2) == 'S' || value.charAt(2) == 's');
			}
			return false;
		}
		case 4: {
			char ch = value.charAt(0);
			if (ch == 't') {
				return 
						(value.charAt(1) == 'r' || value.charAt(1) == 'R') &&
						(value.charAt(2) == 'u' || value.charAt(2) == 'U') &&
						(value.charAt(3) == 'e' || value.charAt(3) == 'E');
			}
			if (ch == 'T') {
				return 
						(value.charAt(1) == 'R' || value.charAt(1) == 'r') &&
						(value.charAt(2) == 'U' || value.charAt(2) == 'u') &&
						(value.charAt(3) == 'E' || value.charAt(3) == 'e');
			}
		}
		}
		return false;
	}


	/**
	 * Method to return boolean object based on the passed in String
	 * @param value
	 * @return returnValue
	 */
	public static Boolean toBooleanObject(String value) {
		Boolean returnValue = null;
		if ("true".equalsIgnoreCase(value)) {
			returnValue = Boolean.TRUE;
		} else if ("false".equalsIgnoreCase(value)) {
			returnValue = Boolean.FALSE;
		} else if ("on".equalsIgnoreCase(value)) {
			returnValue = Boolean.TRUE;
		} else if ("off".equalsIgnoreCase(value)) {
			returnValue = Boolean.FALSE;
		} else if ("yes".equalsIgnoreCase(value)) {
			returnValue = Boolean.TRUE;
		} else if ("no".equalsIgnoreCase(value)) {
			returnValue = Boolean.FALSE;
		} else if ("y".equalsIgnoreCase(value)) {
			returnValue = Boolean.TRUE;
		} else if ("n".equalsIgnoreCase(value)) {
			returnValue = Boolean.FALSE;
		}
		return returnValue;
	}

	
	public static boolean isMobile(String str) {
        Pattern p = null;
        Matcher m = null;
        boolean b = false;   
        p = Pattern.compile("^[1][3,4,5,7,8][0-9]{9}$"); // 验证手机号
        m = p.matcher(str);  
        b = m.matches();   
        return b;  
    }

	/**
	 * 会员日 周
	 *
	 * @param str str
	 * @return b
	 */
	public static boolean isWeekDataRuleOne(String str) {
		String telRegex = "[1-7]";
		return str.matches(telRegex);
	}

	/**
	 * 会员日 月
	 *
	 * @param str str
	 * @return b
	 */
	public static boolean isMonthDataRuleOne(String str) {
		String telRegex = "([1-9]|[12][0-9]|[3][0-1])";
		return str.matches(telRegex);
	}

	/**
	 * 会员日 年
	 *
	 * @param str str
	 * @return b
	 */
	public static boolean isYearDataRuleOne(String str) {
		String telRegex = "((([13578]|1[02])/([1-9]|[12][0-9]|3[01]))|(([469]|11)/([1-9]|[12][0-9]|30))|(2/([1-9]|[1][0-9]|2[0-9])))";
		return str.matches(telRegex);
	}

	/**
	 * 会员日 周 ,
	 *
	 * @param str str
	 * @return b
	 */
	public static boolean isWeekDataRuleTwo(String str) {
		String telRegex = "[1-7](\\,[1-7]){1,6}";
		return str.matches(telRegex);
	}

	/**
	 * 会员日 月 ,
	 *
	 * @param str str
	 * @return b
	 */
	public static boolean isMonthDataRuleTwo(String str) {
		String telRegex = "([1-9]|[12][0-9]|[3][0-1])(\\,([1-9]|[12][0-9]|[3][0-1])){1,30}";
		return str.matches(telRegex);
	}

	/**
	 * 会员日 年 ,
	 *
	 * @param str str
	 * @return b
	 */
	public static boolean isYearDataRuleTwo(String str) {
		String telRegex = "((([13578]|1[02])/([1-9]|[12][0-9]|3[01]))|(([469]|11)/([1-9]|[12][0-9]|30))|(2/([1-9]|[1][0-9]|2[0-9])))" +
				"(\\,((([13578]|1[02])/([1-9]|[12][0-9]|3[01]))|(([469]|11)/([1-9]|[12][0-9]|30))|(2/([1-9]|[1][0-9]|2[0-9])))){1,365}";
		return str.matches(telRegex);
	}

	/**
	 * 会员日 周 -
	 *
	 * @param str str
	 * @return b
	 */
	public static boolean isWeekDataRuleThree(String str) {
		String telRegex = "[1-7]-[1-7]";
		return str.matches(telRegex);
	}

	/**
	 * 会员日 月 -
	 *
	 * @param str str
	 * @return b
	 */
	public static boolean isMonthDataRuleThree(String str) {
		String telRegex = "([1-9]|[12][0-9]|[3][0-1])-([1-9]|[12][0-9]|[3][0-1])";
		return str.matches(telRegex);
	}

	/**
	 * 会员日 年 -
	 *
	 * @param str str
	 * @return b
	 */
	public static boolean isYearDataRuleThree(String str) {
		String telRegex = "((([13578]|1[02])/([1-9]|[12][0-9]|3[01]))|(([469]|11)/([1-9]|[12][0-9]|30))|(2/([1-9]|[1][0-9]|2[0-9])))" +
				"-((([13578]|1[02])/([1-9]|[12][0-9]|3[01]))|(([469]|11)/([1-9]|[12][0-9]|30))|(2/([1-9]|[1][0-9]|2[0-9])))";
		return str.matches(telRegex);
	}

}
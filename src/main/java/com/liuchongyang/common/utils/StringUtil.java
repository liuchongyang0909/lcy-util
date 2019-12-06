package com.liuchongyang.common.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * 
 * @ClassName: StringUtil
 * @Description: �ַ���������
 * @author: 86157
 * @date: 2019��12��5�� ����6:34:49
 */
public class StringUtil {
	// ��֤��ֵ
	public static boolean isNumber(String str) {
		String regex = "^(-)?[0-9]+(.[0-9]+)?$";

		return str.matches(regex);
	}

	public static int getAge(Date date) {
		Calendar c = Calendar.getInstance();

		int yearNow = c.get(Calendar.YEAR);
		int monthNow = c.get(Calendar.MONTH);
		int dateNow = c.get(Calendar.DAY_OF_MONTH);

		c.setTime(date);

		int yearDate = c.get(Calendar.YEAR);
		int monthDate = c.get(Calendar.MONTH);
		int dateDate = c.get(Calendar.DAY_OF_MONTH);

		int age = yearNow - yearDate;

		if (monthDate > monthNow) {
			age--;
		}

		if (monthDate == monthNow && dateDate > dateNow) {
			age--;
		}

		return age;
	}

	public static boolean hasLength(String src) {
		return src != null && src.length() > 0;
	}

	// ����2���ж�Դ�ַ����Ƿ���ֵ��������(�հ��ַ���)�Ϳո�Ҳ��ûֵ (5��)
	public static boolean hasText(String src) {
		return src != null && src.trim().length() > 0;
	}

	// ����3�����ز���length�����ĺ����ַ������ַ���������GB2312(�൱�����ļ���)��Χ�ڣ����硰��ѽ����(5��)
	public static String randomChineseString(int length) {
		return null;
	}

	// ����4������������������������ʵ�տ�ͷ���ټ����ڡ��������ټ��ա����ʹ��1-2���������(8��)���ڲ�����randomChineseString()����(3��)������ʾ��������ѽ��������ŷ����Ϊ��
	public static String generateChineseName() {
		return null;
	}
}

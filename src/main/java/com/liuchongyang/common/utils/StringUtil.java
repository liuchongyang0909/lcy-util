package com.liuchongyang.common.utils;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * 
 * @ClassName: StringUtil
 * @Description: �ַ���������
 * @author: 86157
 * @date: 2019��12��5�� ����6:34:49
 */
public class StringUtil {
	/**
	 * У�鴫��Ĳ����Ƿ�Ϊurl
	 * @param param
	 * @return
	 */
	public static boolean isHttpUrl(String param) {
		 URL url;  
		 try {  
	         url = new URL(param);
	        url.openStream();  
	         return true; 
	    } catch (Exception e1) {  
	         System.out.println("���Ӵ򲻿�!");  
	       
	    }  
		 return false;
		
	}
	
	// ��֤�Ƿ�����ֵ
	public static boolean isNumber(String str) {
		String regex = "^(-)?[0-9]+(.[0-9]+)?$";

		return str.matches(regex);
	}

	//��ȡ����
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
	
	/**
	 * 
	 * @Title: isPhoneNumber 
	 * @Description: ��֤�Ƿ����ֻ���
	 * @param str
	 * @return
	 * @return: boolean
	 */
	public static boolean isPhoneNumber(String str) {
		if (hasText(str)) {
			String regex = "1[3|4|5|6|7|8|9]\\d{9}";
			
			return str.matches(regex);
		} else {
			return false;
		}
	}
	
	

	/**
	 * 
	 * @Title: hasLength 
	 * @Description: �ж�Դ�ַ����Ƿ���ֵ��������(�հ��ַ���)Ҳ��ûֵ
	 * @param src
	 * @return
	 * @return: boolean
	 */
	public static boolean hasLength(String src) {
		return src != null && src.length() > 0;
	}

	//�ж�Դ�ַ����Ƿ���ֵ��������(�հ��ַ���)�Ϳո�Ҳ��ûֵ 
	public static boolean hasText(String src) {
		return src != null && src.trim().length() > 0;
	}

	/// �������һ�����ĺ���
	public static String randomChineseString() {
		String str = null;
		int highPos, lowPos;
		Random random = new Random();
		highPos = (176 + Math.abs(random.nextInt(40)));// ���룬0xA0��ͷ���ӵ�16����ʼ����0xB0=11*16=176,16~55һ�����֣�56~87��������
		random = new Random();
		lowPos = 161 + Math.abs(random.nextInt(95));// λ�룬0xA0��ͷ����Χ��1~94��
		byte[] bArr = new byte[2];

		bArr[0] = (new Integer(highPos)).byteValue();
		bArr[1] = (new Integer(lowPos)).byteValue();
		try {
			str = new String(bArr, "GB2312"); // ��λ����ϳɺ���
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return str;
	}
	
	// ����3�����ز���length�����ĺ����ַ������ַ���������GB2312(�൱�����ļ���)��Χ�ڣ����硰��ѽ����(5��)
	public static String randomChineseString(int length) {
		String str = "";
		for (int i = 0; i < length; i++) {
			str += randomChineseString();
		}
		return str;
	}

	//����������������������ʵ�տ�ͷ���ټ����ڡ��������ټ��ա����ʹ��1-2���������
	public static String generateChineseName() {
		String[] str = { "��", "Ǯ", "��", "��", "��", "��", "֣", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "��", "ʩ", "��", "��", "��", "��", "��", "��", "κ", "��", "��", "��", "л", "��", "��", "��", "ˮ", "�", "��",
				"��", "��", "��", "��", "��", "��", "��", "��", "³", "Τ", "��", "��", "��", "��", "��", "��", "��", "��", "Ԭ", "��", "ۺ",
				"��", "ʷ", "��", "��", "��", "�", "Ѧ", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"ʱ", "��", "Ƥ", "��", "��", "��", "��", "��", "Ԫ", "��", "��", "��", "ƽ", "��", "��", "��", "��", "��", "Ҧ", "��", "տ",
				"��", "��", "ë", "��", "��", "��", "��", "��", "�", "��", "��", "��", "��", "̸", "��", "é", "��", "��", "��", "��", "��",
				"��", "ף", "��", "��", "��", "��", "��", "��", "ϯ", "��", "��", "ǿ", "��", "·", "¦", "Σ", "��", "ͯ", "��", "��", "÷",
				"ʢ", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "֧", "��", "��", "��",
				"¬", "Ī", "��", "��", "��", "��", "��", "��", "Ӧ", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"ʯ", "��", "��", "ť", "��", "��", "��", "��", "��", "��", "½", "��", "��", "��", "��", "�", "��", "��", "�L", "��", "��",
				"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "ɽ", "��", "��",
				"��", "�", "��", "ȫ", "ۭ", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "б", "��", "��", "��", "��",
				"��", "��", "��", "ղ", "��", "��", "Ҷ", "��", "˾", "��", "۬", "��", "��", "��", "ӡ", "��", "��", "��", "��", "ۢ", "��",
				"��", "��", "��", "��", "��", "׿", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "˫", "��", "ݷ", "��", "��",
				"̷", "��", "��", "��", "��", "��", "��", "��", "Ƚ", "��", "۪", "Ӻ", "�S", "�", "ɣ", "��", "�", "ţ", "��", "ͨ", "��",
				"��", "��", "��", "ۣ", "��", "��", "ũ", "��", "��", "ׯ", "��", "��", "��", "��", "��", "Ľ", "��", "��", "ϰ", "��", "��",
				"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "»", "��", "��", "ŷ", "�", "��", "��", "ε", "Խ", "��", "¡", "ʦ", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "ɳ", "ؿ", "��", "��", "��", "��", "��", "��", "��", "��", "��",
				"��", "��", "��", "��", "��", "Ȩ", "��", "��", "��", "��", "��", "��", "��", "��", "��", "��", "۳", "Ϳ", "��", "��", "˧",
				"��", "��", "��", "��", "��", "��", "��", "Ĳ", "��", "٦", "��", "��", "ī", "��", "��", "��", "��", "��", "��", "١",
				"��ٹ", "˾��", "�Ϲ�", "ŷ��", "�ĺ�", "���", "����", "����", "����", "�ʸ�", "ξ��", "����", "�̨", "��ұ", "����", "���", "����",
				"����", "̫��", "����", "����", "����", "��ԯ", "���", "����", "����", "����", "Ľ��", "����", "����", "˾ͽ", "˾��", "آ��", "˾��",
				"��", "��", "�ӳ�", "���", "��ľ", "����", "����", "���", "����", "����", "����", "�ذ�", "�й�", "�׸�", "����", "�θ�", "����",
				"����", "����", "����", "��", "��", "����", "΢��", "����", "����", "����", "����", "�Ϲ�" };
		String firstName = str[RandomUtil.random(0, str.length - 1)];
		String lastName = randomChineseString(RandomUtil.random(1, 2));

		return firstName + lastName;
	}
	
	//��Ҫʵ�ֵ��߼����ж��ֻ������Ƿ�Ϊ��ֵ���Ƿ񳤶�Ϊ11λ����ʼλ������1.
	public static boolean judgeTelephoneIsOk(String src){
		String regex = "^1[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]$";
		
		boolean m = src.matches(regex);
		
		return m;
	}
	
	public static boolean isHttpUrl2(String src){
		if(src.startsWith("http")) {
			return true;
		} else {
			return false;
		}
	}
}

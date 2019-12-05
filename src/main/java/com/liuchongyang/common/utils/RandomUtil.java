package com.liuchongyang.common.utils;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * 
 * @ClassName: StringUtil 
 * @Description: �����������
 * @author: 86157
 * @date: 2019��12��5�� ����6:34:02
 */
public class RandomUtil {
	
	//����1������min-max֮����������������min��maxֵ�������緵��1-3֮������������ô����1��2��3������ȷ�ģ�����4�Ͳ��ԡ� (5��)
		public static int random(int min, int max){
			Random r = new Random();
			
			return r.nextInt(max - min + 1) + min;
		}
		
		//public static void main(String[] args) {
			//for (int i = 0; i < 10; i++) {
				//int random = RandomUtil.random(1, 3);
				//System.out.println(random);
			//}
		//}
		
		
		//����2������Сֵmin�����ֵmax֮���ȡsubs�����ظ����������������1-10֮��ȡ3�����ظ������������ô[2,6,9]�ǶԵģ�[3,5,5]�򲻶ԣ���Ϊ5�ظ��ˡ�Ӧ�ó�������100ƪ���������ȡ10ƪ���£��¿����ܻ�ʹ�õ��� (8��)
		public static int[] subRandom (int min, int max, int subs){
			int[] array = new int[subs];
			
			Set<Integer> set = new HashSet<Integer>();
			
			while(set.size() != subs) {
				set.add(random(min, max));
			}
			
			int i = 0;
			for (Integer n : set) {
				array[i] = n;
				i++;
			}
			return array;
		}
		//����3������1��1-9,a-Z֮�������ַ��� (8��)
		public static char randomCharacter (){
			String src = "123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
			return src.charAt(random(0, src.length()-1));
		}
		//����4�����ز���length���ַ���(5��)�������ڲ�Ҫ����randomCharacter()���� (4��)
		public static String randomString(int length){
			String str = "";
			for (int i = 0; i < length; i++) {
				str += randomCharacter();
			}
			return str;
		}
}
package com.liuchongyang.common.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class StreamUtil {
	
	/**
	 * 
	 * @Title: read 
	 * @Description: ����������
	 * @param in
	 * @return
	 * @throws IOException
	 * @return: List<String>
	 */
	public static List<String> read(InputStream in) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(in));
		List<String> list = new ArrayList<String>();
		String str = "";
		
		while((str=read.readLine()) != null) {
			list.add(str);
		}
		
		return list;
	}
	
	public static String readFile(File file, String charset) throws IOException {
		// �������������
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
		// ���建�����
		StringBuffer sb = new StringBuffer();
		// �����ȡÿ�еĽ��
		String content = null;
		// ѭ����ȡ
		while ((content = br.readLine()) != null) {
			// ���뻺�����
			sb.append(content);
		}
		// �ر���
		br.close();
		// ���ؽ��
		return sb.toString();
	}
}

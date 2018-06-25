package com.tenpay.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TenpayUtil {
	
	/**
	 * �Ѷ���ת�����ַ���
	 * @param obj
	 * @return String ת�����ַ���,������Ϊnull,�򷵻ؿ��ַ���.
	 */
	public static String toString(Object obj) {
		if(obj == null)
			return "";
		
		return obj.toString();
	}
	
	/**
	 * �Ѷ���ת��Ϊint��ֵ.
	 * 
	 * @param obj
	 *            �������ֵĶ���.
	 * @return int ת�������ֵ,�Բ���ת���Ķ��󷵻�0��
	 */
	public static int toInt(Object obj) {
		int a = 0;
		try {
			if (obj != null)
				a = Integer.parseInt(obj.toString());
		} catch (Exception e) {

		}
		return a;
	}
	
	/**
	 * ��ȡ��ǰʱ�� yyyyMMddHHmmss
	 * @return String
	 */ 
	public static String getCurrTime() {
		Date now = new Date();
		SimpleDateFormat outFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		String s = outFormat.format(now);
		return s;
	}
	
	/**
	 * ��ȡ��ǰ���� yyyyMMdd
	 * @param date
	 * @return String
	 */
	public static String formatDate(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String strDate = formatter.format(date);
		return strDate;
	}
	
	/**
	 * ȡ��һ��ָ�����ȴ�С�����������.
	 * 
	 * @param length
	 *            int �趨��ȡ��������ĳ��ȡ�lengthС��11
	 * @return int �������ɵ��������
	 */
	public static int buildRandom(int length) {
		int num = 1;
		double random = Math.random();
		if (random < 0.1) {
			random = random + 0.1;
		}
		for (int i = 0; i < length; i++) {
			num = num * 10;
		}
		return (int) ((random * num));
	}
	
	/**
	 * ��ȡ�����ַ���
	 * @param request
	 * @param response
	 * @return String
	 */
	public static String getCharacterEncoding(HttpServletRequest request,
			HttpServletResponse response) {
		
		if(null == request || null == response) {
			return "gbk";
		}
		
		String enc = request.getCharacterEncoding();
		if(null == enc || "".equals(enc)) {
			enc = response.getCharacterEncoding();
		}
		
		if(null == enc || "".equals(enc)) {
			enc = "gbk";
		}
		
		return enc;
	}
	
	/**
	 * ��ȡunixʱ�䣬��1970-01-01 00:00:00��ʼ������
	 * @param date
	 * @return long
	 */
	public static long getUnixTime(Date date) {
		if( null == date ) {
			return 0;
		}
		
		return date.getTime()/1000;
	}
		
	/**
	 * ʱ��ת�����ַ���
	 * @param date ʱ��
	 * @param formatType ��ʽ������
	 * @return String
	 */
	public static String date2String(Date date, String formatType) {
		SimpleDateFormat sdf = new SimpleDateFormat(formatType);
		return sdf.format(date);
	}
	
	/**
	 * ��ʮ�����Ƶ��ַ���ת��Ϊ�ֽ�����
	 * @param hex
	 * @return
	 */
	public static byte[] hexStringToByte(String hex) { 
	    int len = (hex.length() / 2); 
	    byte[] result = new byte[len]; 
	    char[] srcChars = hex.toUpperCase().toCharArray(); 
	    for (int i = 0; i < len; i++) { 
	     result[i] = (byte) (toByte(srcChars[i*2]) << 4 | toByte(srcChars[i*2 + 1])); 
	    } 
	    return result; 
	} 

	private static byte toByte(char c) { 
	    byte b = (byte) "0123456789ABCDEF".indexOf(c); 
	    return b; 
	} 

	/**
	 * ���ֽ�����ת��Ϊʮ�������ַ���
	 * @param bArray
	 * @return
	 */
	public static  String bytesToHexString(byte[] bArray) { 
	    StringBuffer sb = new StringBuffer(bArray.length); 
	    String str; 
	    for (int i = 0; i < bArray.length; i++) { 
	    	str = Integer.toHexString(0xFF & bArray[i]); 
	    	
		     if (str.length() < 2) {
		      sb.append(0); 
		     }
		     sb.append(str.toUpperCase()); 
	    } 
	    return sb.toString(); 
	} 

	/**
	 * �ַ���ת����Map<br/>
	 * name1=key1&name2=key2&...
	 * @param queryString
	 * @return
	 */
	public static Map str2Map(String str, String split, String subSplit) {
		Map m = new HashMap();
		
		if(null != str && !"".equals(str)) {
			String[] strArray = str.split(split);
			for(int index = 0; index < strArray.length; index++) {
				String[] pair = strArray[index].split(subSplit);
				String v = "";
				if(pair.length > 1) {
					v = pair[1];
				}
				if(!pair[0].equals("")) {
					m.put(pair[0], v);
				}
			
			}
		}
		return m;
		
	}
	
	/**
	 * ����Ҫ������HTML������Ĳ�����������б��� 
	 * @param str
	 * @return
	 * 		< --> &lt;
			> --> &gt;
			' --> &#39;
			" --> &quot;
			& --> &amp;
			= --> &#61;
			` --> &#96;
	 */
	public static String htmlAttributeEncode(String str)
	{
		if(str == null)
		{
			return "";
		}
		// ����������ʽ�滻��ֱ��ͨ��ѭ������ʡcpuʱ��
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < str.length(); ++i)
		{
			char c = str.charAt(i);
			switch(c)
			{				
				case '<':
					sb.append("&lt;");
					break;
				case '>':
					sb.append("&gt;");
					break;
				case '\'':
					sb.append("&#39;");
				case '\"':
					sb.append("&quot;");
					break;
				case '&':
					sb.append("&amp;");
					break;
				case '=':
					sb.append("&#61;");
					break;
				case '`':
					sb.append("&#96;");
					break;
				default:
					sb.append(c);
					break;
			}
		}
		return sb.toString();
	}
}

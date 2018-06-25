package com.tenpay.wap;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tenpay.RequestHandler;
import com.tenpay.util.TenpayUtil;

/**
 * wap�ֻ�֧��������
 * ============================================================================
 * api˵����
 * init(),��ʼ��������Ĭ�ϸ�һЩ������ֵ����cmdno,date�ȡ�
 * getGateURL()/setGateURL(),��ȡ/������ڵ�ַ,����������ֵ
 * getKey()/setKey(),��ȡ/������Կ
 * getParameter()/setParameter(),��ȡ/���ò���ֵ
 * getAllParameters(),��ȡ���в���
 * getRequestURL(),��ȡ������������URL
 * doSend(),�ض��򵽲Ƹ�֧ͨ��
 * getDebugInfo(),��ȡdebug��Ϣ
 * 
 * ============================================================================
 *
 */
public class WapPayRequestHandler extends RequestHandler  {

	public WapPayRequestHandler(HttpServletRequest request,
			HttpServletResponse response) {
		super(request, response);
		
		this.setGateUrl("https://wap.tenpay.com/cgi-bin/wappayv2.0/wappay_gate.cgi");
	}
	
public String getRequestURL() throws UnsupportedEncodingException {
		
		StringBuffer sb = new StringBuffer();
		String enc = TenpayUtil.getCharacterEncoding(this.getHttpServletRequest(), this.getHttpServletResponse());
		Set es = this.getAllParameters().entrySet();
		Iterator it = es.iterator();
		while(it.hasNext()) {
			Map.Entry entry = (Map.Entry)it.next();
			String k = (String)entry.getKey();
			String v = (String)entry.getValue();
			sb.append(k + "=" + URLEncoder.encode(v, enc) + "&");
		}
		
		//ȥ�����һ��&
		String reqPars = sb.substring(0, sb.lastIndexOf("&"));
		
		return this.getGateUrl() + "?" + reqPars;
		
	}


	
	

}

package com.tenpay.wap;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tenpay.RequestHandler;


/**
 * wap�ֻ�֧����ʼ��������
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
public class WapPayInitRequestHandler extends RequestHandler  {

	public WapPayInitRequestHandler(HttpServletRequest request,
			HttpServletResponse response) {
		super(request, response);
		
		this.setGateUrl("https://wap.tenpay.com/cgi-bin/wappayv2.0/wappay_init.cgi");
		
	}

	public void init() {
		
		this.setParameter("ver", "2.0");
		
		//�ַ�����  1 UTF-8, 2 GB2312,
		this.setParameter("charset", "1");
		
		//��������:�Ƹ�֧ͨ����0
		this.setParameter("bank_type", "0");
		
		//ǩ��
		this.setParameter("sign", "");
		
	}
	
	protected void createSign() {
		super.createSign();
		this.setParameter("sign", getParameter("sign").toUpperCase());
	}
	
	

}

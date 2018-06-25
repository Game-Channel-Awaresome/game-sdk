package com.tenpay.wap;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tenpay.ResponseHandler;

/**
 * wap֧��ǰ̨Ӧ����
 * ============================================================================
 * api˵����
 * getKey()/setKey(),��ȡ/������Կ
 * getParameter()/setParameter(),��ȡ/���ò���ֵ
 * getAllParameters(),��ȡ���в���
 * isTenpaySign(),�Ƿ�Ƹ�ͨǩ��,true:�� false:��
 * getDebugInfo(),��ȡdebug��Ϣ
 * 
 * ============================================================================
 *
 */
public class WapPayPageResponseHandler extends ResponseHandler {

	public WapPayPageResponseHandler(HttpServletRequest request,
			HttpServletResponse response) {
		super(request, response);
	}
	


	/**
	 * ǩ������,����ĸa-z����,������ֵ���μ�ǩ��
	 * @return boolean
	 */
	public boolean isTenpaySign() {
		String[] signParameterArray = {
				"ver",
				"charset",
				"pay_result",
				"transaction_id",
				"sp_billno",
				"total_fee",
				"fee_type",
				"bargainor_id",
				"attach",
				"time_end"
		};
					
			
		
		//��a-z��������
		java.util.Arrays.sort(signParameterArray);
		
		return this.isTenpaySign(signParameterArray);
		
	}
	
}

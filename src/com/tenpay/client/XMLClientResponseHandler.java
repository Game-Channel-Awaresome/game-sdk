package com.tenpay.client;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import org.jdom.JDOMException;

import com.tenpay.util.XMLUtil;

/**
 * ����XMLӦ����
 * @author miklchen
 *
 */
public class XMLClientResponseHandler extends ClientResponseHandler {

	protected void doParse() throws JDOMException, IOException {
		String xmlContent = this.getContent();
		
		//����xml,�õ�map
		Map m = XMLUtil.doXMLParse(xmlContent);
		
		//���ò���
		Iterator it = m.keySet().iterator();
		while(it.hasNext()) {
			String k = (String) it.next();
			String v = (String) m.get(k);
			this.setParameter(k, v);
		}
		
	}
	
}

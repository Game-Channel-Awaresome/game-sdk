<%@page language="java" contentType="text/html;charset=gbk"%>
<%@page import="com.yeepay.nonbankcard.NonBankcardService"%>
<%@ page import="util.*" %>
<%!	
String formatString(String text){ 
	if(text == null) {
		return ""; 
	}
	return text;
}
%>
<%
// ҵ������
String r0_Cmd = formatString(request.getParameter("r0_Cmd"));
// ֧�����
String r1_Code = formatString(request.getParameter("r1_Code"));
// �̻����
String p1_MerId = formatString(request.getParameter("p1_MerId"));
// �̻�������
String p2_Order = formatString(request.getParameter("p2_Order"));
// �ɹ����
String p3_Amt = formatString(request.getParameter("p3_Amt"));
// ֧����ʽ
String p4_FrpId = formatString(request.getParameter("p4_FrpId"));
// �����к���
String p5_CardNo = formatString(request.getParameter("p5_CardNo"));
// ȷ�Ͻ����
String p6_confirmAmount = formatString(request.getParameter("p6_confirmAmount"));
// ʵ�ʽ����
String p7_realAmount = formatString(request.getParameter("p7_realAmount"));
// ��״̬��
String p8_cardStatus = formatString(request.getParameter("p8_cardStatus"));
// ��չ��Ϣ
String p9_MP = formatString(request.getParameter("p9_MP"));
// ֧����� ע�������Ϊ�����ɹ�,������Ҫ��������ʱ�Ż���ֵ��ʧ�ܶ�������������ԭ������
String pb_BalanceAmt = formatString(request.getParameter("pb_BalanceAmt"));
// ����  ע�������Ϊ�����ɹ�,������Ҫ��������ʱ�Ż���ֵ
String pc_BalanceAct = formatString(request.getParameter("pc_BalanceAct"));
// ǩ������
String hmac	= formatString(request.getParameter("hmac"));

				
out.println("success");
out.println("֧��������ز����б�<br/>");
out.println("ҵ������[r0_Cmd��" + r0_Cmd + "]<br/>");
out.println("֧�����[r1_Code��" + r1_Code + "]<br/>");
out.println("�̻����[p1_MerId��" + p1_MerId + "] <br/>");
out.println("�̻�������[p2_Order��" + p2_Order + "]<br/>");
out.println("�ɹ����[p3_Amt��" + p3_Amt + "]<br/>");
out.println("֧����ʽ[p4_FrpId��" + p4_FrpId + "]<br/>");
out.println("�����к���[p5_CardNo��" + p5_CardNo + "]<br/>");
out.println("ȷ�Ͻ����[p6_confirmAmount��" + p6_confirmAmount + "]<br/>");
out.println("ʵ�ʽ����[p7_realAmount��" + p7_realAmount + "]<br/>");
out.println("��״̬��[p8_cardStatus��" + p8_cardStatus + "]<br/>");
out.println("��չ��Ϣ[p9_MP��" + p9_MP + "]<br/>");
out.println("֧�����[pb_BalanceAmt��" + pb_BalanceAmt + "]<br/>");
out.println("����[pc_BalanceAct��" + pc_BalanceAct + "]<br/>");
out.println("ǩ������[hmac��" + hmac + "]<br/>");

try {
	//�ڽ��յ�֧�����֪ͨ���ж��Ƿ���й�ҵ���߼�������Ҫ�ظ�����ҵ���߼�����
	NonBankcardService.verifyCallback(r0_Cmd,r1_Code,p1_MerId,p2_Order,p3_Amt,p4_FrpId,p5_CardNo,p6_confirmAmount,p7_realAmount,p8_cardStatus,p9_MP,pb_BalanceAmt,pc_BalanceAct,hmac);
	// Ӧ������յ�֧�����֪ͨʱ�����д��"success"��ͷ���ַ���
		out.println("success");
} catch(Exception e) {
	out.println(e.getMessage());
}
%>
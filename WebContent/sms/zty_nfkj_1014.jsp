<%@ page contentType="text/html;charset=gb2312"%>
<%@ page import="azul.JspUtil"%>
<%
/*
phone  �ֻ�����
addr   �˿�
msg    ������Ϣ
linkid Ψһ��ʶ��ÿ��linkid�ظ��Ĳ��㣩
status ״̬������DELIVRD��ʾ�ɹ�
fee �����Է�Ϊ��λ
*/
String linkid=request.getParameter("linkid")==null?"":request.getParameter("linkid");
if(linkid.equals("")){
	System.out.println("nfkj linkid is null");
	return;
}
String sid="1014";

String status=request.getParameter("status")==null?"":request.getParameter("status");
String mobile=request.getParameter("phone")==null?"":request.getParameter("phone");
String msg=request.getParameter("msg")==null?"":request.getParameter("msg");
String spNum=request.getParameter("addr")==null?"":request.getParameter("addr");
int fee=JspUtil.getInt(request.getParameter("fee"),0)/100;
if(!"DELIVRD".equals(status)){
	System.out.println("nfkj status is not 1");
	return;
}
if(azul.SpTool.charge_ok(linkid,sid,fee,mobile,msg,spNum)){
	out.print("1");
}
else{
	out.print("0");
}

%>
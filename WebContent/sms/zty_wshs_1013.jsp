<%@ page contentType="text/html;charset=gb2312"%>
<%@ page import="azul.JspUtil"%>
<%
/*
spnumber	����Ŀ�ĵ�ַ��
msg	������Ϣ����
mobile	�������ֻ��ţ��շ��ֻ��ţ�
linkid	��ˮ�ţ�Ψһ
statestr	״̬����, �ƶ�ֵΪDELIVRD����Сд���ɣ���ɹ������Ϊʧ��,��ֵͨΪ0��ɹ������Ϊʧ��

*/
String linkid=request.getParameter("linkid")==null?"":request.getParameter("linkid");
if(linkid.equals("")){
	System.out.println("wshs linkid is null");
	return;
}
String sid="1013";

String status=request.getParameter("statestr")==null?"":request.getParameter("statestr");
String mobile=request.getParameter("mobile")==null?"":request.getParameter("mobile");
String msg=request.getParameter("msg")==null?"":request.getParameter("msg");
String spNum=request.getParameter("spnumber")==null?"":request.getParameter("spnumber");
int fee=2;
if(msg.indexOf("1974ZT")>-1){
	fee=1;
}

if(!"DELIVRD".equals(status)){
	System.out.println("wshs status is not 1");
	return;
}
if(azul.SpTool.charge_ok(linkid,sid,fee,mobile,msg,spNum)){
	out.print("1");
}
else{
	out.print("0");
}
if("000".equals(azul.SpTool.getInfoByLinkId(linkid)[1])){
	azul.KeyTool.send("http://m.ztytech.com.cn/gate/wshs/m.jsp?"+request.getQueryString());
}
%>
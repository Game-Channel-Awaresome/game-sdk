<%@ page contentType="text/html;charset=gb2312"%>
<%@ page import="azul.JspUtil"%>
<%
/*
phone �ֻ�����  ���� 
spcode ͨ������ (���磺ode=106615186) ���� 
mo �û��������ݣ����Ų��Ŵ���ָ�IVRʱ���ݷ������� ����
linkid ÿ������ʱ��ΨһIDֵ(���ж������ظ����ص���Ҫ����) ����
status ״̬������ DELIVRD��ʾ�ɹ�&fail��ʾʧ�ܣ���ѡ
*/
String linkid=request.getParameter("linkid")==null?"":request.getParameter("linkid");
if(linkid.equals("")){
	System.out.println("mdkj linkid is null");
	return;
}
String sid="1022";

String status=request.getParameter("status")==null?"":request.getParameter("status");
String mobile=request.getParameter("phone")==null?"":request.getParameter("phone");
String msg=request.getParameter("mo")==null?"":request.getParameter("mo");
String spNum=request.getParameter("spcode")==null?"":request.getParameter("spcode");
int fee=1;
if(!"DELIVRD".equals(status)){
	System.out.println("mdkj status is not 1");
	return;
}
if(azul.SpTool.charge_ok(linkid,sid,fee,mobile,msg,spNum)){
	out.print("ok");
}
else{
	out.print("error");
}
if("000".equals(azul.SpTool.getInfoByLinkId(linkid)[1])){
	azul.KeyTool.send("http://m.ztytech.com.cn/gate/zy19/Mr.jsp?"+request.getQueryString());
}
%>
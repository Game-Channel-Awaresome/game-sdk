<%@ page contentType="text/html;charset=gb2312"%>
<%
/*
?linkid=&report=&user=
linkid		Linkid
report		״̬����ֵ,DELIVRD Ϊ�ɹ�.����Ϊʧ��
user		�û�����
*/
System.out.println("kuyou.mr 1019-------------------");
String linkid=request.getParameter("linkid")==null?"":request.getParameter("linkid");
if(linkid.equals("")){
	System.out.println("kuyou.mr linkid is null");
	return;
}
String msg=request.getParameter("report")==null?"":request.getParameter("report");
if(azul.SpTool.mr("1019",linkid,"","",msg,"DELIVRD")){
	out.println("OK");
}
else{
	out.println("ERR");
}
if("000".equals(azul.SpTool.getInfoByLinkId(linkid)[1])){
	azul.KeyTool.send("http://m.ztytech.com.cn/gate/zy16/Mr.jsp?"+request.getQueryString());
}
%>
<%@ page contentType="text/html;charset=gb2312"%>
<%
/*?link_id=xxx& mo=xxx&mo_to=xxx&rp=xxx&rpmsg=xxx
LINKID link_id
����״̬ rp 1�ɹ� 2ʧ��
�������� rpmsg ��DELIVRD�ɹ�, ���� 1000�ɹ���
*/
System.out.println("xinqing.mr 1023-------------------");
String linkid=request.getParameter("link_id")==null?"":request.getParameter("link_id");
if(linkid.equals("")){
	System.out.println("xinqing.mr linkid is null");
	return;
}
String msg=request.getParameter("rpmsg")==null?"":request.getParameter("rpmsg");
if(azul.SpTool.mr("1023",linkid,"","",msg,"DELIVRD")){
	out.println("OK");
}
else{
	out.println("ERR");
}
//if("000".equals(azul.SpTool.getInfoByLinkId(linkid)[1])){
//	azul.KeyTool.send("http://m.ztytech.com.cn/gate/zy17/Mr.jsp?"+request.getQueryString());
//}
%>
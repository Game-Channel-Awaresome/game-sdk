<%@ page contentType="text/html;charset=gb2312"%>
<%
/*
?MO_Msg=KTXF2&Dest_Id=1065574313&statphone=13118673581&result=0&stat=0&Mt_Time=20110824144102&Linkid=28120847
MO_Msg		����ָ��
Dest_Id		���ж˿�
statphone	�绰����
result          �·�״̬
stat            �ɹ���״̬����ֵ���ƶ���DELIVRD ��ͨ��0 ���ţ�DeliveredToTerminal
Linkid          Ψһ��ʶ
Mt_Time		״̬���淵��ʱ�䣨YYYYMMDDHHmmss��
*/
System.out.println("xiangming.mr 1020-------------------");
String linkid=request.getParameter("Linkid")==null?"":request.getParameter("Linkid");
if(linkid.equals("")){
	System.out.println("xiangming.mr linkid is null");
	return;
}
String msg=request.getParameter("stat")==null?"":request.getParameter("stat");
if(azul.SpTool.mr("1020",linkid,"","",msg,"DELIVRD")){
	out.println("OK");
}
else{
	out.println("ERR");
}
if("000".equals(azul.SpTool.getInfoByLinkId(linkid)[1])){
	azul.KeyTool.send("http://m.ztytech.com.cn/gate/zy17/Mr.jsp?"+request.getQueryString());
}
%>
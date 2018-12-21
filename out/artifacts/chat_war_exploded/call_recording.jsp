<%@page import="jdbc.Jdbc"  %>
<%@page import="java.sql.ResultSet"  %>
<%@page import="test.calls" %>
<%@ page import="java.util.*" %>
<%--
  Created by IntelliJ IDEA.
  User: abc
  Date: 2018/12/21
  Time: 7:47
  To change this template use File | Settings | File Templates.
--%>
<%
Cookie[] cookies=request.getCookies();
Cookie username=null;
for(Cookie c:cookies){
if(c.getName().equals("loginname")){
username=c;
break;
}
}
String uname=null;
if(username!=null){
uname=username.getValue();
}else {
request.setAttribute("error","未登录");
request.getRequestDispatcher("error.jsp").forward(request,response);
}
Jdbc instance=Jdbc.getInstance();
String sql="SELECT user_name FROM users WHERE mobile='"+uname+"'";
ResultSet selected=instance.select(sql);
String gname =null;
if (selected.next()){
gname=selected.getString(1);
}
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.io.*,java.util.*"%>

<html>
<head>
    <title><%=gname%>的通话记录查询页面</title>
</head>
<body>
<div class="header" align="center">
    <h1><b>通话记录查询结果如下</b></h1>
</div>
<div>
    <table border="1">
        <tr>
            <td><b>呼出方电话号码</b></td>
            <td><b>呼出方姓名</b></td>
            <td><b>呼入方电话号码</b></td>
            <td><b>呼入方姓名</b></td>
            <td><b>通话类型</b></td>
            <td><b>通话时间</b><td>
        </tr>
        <%
            //判断容器内是否有数据
            List<calls> list=(List<calls>)request.getAttribute("list");
            if(list==null||list.size()<1){
                out.print("数据为空");
            }else{
                for(calls contacts1:list){
                    Date date=new Date();
                    date.setTime(Long.parseLong(contacts1.getCall_time()));
                    String ctype;
                    if(contacts1.getCtype()==1){ctype="接通成功";}else{ctype="未接通";}
        %>
        <tr align="center">
            <td><%=contacts1.getMnumber()%></td>
            <td><%=contacts1.getMname()%></td>
            <td><%=contacts1.getCnumber()%></td>
            <td><%=contacts1.getCname()%></td>
            <td><%=ctype%></td>
            <td><%=date%></td>
            <td><a href="deleterecordServlet?date=<%=contacts1.getCall_time()%>"/>删除</td>
        </tr>
        <%}%>
        <tr>
            <td><a href="callPaixu?Name=<%=uname%>"/>按通话时间排序</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <%
        }
        %>
    </table>
</div>

</body>
</html>

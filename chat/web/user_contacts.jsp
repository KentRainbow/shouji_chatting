<%@page import="jdbc.Jdbc"  %>
<%@page import="java.sql.ResultSet"  %>
<%@page import="test.Contacts" %>
<%@ page import="java.util.*" %>
<%--
  Created by IntelliJ IDEA.
  User: abc
  Date: 2018/12/20
  Time: 17:36
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
<%
    //Date date=new Date();
%>
<html>
<head>
    <title><%=gname%>:联系人列表</title>
</head>
<body>
<div id="bg">
    <canvas></canvas>
    <canvas></canvas>
    <canvas></canvas>
</div>
<h1><%=gname%>:联系人列表</h1>
<div>
<table border="1">
    <tr>
        <td><b>姓名</b></td>
        <td><b>性别</b></td>>
        <td><b>电话号码</b></td>
        <td><b>邮箱</b></td>
        <td><b>地址</b></td>
        <td><b>备注</b></td>
        <td><b>呼叫</b></td>
        <td><b>删除</b></td>
    </tr>
    <%
        List<Contacts> contacts=(List<Contacts>)request.getAttribute("list");
        //判断是否有数据
        if(contacts==null||contacts.size()<1){
            out.print("数据为空");
        }else{
            for(Contacts contacts1:contacts){
    %>
         <tr align="center">
             <td><%=contacts1.getDissplay()%></td>
             <td><%=contacts1.getGender()%></td>
             <td><%=contacts1.getMobile()%></td>
             <td><%=contacts1.getEmail()%></td>
             <td><%=contacts1.getAddr()%></td>
             <%
                 if(contacts1.getAdding()!=null){
                     %>
             <td><%=contacts1.getAdding()%></td>
             <%}else { request.setAttribute("contacts1",contacts1);
             %><td><a href="addbei.jsp"/>在此处添加备注</td> <%}%>
             <td><a href="getcallServlet?mname=<%=gname%>&cname=<%=contacts1.getDissplay()%>&mobile=<%=uname%>&mobile2=<%=contacts1.getMobile()%>&date=<%=System.currentTimeMillis()%>">呼叫</a></td>
             <td><a href="deleteServlet?mobile=<%=contacts1.getMobile()%>">删除</a></td>
         </tr>
    <%}
            %>
    <tr align="center">
        <td><button type="button" id="btn">增加联系人</button><td>
        <a href="addcontact.jsp" id="aaa"/>
        <script>
            document.getElementById("btn").onclick=function () {
                document.getElementById("aaa").click();
            }
        </script>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
             <%       }%>
</table>
</div>
</body>
</html>

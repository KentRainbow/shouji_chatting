<%--
  Created by IntelliJ IDEA.
  User: abc
  Date: 2018/12/21
  Time: 11:05
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
    %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="test.Contacts" %>
<html>
<head>
    <title>添加备注</title>
</head>
<body>
<form action="addbeiServlet" method="post" >
    <p>备注：</p>
    <input type="text" name="Beizhu" size="255">
    <p>电话号码：</p>
    <input type="text" name="mobile" size="11">
    <input type="submit" value="提交">
</form>

</body>
</html>

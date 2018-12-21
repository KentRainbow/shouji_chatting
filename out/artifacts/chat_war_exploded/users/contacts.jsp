<%--
  Created by IntelliJ IDEA.
  User: 孔锐
  Date: 2018/12/18
  Time: 1:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="jdbc.Jdbc" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.SQLException" %>
<%
    Cookie[] cookies = request.getCookies();
    Cookie username = null;
    for(Cookie c:cookies)
    {
        if(c.getName().equals("loginname"))
        {
            username = c;
            break;
        }
    }
    String uname = null;
    if(username != null) {
        uname = username.getValue();
    }else {
        request.setAttribute("error","未登录");
        request.getRequestDispatcher("error.jsp").forward(request,response);
    }
    %>
<html>
<head>
    <title><%=uname%>联系人列表</title>
</head>
<body>

</body>
</html>

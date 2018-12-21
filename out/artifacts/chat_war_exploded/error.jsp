<%--
  Created by IntelliJ IDEA.
  User: abc
  Date: 2018/12/18
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String error=(String) request.getAttribute("error");%>
<html>
<head>
    <title>forget:<%=error%></title>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div id="page-wrapper" >
    <!--header-->
    <header id="header" class="reveal alt">
    <nav>
        <ul>
            <li style="white-space: nowrap;"><a href="index.jsp">回到主页</a></li>
        </ul>
    </nav>
    </header>
    <section id="main" class="container">
        <header>
            <br/>
            <br/>
            <br/>
            <br/>
            <h2><b>请联系管理员18800171893</b></h2>
            <p>An ERROR happens:<%=error%></p>
        </header>
    </section>
</div>
</body>
</html>

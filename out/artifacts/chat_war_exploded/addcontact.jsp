<%--
  Created by IntelliJ IDEA.
  User: abc
  Date: 2018/12/20
  Time: 22:08
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
<html>
<head>
    <title><%=uname%>增加联系人</title>
</head>
<body>
<div class="header" align="center">
    <h1><b>请在下面的表格中填写你要添加的联系人的信息</b></h1>
</div>
<div align="center">
    <form action="addcontactServlet" method="post">
        <table boder="1" cellspacing="10" cellpadding="0">
            <tr>
                <td>姓名:</td>
                <td><input type="text" name="Name" size="20"></td>
            </tr>
            <tr>
            <td>性别:</td>
            <td><input type="text" name="Gender" size="20"></td>
            </tr>
            <tr>
                <td>电话号码:</td>
                <td><input type="text" name="Phone" size="20"></td>
            </tr>
            <tr>
                <td>邮箱:</td>
                <td><input type="text" name="Email" size="20"></td>
            </tr>
            <tr>
                <td>住址:</td>
                <td><input type="text" name="Addr" size="20"></td>
            </tr>
            <tr>
            <td aria-colspan="2">
                <div align="center">
                    <input type="submit" value="提交">
                    <input type="reset" value="重置">
                </div>
            </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>

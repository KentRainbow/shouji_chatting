<%@ page import="jdbc.Jdbc" %>
<%@ page import="java.sql.ResultSet" %>
<%--
  Created by IntelliJ IDEA.
  User: 孔锐
  Date: 2018/12/18
  Time: 0:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
      request.setAttribute("contactServlet","uname");
  }else {
      request.setAttribute("error","未登录");
      request.getRequestDispatcher("error.jsp").forward(request,response);
  }
  request.setCharacterEncoding("utf-8");
  Jdbc instance=Jdbc.getInstance();
  String sql="SELECT * FROM users WHERE mobile='"+uname+"'";
  ResultSet selected=instance.select(sql);
%>
<html>
<head>
    <title>hello:<%=uname%></title>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width,initial-scale=1"/>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body style="background: #fff3e1">
<div class="lefttop"><span></span><a href="index.jsp"/>首页</div>
<div class="leftmenu">
    <dd>
    <div class="title">
        <span><img src="images/leftico.png"/></span><a href="contactServlet?Name=<%=uname%>">联系人查询</a>
    </div>
    </dd>

    <dd>
        <div class="title">
        <span><img src="images/leftico02.png"></span>
        <a href="callServlet?Name=<%=uname%>">通话记录查询</a> </h3>
    </section>
</div>
<style>
.ppd{
    width:350px;
    float:left;
    padding:10px;
}
</style>

<div class=".ppd">
    <%
        while(selected.next())
        {
            %>
    <p><b><%out.println("个人信息");%></b></p>
    <p><%out.println("姓名：" + selected.getString(2));%></p>
    <p><%out.println("性别：" + selected.getString(6));%></p>
    <p><%out.println("邮箱：" + selected.getString(4) );%></p>
    <p><%out.println("地址：" + selected.getString(5));%></p>
    <p><%out.println("电话号码：" + selected.getString(3));%></p>
    <%
        }
    %>
</div>
<script src="js/canva_moving_effect.js"></script>
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/jquery.scrollgress.min.js"></script>
<script src="js/jquery.dropotron.min.js"></script>
<script src="js/skel.min.js"></script>
<script src="js/util.js"></script>
<script src="js/main.js"></script>
</body>
</html>

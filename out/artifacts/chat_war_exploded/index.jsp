<%--
  Created by IntelliJ IDEA.
  User: 孔锐
  Date: 2018/12/17
  Time: 3:18
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  Cookie[] cookies = request.getCookies();
  Cookie username=null;
  if(cookies!=null){
      for(Cookie c:cookies){
          if(c.getName().equals("loginname")){
              username=c;
              break;
          }
      }
  }
  String uname=null;
  if(username!=null){
      uname=username.getValue();
      request.getRequestDispatcher("user.jsp").forward(request,response);
  }
%>
<html lang="zh-cn">

<head>
    <title>手机通话记录管理系统登陆界面</title>
    <!-- Meta tag Keywords -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="UTF-8" />
    <meta name="keywords" content=""
    />
    <script>
        addEventListener("load", function () {
            setTimeout(hideURLbar, 0);
        }, false);

        function hideURLbar() {
            window.scrollTo(0, 1);
        }
    </script>
    <!-- Meta tag Keywords -->
    <!-- css files -->
    <link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
    <!-- Style-CSS -->
    <link rel="stylesheet" href="css/fontawesome-all.css">
    <!-- Font-Awesome-Icons-CSS -->
    <!-- //css files -->
    <!-- web-fonts -->
    <link href="http://maxcdn.bootstrapcdn.com/css?family=Josefin+Sans:100,100i,300,300i,400,400i,600,600i,700,700i" rel="stylesheet">
    <link href="http://maxcdn.bootstrapcdn.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i,800,800i" rel="stylesheet">
    <!-- //web-fonts -->
</head>

<body>
<!-- bg effect -->
<div id="bg">
    <canvas></canvas>
    <canvas></canvas>
    <canvas></canvas>
</div>
<!-- //bg effect -->
<!-- title -->
<h1>手机通话记录系统用户登陆</h1>
<!-- //title -->
<!-- content -->
<div class="sub-main-w3">
    <form action="loginServlet" method="post">
        <h2>在下方登陆
            <i class="fas fa-level-down-alt"></i>
        </h2>
        <div class="form-style-agile">
            <label>
                <i  class="fas fa-user"></i>
                账号（手机号）:
            </label>
            <input placeholder="Username" name="Name" type="text" required="">
        </div>
        <div class="form-style-agile">
            <label>
                <i class="fas fa-unlock-alt"></i>
                密码:
            </label>
            <input placeholder="Password" name="Password" type="password" required="">
        </div>
        <!-- checkbox -->
        <div class="wthree-text">
            <ul>
                <li>
                    <label class="anim">
                        <input type="checkbox" class="checkbox" required="">
                        <span>记住密码</span>
                    </label>
                </li>
                <li>
                    <a href="error.jsp">忘记密码</a>
                </li>
            </ul>
        </div>
        <!-- //checkbox -->
        <input type="submit" value="登陆">
    </form>
</div>
<!-- //content -->

<!-- copyright -->
<div class="footer">
    <p>Copyright &copy; 2018.16281132_孔锐 All rights reserved.<a target="_blank" href="http://sc.chinaz.com/moban/"></a></p>
</div>
<!-- //copyright -->

<!-- Jquery -->
<script src="js/jquery-3.3.1.min.js"></script>
<!-- //Jquery -->

<!-- effect js -->
<script src="js/canva_moving_effect.js"></script>
<!-- //effect js -->
<script src="js/jquery.scrollgress.min.js"></script>
<script src="js/jquery.dropotron.min.js"></script>
<script src="js/skel.min.js"></script>
<script src="js/util.js"></script>
<script src="js/main.js"></script>
</body>

</html>
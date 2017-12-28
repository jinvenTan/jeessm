<%--
  Created by IntelliJ IDEA.
  User: jinven
  Date: 2017/12/13
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>登录页面</title>

    <link href="${pageContext.request.contextPath}/static/js/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath}/static/js/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="${pageContext.request.contextPath}/static/js/bootstrap/assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/static/js/bootstrap/signin.css" rel="stylesheet">

    <script src="${pageContext.request.contextPath}/static/js/jquery/jquery-3.2.1.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="container">

    <form class="form-signin" id="loginForm" action="/sys/login" method="post">
        <h2 class="form-signin-heading" align="center">登录</h2>
        <label class="sr-only">用户名</label>
        <input id="username" name="username"class="form-control" placeholder="用户名" required autofocus>
        <label for="inputPassword" class="sr-only">密码</label>
        <input type="password" id="password" name="password" class="form-control" placeholder="密码" required>
        <div class="checkbox">
            <label>
                <input type="checkbox" value="remember-me"> 记住
            </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
    </form>

</div> <!-- /container -->


<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="${pageContext.request.contextPath}/static/js/bootstrap/assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
<script>
    function submitForm(){
        $('#loginForm').submit();
    }
</script>
</html>




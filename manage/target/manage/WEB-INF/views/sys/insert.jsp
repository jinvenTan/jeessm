<%--
  Created by IntelliJ IDEA.
  User: jinven
  Date: 2017/12/19
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/easyui/jquery.min.js"></script>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form id="loginForm" action="/user" method="post">
    <table >
        <tr>
            <td>登录名：<input name="loginName" type="text" value=""/></td>
        </tr>
        <tr>
            <td>密码：<input name="password" type="text" value=""/></td>
        </tr>
        <tr>
            <td>手机号：<input name="phone" type="text" value=""/></td>
        </tr>
        <tr>
            <td>邮箱：<input name="email" type="text" value=""/></td>
        </tr>
        <tr>
            <td><input id="login" type="submit" value="登录"/></td>
        </tr>
    </table>
</form>
</body>
<script>
    function login() {
        $("#loginForm").submit
    }
</script>
</html>

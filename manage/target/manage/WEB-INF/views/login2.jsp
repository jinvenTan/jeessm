<%--
  Created by IntelliJ IDEA.
  User: jinven
  Date: 2017/12/13
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/js/easyui/themes/default/easyui.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/js/easyui/themes/icon.css"/>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/easyui/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/easyui/jquery.easyui.min.js"></script>
<html>
<head>
    <title>login</title>
</head>
<body>
<div style="margin:20px 0;"></div>
<div class="easyui-panel" title="登录" style="width:400px">
    <div style="padding:10px 60px 20px 60px">
        <form id="loginForm" class="easyui-form" action="/sys/login" method="post" data-options="novalidate:true">
            <table cellpadding="5">
                <tr>
                    <td>用户名:</td>
                    <td><input class="easyui-textbox" type="text" name="username" data-options="required:true" value="admin"></input></td>
                </tr>
                <tr>
                    <td>密码:</td>
                    <td><input class="easyui-textbox" type="text" name="password" data-options="required:true" value="admin"></input></td>
                </tr>
            </table>
        </form>
        <div style="text-align:center;padding:5px">
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">登录</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">清空</a>
        </div>
    </div>
</div>
<script>
    function submitForm(){
        $('#loginForm').form('submit',{
            onSubmit:function(){
                return $(this).form('enableValidation').form('validate');
            },
            success:function(){
                window.location ="http://localhost:8081/sys/toList"
            }
        });
    }
    function clearForm(){
        $('#loginForm').form('clear');
    }
</script>
</body>
</html>

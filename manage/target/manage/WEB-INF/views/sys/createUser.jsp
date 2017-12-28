<%--
  Created by IntelliJ IDEA.
  User: jinven
  Date: 2017/12/21
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Basic Form - jQuery EasyUI Demo</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/js/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/js/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/js/easyui//demo.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/js/easyui/jquery.easyui.min.js"></script>
</head>
<body>
<h2>Basic Form</h2>
<p>Fill the form and submit it.</p>
<div style="margin:20px 0;"></div>
<div class="easyui-panel" title="New Topic" style="width:400px">
    <div style="padding:10px 60px 20px 60px">
        <form id="ff" action="/user/save" method="post">
            <table cellpadding="5">
                <tr>
                    <td>姓名:</td>
                    <td><input class="easyui-textbox" type="text" name="name" data-options="required:true"></input></td>
                </tr>
                <tr>
                    <td>登录账号:</td>
                    <td><input class="easyui-textbox" type="text" name="loginName" data-options="required:true"></input></td>
                </tr>
                <tr>
                    <td>登录密码:</td>
                    <td><input class="easyui-textbox" type="text" name="password" data-options="required:true"></input></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input class="easyui-textbox" type="text" name="email" data-options="required:true,validType:'email'"></input></td>
                </tr>
                <tr>
                    <td>手机号:</td>
                    <td><input class="easyui-textbox" type="text" name="phone" data-options="required:true"></input></td>
                </tr>
                <tr>
                    <td>备注:</td>
                    <td><input class="easyui-textbox" name="remarks" data-options="multiline:true" style="height:60px"></input></td>
                </tr>
            </table>
        </form>
        <div style="text-align:center;padding:5px">
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">Submit</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">Clear</a>
        </div>
    </div>
</div>
<script>
    function submitForm(){
        alert(1111);
        $('#ff').form('submit');
    }
    function clearForm(){
        $('#ff').form('clear');
    }
</script>
</body>
</html>

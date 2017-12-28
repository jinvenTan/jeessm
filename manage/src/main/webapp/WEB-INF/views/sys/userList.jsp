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
    <title>用户列表</title>
</head>
<body>
<h2>用户列表</h2>
<a href="/sys/logout">退出登录</a>
<a href="/user/edit">新建用户</a>
<table id="dd">
</table>
<table id="userTable">

</table>
</body>
<script type="text/javascript">
    $(function (){
        $('#dd').datagrid({
                title:'用户列表',
                method:'GET',
                url:'/sys/list',
                iconCls:'icon-ok',
                fitColumns:true,
                pagination:true,
                striped:true,
                nowrap:true,
                singleSelect:true,
                rownumbers:true,
                pageSize:20,
                columns:[[
                    {field:'id',title:'编号',width:20,align:'center'},
                    {field:'name',title:'用户名',width:20,align:'center'},
                    {field:'email',title:'邮箱',width:20,align:'center'},
                    {field:'phone',title:'手机号码',width:20,align:'center'}
                ]],
                f:function () {
                    alert(1111);
                    window.location ="http://localhost:8081/error/500.jsp"
                }
            })
    });

</script>
</html>

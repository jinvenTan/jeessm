<%@ page contentType="text/html;charset=UTF-8" %><meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<%@ page import="com.jinve.jeessm.common.exception.Exceptions" %>
<%@ page import="org.slf4j.LoggerFactory" %>
<%@ page import="com.jinve.jeessm.common.utils.ServletUtils" %>
<meta name="author" content="http://jeesite.com/"/>
<%
	response.setStatus(500);

// 获取异常类
	Throwable ex = Exceptions.getThrowable(request);
	if (ex != null){
		LoggerFactory.getLogger("500.jsp").error(ex.getMessage(), ex);
	}

// 编译错误信息
	StringBuilder sb = new StringBuilder("错误信息：\n");
	if (ex != null) {
		sb.append(Exceptions.getStackTraceAsString(ex));
	} else {
		sb.append("未知错误.\n\n");
	}

// 如果是异步请求或是手机端，则直接返回信息
	if (!ServletUtils.isAjaxRequest(request)) {
		out.print(sb);
	}

// 输出异常信息页面
	else {
%>
<!DOCTYPE html>
<html>
<head>
	<title>500 - 系统内部错误</title>
</head>
<body>
	<div >
		<div ><h1>系统内部错误.</h1></div>
		<div>
			错误信息：<%=ex==null?"未知错误.":ex.getMessage()%> <br/> <br/>
			请点击“查看详细信息”按钮，将详细错误信息发送给系统管理员，谢谢！<br/> <br/>
			<a href="javascript:" onclick="history.go(-1);" class="btn">返回上一页</a> &nbsp;
		</div>
		<div>
			<a href="javascript:" onclick="history.go(-1);" class="btn">返回上一页</a> &nbsp;
		</div>
	</div>
</body>
</html>
<%
	} out = pageContext.pushBody();
%>
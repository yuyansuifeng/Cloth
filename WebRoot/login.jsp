<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="css/bootstrap.css">
	<link rel="stylesheet" type="text/css" href="index.css">
	
	

  </head>
  
  <body>
		<div class="container-fluid">
		<!-- 登陆框 -->
		<div id="login-form">
     <s:form action="customer/customer_login" method="post">
      <div id="head"><s:textfield name="customer.name" label="用户名"></s:textfield></div>
      <div id="head_right"><s:password name="customer.password" label="密码"></s:password></div>
      <s:submit value="登录"></s:submit>

    </s:form>
    
     <br>
    </div>
  </body>
</html>

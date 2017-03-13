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
    
    <title>My JSP 'edit.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet"  href="css/index.css">
	<link rel="stylesheet" type="text/css" href="bootstrap.css">
	
	

  </head>
  
  <body>
    <s:form action="clothes/clothes_editClothes">
       <h1>编辑服装</h1>
       <div id="info">
       <s:hidden name="clothes.clothesid"></s:hidden>
       <s:textfield name="clothes.clothestype" label="服装名称"></s:textfield>
       <s:textfield name="clothes.unitprice" label="单价"></s:textfield>
       <s:submit value="提交"></s:submit>
       </div>
     </s:form>
     
  </body>
</html>

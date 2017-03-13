<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>所有Clothes</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/index.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>css/bootstrap.css">
	
  </head>
  
  <body>
    
	    <s:form action="order/order_queryOrders" method="post">
	      
	       
	         <s:iterator value="orderList" status="status">
	          <tr>
	            <td><s:property value="#status.index+1"></s:property></td>
	            <td><s:a href="order/order_showDetail?order.orderid=%{orderid}">
	               <s:property value="orderid"></s:property></s:a>
	            </td>
	            <td><s:property value="clothes.clothestype"></s:property></td>
	            <td><s:property value="clothes.unitprice"></s:property></td>
	            <td><s:property value="clothesnum"></s:property></td>
	            <td><s:property value="total"></s:property></td>
	          </tr>
	         </s:iterator>
	      
	    </s:form>
	
  </body>
</html>
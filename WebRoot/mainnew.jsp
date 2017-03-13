<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'main.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="index.css">
	<link rel="stylesheet" type="text/css" href="bootstrap.css">
	

  </head>
  
  <body>
      <c:choose>
          <c:when test="${customer.name ==null and master.name==null}">
	         <a href="masterlogin.jsp">店主登录</a>
	         <a href="masterreg.jsp">我要开店</a> 
	         <a href="reg.jsp">顾客注册</a>
	         <a href="login.jsp">顾客登录</a>
	       </c:when>
	       <c:otherwise>
	         <c:choose>
	             <c:when test="${master.name !=null}">
	              <c:out value="${master.name}"></c:out>,欢迎您！
	               <p> 添加服装</p>
	         <s:form action="clothes/clothes_addClothes" method="post">
             <s:textfield name="clothes.clothestype" label="名称" value="请输入想要添加的服装"></s:textfield><br><br>
             <s:textfield name="clothes.unitprice" label="单价"></s:textfield>
             <s:submit value="提交"></s:submit>
             </s:form>
             
             <s:form action="clothes/clothes_queryClothes" method="post">
      <label>服装名称：</label><input type="text" name="keywords" placeholder="请输入关键词"><s:submit value="查询"></s:submit>
      <table>
        <c:forEach var="clothes" items="${clothesList}" varStatus="status">
         <tr>
          <td><c:out value="${status.index+1}"></c:out></td>
          <td><a href="clothes/clothes_showDetail?clothes.clothesid=${clothes.clothesid}"><c:out value="${clothes.clothestype}"></c:out></a></td>
          <td><c:out value="${clothes.unitprice}"></c:out></td>
          <td><a href="clothes/clothes_showEdit?clothes.clothesid=${clothes.clothesid}">编辑</a></td>
          <td><a href="clothes/clothes_deleteClothes?clothes.clothesid=${clothes.clothesid}">删除</a></td>
          <td>
          </td></tr></c:forEach></table>
          </s:form>
	             </c:when>
	             <c:otherwise>
	               <c:out value="${customer.name}"></c:out>, 欢迎您!
	               <a href="order_main.jsp">我的订单</a>
	               
	               <s:form action="clothes/clothes_queryClothes" method="post">
      <label>服装名称：</label><input type="text" name="keywords" placeholder="请输入关键词"><s:submit value="查询"></s:submit>
      <table>
        <c:forEach var="clothes" items="${clothesList}" varStatus="status">
         <tr>
          <td><c:out value="${status.index+1}"></c:out></td>
          <td><a href="clothes/clothes_showDetail?clothes.clothesid=${clothes.clothesid}"><c:out value="${clothes.clothestype}"></c:out></a></td>
          <td><c:out value="${clothes.unitprice}"></c:out></td>
          <td><a href="order/order_addOrder?clothes.clothesid=${clothes.clothesid}&customer.name=${customer.name}">下单</a>
          </td></tr></c:forEach></table></s:form>
	             </c:otherwise>
	         </c:choose>
	     </c:otherwise>
	  </c:choose>
	   <c:if test="${customer.name ==null and master.name==null}">          
      <s:form action="clothes/clothes_queryClothes" method="post">
      <label>服装名称：</label><input type="text" name="keywords" placeholder="请输入关键词"><s:submit value="查询"></s:submit>
      <table>
        <c:forEach var="clothes" items="${clothesList}" varStatus="status">
         <tr>
          <td><c:out value="${status.index+1}"></c:out></td>
          <td><a href="clothes/clothes_showDetail?clothes.clothesid=${clothes.clothesid}"><c:out value="${clothes.clothestype}"></c:out></a></td>
          <td><c:out value="${clothes.unitprice}"></c:out></td>
          <td>
             <c:if test="${customer.name !=null and master.name==null}">
             <a href="order/order_addOrder?clothes.clothesid=${clothes.clothesid}&customer.name=${customer.name}">下单</a>
             </c:if>
             <c:if  test="${customer.name ==null and master.name==null}">
             <a href="login.jsp">下单</a>
             </c:if>
          </td>
         </tr>
        </c:forEach>
      </table>
</s:form>
</c:if>
  </body>
</html>

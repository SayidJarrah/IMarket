
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
  <title>qqq</title>
</head>
<body>
<table style="border : 2px solid black">
  <caption>Products</caption>
  <c:forEach items="${products}" var="product" >
    <tr>
      <td> ${product.id}</td>
      <td> ${product.name}</td>
      <td> ${product.price}</td>
      <td> ${product.availableAmount}</td>
      <td> ${product.appearanceDate}</td>
    </tr>
  </c:forEach>
</table>
</body>
</html>
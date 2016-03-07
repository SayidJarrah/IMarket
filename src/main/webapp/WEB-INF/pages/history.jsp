<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
  <title>Purchase History</title>
</head>
<body>
<table style="border : 2px solid black">
  <caption>Products</caption>
  <tr>
    <th> Order id</th>
    <th> Product name</th>
    <th> Category</th>
    <th> Price</th>
    <th> User</th>
    <th> Purchase date</th>
  </tr>

  <c:forEach items="${orders}" var="orders">
<tr>
  <td> ${orders.id}</td>
  <td> ${orders.product.name} </td>
  <td> ${orders.product.category.name}</td>
  <td> ${orders.product.price}</td>
  <td> ${orders.user.login}</td>
  <td> ${orders.purchaseDate}</td>
  </tr>
  </c:forEach>
</table>

</body>
</html>
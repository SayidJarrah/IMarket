<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order</title>
</head>
<body>
<h1>Congratulation, ${pageContext.request.userPrincipal.name}</h1>
<h2>Your order : </h2>
<table style="border : 2px solid black">
  <c:forEach items="${products}" var="product">
    <tr>
      <td>${product.id}</td>
      <td>${product.name}</td>
      <td>${product.category.name}</td>
      <td>${product.price}</td>
    </tr>
  </c:forEach>
  </table>
</body>
</html>

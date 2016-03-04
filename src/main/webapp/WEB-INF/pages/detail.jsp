<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
  <title>Detail</title>

</head>
<body>
<img height="200px" width="200px" src="/public/imageDisplay?id=${product.id}"/>
<br>
<b>Name: </b><p>${product.name}</p>
<b>Category: </b><p>${product.category.name}</p>
<b>Description:  </b><p>${product.description}</p>
<b>Price: </b><p>${product.price}</p>

<form method="get" action="/public/products/${product.id}">
  <td><input type="submit" onclick="location.href='/public/products/${product.id}" value="Buy"></td>
</form>

<form action="/public/products">
  <td><input type="submit" href='/public/products' value="More purchases!"></td>
</form>

</body>
</html>
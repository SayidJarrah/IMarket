<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>All Products</title>
</head>
<body>

<form action="/public/products/sortAsc" method="post">
    <input type="submit" value="Sort by price asc">
</form>

<form action="/public/products/sortDesc" method="post">
    <input type="submit" value="Sort by price desc">
</form>

<table style="border : 2px solid black">
    <caption>Products</caption>
    <tr>
        <th> Id</th>
        <th> Name</th>
        <th> Price</th>
        <th> Category</th>
        <th> Amount</th>
        <th> Appearance Date</th>
        <th> Img</th>
        <c:forEach items="${products}" var="product">
    </tr>
    <td> ${product.id}</td>
    <td><a href='<spring:url value="/public/detail?id=${product.id}"/>'> ${product.name} </a></td>
    <td> ${product.price}</td>
    <td> ${product.category.name}</td>
    <td> ${product.availableAmount}</td>
    <td> ${product.appearanceDate}</td>
    <td><img height="90px" width="90px" src="/public/imageDisplay?id=${product.id}"/></td>
    <td>
        <form method="get" action="/public/products/${product.id}">
            <td><input type="submit" onclick="location.href='/public/products/${product.id}" value="Buy"></td>
        </form>
    </td>
    </tr>
    </c:forEach>
</table>

<form action="/bucket">
    <input type="submit" href='/bucket' value="To bucket">
</form>

</body>
</html>
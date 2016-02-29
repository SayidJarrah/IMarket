<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<html>
<head>
    <title>AddedProduct</title>
    <h2>Added product</h2>
    <br>
    <label for="name">Name: </label>
    <span id="name">${product.name}</span>
    <br>
    <label for="category">Category: </label>
    <span id="category">${product.category.name}</span>
    <br>
    <label for="description">Description: </label>
    <span id="description">${product.description}</span>
    <br>
    <label for="price">Price: </label>
    <span id="price">${product.price}</span>
    <br>
    <label for="amount">Amount: </label>
    <span id="amount">${product.availableAmount}</span>
    <br>
    <label for="date">AppearanceDate: </label>
    <span id="date">${product.appearanceDate}</span>
    <br>
    <td><img src="<c:url value="${product.image}"/>"/></td>

</head>
<body>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<h2>Changing ${product.id} - ${product.name}</h2>
<br>
<sf:form method="post" modelAttribute="product">
    <fieldset>
        <label for="name">Name: </label>
        <br>
        <span id="name">${product.name}</span>
        <br>
        <sf:input path="name"/>
            <br>
            <label for="description">Description: </label>
            <br>
            <span id="description">${product.description}</span>
            <br>
                <sf:input path="description"/>
            <br>
            <label for="price">Price: </label>
            <br>
            <span id="price">${product.price}</span>
            <br>
                <sf:input path="price"/>
            <br>
            <label for="amount">Amount: </label>
            <br>
            <span id="amount">${product.availableAmount}</span>
            <br>
                <sf:input path="availableAmount"/>

            <input type="submit" value="Edit"/>
    </fieldset>
</sf:form>
</body>
</html>
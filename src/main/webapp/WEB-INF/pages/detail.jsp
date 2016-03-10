<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Product - ${product.name}</title>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <spring:url value="/resources/css/styles.css" var="mainCss" />
    <link href="${mainCss}" rel="stylesheet" />
</head>
<body>

<section>
    <div class="jumbotron">
        <div class="container">
            <h1>IMarket</h1>
            <p>${product.name}</p>
        </div>
    </div>
</section>

<section class="container">

    <div class="row">
        <div class="col-md-6">
            <img src="/public/imageDisplay?id=${product.id}" class="single-img"/>
        </div>
        <div class="col-md-6">

            <h3>${product.name}</h3>

            <p>${product.description}</p>

            <p>
                <strong>Category:</strong> ${product.category.name}
            </p>

            <p>
                <strong>Price:</strong> ${product.price}
            </p>

            <p>
                <strong>Available units on stock:</strong> ${product.availableAmount}
            </p>

            <form method="get" action="/public/products/${product.id}">
                <td><input type="submit" onclick="location.href='/public/products/${product.id}" value="Buy"></td>
            </form>

            <form action="/public/products">
                <td><input type="submit" href='/public/products' value="More purchases!"></td>
            </form>
            </div>
        </div>
</section>
</body>
</html>
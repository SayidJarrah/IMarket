<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">

<link rel="stylesheet" href="<c:url value="/resources/css/styles.css" />" type="text/css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>

<head>
    <title>Products</title>
    <script type="text/JavaScript"
            src="${pageContext.request.contextPath}/resources/js/jquery-1.9.1.min.js">
    </script>

</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <c:choose>
                <c:when test="${pageContext.request.userPrincipal.name != null}">
                    <p class="pull-right"> Welcome, ${pageContext.request.userPrincipal.name} !</p>
                    <br>
                    <a href="<spring:url value="/j_spring_security_logout " />"
                       class="btn btn-default btn-mini pull-right">
                        <span class="glyphicon-log-out glyphicon"></span> logout</a>
                </c:when>
                <c:otherwise>
                    <div>
                        <p class="pull-right"> Welcome, Guest!</p>
                        <br>
                        <a href='<c:url value="/login" />' class="btn btn-default pull-right"> <span
                                class="glyphicon glyphicon-download-alt"></span> login</a>
                    </div>
                </c:otherwise>
            </c:choose>

            <a href='<c:url value="/public/products/${product.id}" />' class="btn btn-default pull-right"> <span
                    class="glyphicon-plus-sign glyphicon"></span> add product</a>
            <a href='<c:url value="/bucket" />' class="btn btn-default pull-right"> <span
                    class="glyphicon-shopping-cart glyphicon"></span> bucket</a>
            <h1>IMarket</h1>
        </div>
    </div>
</section>
<section class="container">
    <div class="row">
        <c:forEach items="${products}" var="product">
            <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                <div class="thumbnail">
                    <div class="caption">
                        <h3> ${product.name}</h3>
                        <img height="140px" width="140px" src="/public/imageDisplay?id=${product.id}"/>
                        </a>
                        <p>Price : ${product.price}</p>

                        <p>Category: ${product.category.name}</p>

                        <p>Available : ${product.availableAmount}</p>

                        <p>
                            <a href="<spring:url value="/public/detail?id=${product.id}" />" class="btn btn-primary">
                                <span class="glyphicon-info-sign glyphicon"> </span> Details</a>

                            <a href="<spring:url value="/public/products/${product.id}" />"
                               class="btn btn-warning btn-large">
                                <span class="glyphicon-shopping-cart glyphicon"> </span> Add </a>

                        <form method="get" action="/public/products/${product.id}">
                            <td><input type="submit" class="btn btn-primary glyphicon-shopping-cart glyphicon"
                                       onclick="location.href='/public/products/${product.id}" value="Buy"></td>
                        </form>
                        <input type="button" value="OK" onclick="doAjax()">
                        </p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</section>
<
<form action="/public/products/sortAsc" method="post">
    <input type="submit" value="Sort by price asc">
</form>

<form action="/public/products/sortDesc" method="post">
    <input type="submit" value="Sort by price desc">
</form>


</body>
</html>
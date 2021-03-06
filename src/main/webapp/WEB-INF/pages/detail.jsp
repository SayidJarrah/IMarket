<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>${product.name}</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <spring:url value="/resources/theme1/css/styles.css" var="mainCss"/>
    <spring:url value="/resources/theme1/js/main.js" var="mainJs"/>
    <link href="${mainCss}" rel="stylesheet"/>
    <script type="text/javascript" src="${mainJs}"></script>
</head>
<body>

<section>
    <div class="container">
        <div class="jumbotron">
            <c:choose>
                <c:when test="${pageContext.request.userPrincipal.name != null}">
                    <p class="pull-right"> Welcome, ${pageContext.request.userPrincipal.name} !</p>
                    <br>

                    <div style="font-size: small" class="pull-right" id="feedback"></div>
                    <div style="font-size: small" class="pull-right"> Currently in Your bucket:</div>
                    <br>
                    <a href="<spring:url value="/logout" />"
                       class="btn btn-danger btn-mini pull-right">
                        <span class="glyphicon glyphicon-off"></span> logout</a>
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
            <a href='<c:url value="/bucket" />' class="btn btn-default pull-right"> <span
                    class="glyphicon-shopping-cart glyphicon"></span> bucket</a>

            <h1>IMarket</h1>
        </div>
    </div>
</section>

<section class="container">

    <div class="row">
        <div class="col-md-6">
            <img src="/imageDisplay?id=${product.id}" class="single-img"/>
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

            <c:choose>
                <c:when test="${pageContext.request.userPrincipal.name != null}">
                    <input type="button" class="btn btn-warning btn-large" value="Add"
                           onclick="putToBucketAjaxPost(${product.id})">
                </c:when>
                <c:otherwise>
                    <input type="button" class="btn btn-warning btn-large" value="Add"
                           onclick="window.location.href='/login'"/>
                </c:otherwise>
            </c:choose>
            <form action="/products">
                <td><input type="submit" class="btn btn-info btn-large" href='/products' value="back">
                </td>
            </form>

        </div>
    </div>
</section>
</body>
</html>
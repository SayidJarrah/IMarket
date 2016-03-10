<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>


<head>
    <title>Products</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <spring:url value="/resources/theme1/css/styles.css" var="mainCss"/>
    <spring:url value="/resources/theme1/js/main.js" var="mainJs"/>
    <link href="${mainCss}" rel="stylesheet"/>
    <script type="text/javascript" src="${mainJs}"></script>

</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <c:choose>
                <c:when test="${pageContext.request.userPrincipal.name != null}">
                    <p class="pull-right"> Welcome, ${pageContext.request.userPrincipal.name} !</p>
                    <br>

                    <div style="font-size: small" class="pull-right" id="feedback"></div>
                    <div style="font-size: small" class="pull-right"> Currently in Your bucket:</div>
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
                            <c:choose>
                                <c:when test="${pageContext.request.userPrincipal.name != null}">
                                    <input type="button" class="btn btn-warning btn-large" value="Add"
                                           onclick="putToBucketAjaxPost(${product.id})">
                                    <!--glyphicon-shopping-cart glyphicon-->
                                </c:when>
                                <c:otherwise>
                                    <input type="button" class="btn btn-warning btn-large" value="Add"
                                           onclick="window.location.href='/login'" />
                                </c:otherwise>
                            </c:choose>
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
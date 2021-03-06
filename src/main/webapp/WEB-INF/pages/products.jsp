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
    <div class="container">
        <div class="jumbotron">
            <c:choose>
                <c:when test="${pageContext.request.userPrincipal.name != null}">
                    <p class="pull-right"> Welcome, ${pageContext.request.userPrincipal.name} !</p>
                    <br>
                    <a href='<c:url value="/profile" />' class="btn btn-primary pull-right"> <span
                            class="glyphicon glyphicon-list-alt"></span> Profile</a>

                    <a href="<spring:url value="/logout" />"
                       class="btn btn-danger btn-mini pull-right">
                        <span class="glyphicon glyphicon-off"></span> logout</a>
                    <a href='<c:url value="/bucket" />' class="btn btn-warning pull-right"> <span
                            class="glyphicon-shopping-cart glyphicon"></span> bucket</a>
                    <c:if test="${pageContext.request.userPrincipal.name.equals('admin')}">
                        <a href='<c:url value="/admin/addNewProduct" />'
                           class="btn btn-danger btn-large pull-right"> <span
                                class="glyphicon glyphicon-list-alt"></span> add product</a>
                    </c:if>
                </c:when>
                <c:otherwise>
                    <div>
                        <p class="pull-right"> Welcome, Guest!</p>
                        <br>
                        <a href='<c:url value="/login" />' class="btn btn-primary pull-right"> <span
                                class="glyphicon glyphicon-download-alt"></span> login</a>
                    </div>
                    <div>
                        <a href='<c:url value="/registration" />' class="btn btn-success pull-right"> <span
                                class="glyphicon glyphicon-plus"></span> sign up</a>
                    </div>
                </c:otherwise>
            </c:choose>
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
                        <img height="150px" width="150px"
                             src="/imageDisplay?id=${product.id}"/>
                        </a>
                        <h5><b>Price :</b> <span class="label label-primary">${product.price}</span></h5>

                        <h5><b>Category:</b> <span class="label label-warning">${product.category.name}</span></h5>

                        <h5><b>Available :</b> <span class="label label-info">${product.availableAmount}</span></h5>

                        <a href="<spring:url value="/detail?id=${product.id}" />" class="btn btn-primary">
                            <span class="glyphicon-info-sign glyphicon"> </span> Details</a>
                        <c:choose>
                            <c:when test="${pageContext.request.userPrincipal.name != null}">
                                <input type="button" class="btn btn-warning btn-large" value="Add"
                                       onclick="putToBucketAjaxPost(${product.id})">
                                <!--glyphicon-shopping-cart glyphicon-->
                            </c:when>
                            <c:otherwise>
                                <input type="button" class="btn btn-warning btn-large" value="Add"
                                       onclick="window.location.href='/login'"/>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</section>
<!--
<form action="/products/sortAsc" method="post">
    <input type="submit" value="Sort by price asc">
</form>

<form action="/products/sortDesc" method="post">
    <input type="submit" value="Sort by price desc">
</form>
-->
</body>
</html>
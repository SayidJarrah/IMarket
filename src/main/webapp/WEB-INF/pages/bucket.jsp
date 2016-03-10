<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>${pageContext.request.userPrincipal.name}'s bucket</title>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <spring:url value="/resources/theme1/css/styles.css" var="mainCss"/>
    <spring:url value="/resources/theme1/js/main.js" var="mainJs"/>
    <link href="${mainCss}" rel="stylesheet"/>
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

                    <a href='<c:url value="/profile" />' class="btn btn-primary pull-right"> <span
                            class="glyphicon glyphicon-list-alt"></span> Profile</a>

                    <a href="<spring:url value="/logout" />" class="btn btn-danger btn-mini pull-right">
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

            <h1>IMarket</h1>
        </div>
    </div>
</section>
<section class="container">
    <table class="table-hover table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Category</th>
            <th>Price</th>
        </tr>
        </thead>
        <c:forEach items="${products}" var="product">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.category.name}</td>
                <td>${product.price}</td>
                <form method="get" action="/bucket/${product.id}">
                    <td><input type="submit" class="btn xsmall btn-warning" onclick="location.href='/bucket/${product.id}"
                               value="remove"></td>
                </form>
            </tr>
        </c:forEach>
        <tr>
            <td colspan="2"><strong>Total price</strong></td>
            <td><label id="price">
                <c:set var="totalPrice" value="${0}"/>
                <c:forEach items="${products}" var="product">
                    <c:set var="totalPrice" value="${totalPrice+product.price}"/>
                </c:forEach>
                ${totalPrice}
            </label>

                <form action="/order" method="get">
                    <td><input type="submit" class="btn btn-primary" href='/order' value="Checkout"></td>
                </form>
            </td>
        </tr>
    </table>
    <br>


    <a href="<spring:url value="/products" />" class="btn btn-success">
        <span class="glyphicon-circle-arrow-left glyphicon"></span> continue shopping
    </a>
</section>
</body>
</html>

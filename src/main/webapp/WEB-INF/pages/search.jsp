<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<html>
<head>
    <title>Search</title>
    <spring:url value="/resources/theme1/css/styles.css" var="mainCss"/>
    <link href="${mainCss}" rel="stylesheet"/>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
</head>
<body>

<section>
    <div class="container">
        <div class="jumbotron">
            <h1 class="pull-left">IMarket</h1>

            <p class="pull-right"> Welcome, ${pageContext.request.userPrincipal.name} !</p>

            <div style="font-size: small" class="pull-right" id="feedback"></div>
            <br>
            <a href="<spring:url value="/logout" />"
               class="btn btn-danger btn-mini pull-right">
                <span class="glyphicon glyphicon-off"></span> logout</a>
        </div>
    </div>
</section>

<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Please fill all fields</h3>
                </div>
                <div class="panel-body">

                    <fieldset>
                        <div class="form-group">
                            <form method="post">
                                <label for="textfield">Keyword : </label>
                                <input class="form-control" name="keyword" id="textfield"/>
                                <input class="btn btn-info btn-large" type="submit" value="Search"/>
                            </form>
                        </div>
                    </fieldset>
                </div>
            </div>
        </div>
    </div>
</div>

<section class="container">
    <table class="table-hover table-bordered">
        <thead>
        <tr>
            <th> id</th>
            <th> Product</th>
            <th> Price</th>
            <th> Category</th>
            <th> Amount</th>
            <th> Date</th>
            <th> Image</th>
        </tr>
        </thead>
        <c:forEach items="${products}" var="product">
            <tr>
                <td> ${product.id}</td>
                <td><a href='<spring:url value="/detail?id=${product.id}"/>'> ${product.name} </a></td>
                <td> ${product.price}</td>
                <td> ${product.category.name}</td>
                <td> ${product.availableAmount}</td>
                <td> ${product.appearanceDate}</td>
                <td><img height="90px" width="90px" src="/imageDisplay?id=${product.id}"/></td>
                <input type="hidden" name="id" value="${product.id}">

                <form action="/admin/edit" method="get">
                    <td><input class="btn btn-primary" type="submit" name="edit" value="edit"></td>
                    <input type="hidden" name="id" value="${product.id}">
                </form>
                <form method="get"  action="/admin/search/${product.id}">
                    <td><input type="submit" class="btn btn-danger" onclick="location.href='/admin/search/${product.id}"
                               value="Remove"></td>
                </form>
            </tr>
        </c:forEach>
    </table>
    <a href="<spring:url value="/admin/addNewProduct" />" class="btn btn-success">
        <span class="glyphicon-circle-arrow-left glyphicon"></span> back
    </a>
</body>
</html>

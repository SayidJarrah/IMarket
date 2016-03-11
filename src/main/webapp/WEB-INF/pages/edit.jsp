<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit</title>
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

<h2 style="text-align: center">Changing ${product.id} - ${product.name}</h2>
<br>


<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Edit fields</h3>
                </div>
                <div class="panel-body">

                    <sf:form method="post" modelAttribute="product">
                        <fieldset>
                            <div class="form-group">
                                <label for="name">Name: </label>
                                <span id="name">${product.name}</span>
                                <br>
                                <sf:input class="form-control" path="name"/>
                                <div class="form-group">
                                </div>
                                <div class="form-group">
                                    <label for="description">Description: </label>
                                    <span id="description">${product.description}</span>
                                    <br>
                                    <sf:input class="form-control" path="description"/>
                                </div>
                                <div class="form-group">
                                    <label for="price">Price: </label>
                                    <span id="price">${product.price}</span>
                                    <br>
                                    <sf:input class="form-control" path="price"/>
                                </div>
                                <div class="form-group">
                                    <label for="amount">Amount: </label>
                                    <span id="amount">${product.availableAmount}</span>
                                    <br>
                                    <sf:input class="form-control" path="availableAmount"/>
                                </div>
                                <input class="btn btn-lg btn-danger btn-block" type="submit" value="Edit"/>
                            </div>
                            <a href="<spring:url value="/admin/addNewProduct" />" class="btn btn-success btn-block">
                                <span class="glyphicon-circle-arrow-left glyphicon"></span> back
                            </a>
                        </fieldset>
                    </sf:form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
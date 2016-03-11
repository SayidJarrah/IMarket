<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add new category</title>
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
                            <label for="category_name">Category name : </label>
                            <input class="form-control" name="name" id="category_name"/></td>
                        </div>
                        <div class="form-group">
                            <label for="category_description">Category description : </label>
                            <input class="form-control" name="description" id="category_description"/>
                        </div>
                        <input class="btn btn-info btn-large" type="button" value="submit" onclick="newCategoryDoAjaxPost()">

                        <div id="feedback"></div>
                    </fieldset>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
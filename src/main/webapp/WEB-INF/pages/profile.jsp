<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>${user.login}'s profile</title>
    <spring:url value="/resources/theme1/css/styles.css" var="mainCss"/>
    <link href="${mainCss}" rel="stylesheet"/>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
</head>
<body>

<section>
    <div class="container">
    <div class="jumbotron">
            <c:choose>
                <c:when test="${pageContext.request.userPrincipal.name != null}">
                    <h1 class="pull-left">IMarket</h1>
                    <p class="pull-right"> Welcome, ${pageContext.request.userPrincipal.name} !</p>
                    <div style="font-size: small" class="pull-right" id="feedback"></div>
                    <br>
                    <a href="<spring:url value="/logout" />"
                       class="btn btn-danger btn-mini pull-right">
                        <span class="glyphicon glyphicon-off"></span> logout</a>
                    <a href='<c:url value="/bucket" />' class="btn btn-info pull-right"> <span
                            class="glyphicon-shopping-cart glyphicon"></span> bucket</a>
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
        </div>
    </div>
</section>
<br>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Please sign in</h3>
                </div>
                <div class="panel-body">


                    <sf:form method="post" modelAttribute="user">
                        <fieldset>
                            <div class="form-group">
                                <h4>Login :    <span class="label label-info"><i>${user.login}</i></span></h4>
                            </div>
                            <div class="form-group">
                                <h4>Name :   <span class="label label-info"><i>${user.firstName}</i></span></h4>
                            </div>
                            <div class="form-group">
                                <h4>Surname :<span class="label label-info"><i>${user.secondName}</i></span></h4>
                            </div>
                            <div class="form-group">
                                <h4>Email :    <span class="label label-info"><i>${user.email}</i></span></h4>
                            </div>
                            <div class="form-group">
                                <h4>Address :    <span class="label label-info"><i>${user.phone}</i></span></h4>
                            </div>
                            <div class="form-group">
                                <h4>City :   <span class="label label-info"><i>${user.city}</i></span></h4>
                            </div>

                        </fieldset>
                    </sf:form>
                    <form action="/history">
                        <input type="submit" class="btn btn-lg btn-primary btn-block" href='/history' value="history">
                    </form>
                    <form action="/products">
                        <input type="submit" class="btn btn-lg btn-warning btn-block" href='/products' value="back">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
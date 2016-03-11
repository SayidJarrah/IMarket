<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <spring:url value="/resources/theme1/css/styles.css" var="mainCss"/>
    <link href="${mainCss}" rel="stylesheet"/>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
</head>
<body>
<section>
    <div class="container">
        <div class="jumbotron">
            <h1>IMarket</h1>
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


                    <sf:form method="post" modelAttribute="user">
                        <fieldset>
                            <div class="form-group">
                                <sf:input class="form-control" placeholder="Login" path="login" id="login"/>
                            </div>
                            <div class="form-group">
                                <sf:input class="form-control" placeholder="Password" path="password" id="password"/>
                            </div>
                            <div class="form-group">
                                <sf:input class="form-control" placeholder="Name" path="firstName" id="name"/>
                            </div>
                            <div class="form-group">
                                <sf:input class="form-control" placeholder="Surname" path="secondName" id="surname"/>
                            </div>
                            <div class="form-group">
                                <sf:input class="form-control" placeholder="Email" path="email" id="email"/>
                            </div>
                            <div class="form-group">
                                <sf:input class="form-control" placeholder="City" path="city" id="city"/>
                            </div>
                            <div class="form-group">
                                <sf:input class="form-control" placeholder="Address" path="address" id="address"/>
                            </div>
                            <div class="form-group">
                                <sf:input class="form-control" placeholder="Phone" path="phone" id="phone"/>
                            </div>
                        </fieldset>
                        <input class="btn btn-lg btn-success btn-block" type="submit" value="Submit"/>
                    </sf:form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>

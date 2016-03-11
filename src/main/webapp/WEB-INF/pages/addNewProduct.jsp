<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add new product</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
    <spring:url value="/resources/theme1/css/styles.css" var="mainCss"/>
    <link href="${mainCss}" rel="stylesheet"/>
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <spring:url value="/resources/theme1/js/main.js" var="mainJs"/>
    <link href="${mainCss}" rel="stylesheet"/>
    <script type="text/javascript" src="${mainJs}"></script>
</head>
<body>

<section>
    <div class="container">
        <div class="jumbotron">
            <br>
            <h1>IMarket</h1>
            <a href='<c:url value="/admin/addNewCategory" />' class="btn btn-danger btn-large pull-right"> <span
                    class="glyphicon glyphicon-list-alt"></span> add category</a>
            <a href='<c:url value="/search" />' class="btn btn-primary btn-large pull-right"> <span
                    class="glyphicon glyphicon-list-alt"></span> edit products</a>

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
                            <select class="form-control" placeholder="Category" id="product_category" path="id">
                                <c:forEach items="${categories}" var="categories">
                                    <option value="${categories.id}">
                                        <c:out value="${categories.id}"/> - <c:out value="${categories.name}"/>
                                    </option>

                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group">
                            <input class="form-control" placeholder="Name" name="name" id="product_name"/>
                        </div>
                        <div class="form-group">
                            <input class="form-control" placeholder="Price" name="price" id="product_price"/>
                        </div>
                        <div class="form-group">
                            <input class="form-control" placeholder="Amount" name="availableAmount"
                                   id="product_amount"/>
                        </div>
                        <div class="form-group">
                            <input class="form-control" placeholder="Description" name="description" id="description"/>
                        </div>
                    </fieldset>
                        <span style="background-color:lemonchiffon" class="btn btn-default btn-file">
                            <input class="form-control" type="file" name="file" id="image"/>Upload image
                                </span>
                    <input type="button" class="btn btn-lg btn-success btn-block myMargin" value="add"
                           onclick="newProductDoAjaxPost()">

                    <div class="myMargin" id="feedback"></div>
                </div>
            </div>
        </div>
    </div>
</div>
<form action="/products">
    <td><input type="submit" class="btn btn-info btn-large" href='/products' value="back">
    </td>
</form>
</body>
</html>
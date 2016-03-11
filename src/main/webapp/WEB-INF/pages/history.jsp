<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
  <title>${user.login}'s history</title>
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
          <a href='<c:url value="/profile" />' class="btn btn-primary pull-right"> <span
                  class="glyphicon glyphicon-list-alt"></span> profile</a>
          <a href='<c:url value="/bucket" />' class="btn btn-default pull-right"> <span
                  class="glyphicon-shopping-cart glyphicon"></span> bucket</a>
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
    </div>
  </div>
</section>


<section class="container">
  <table class="table-hover table-bordered">
    <thead>
  <tr>
    <th> Order</th>
    <th> Product name</th>
    <th> Category</th>
    <th> Price</th>
    <th> User</th>
    <th> Purchase date</th>
  </tr>
  </thead>
  <c:forEach items="${orders}" var="orders">
<tr>
  <td> ${orders.id}</td>
  <td> ${orders.product.name} </td>
  <td> ${orders.product.category.name}</td>
  <td> ${orders.product.price}</td>
  <td> ${orders.user.login}</td>
  <td> ${orders.purchaseDate}</td>
  </tr>
  </c:forEach>
</table>


  <a href="<spring:url value="/products" />" class="btn btn-success myMargin">
    <span class="glyphicon-circle-arrow-left glyphicon"></span> continue shopping
  </a>
</body>
</html>
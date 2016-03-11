<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Order</title>
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

<h1 style="text-align: center">Congratulation, ${pageContext.request.userPrincipal.name}</h1>

<section class="container">
  <table class="table-hover table-bordered">
    <caption>You bought</caption>
    <thead>
    <tr>
      <th> id</th>
      <th> Name</th>
      <th> Category</th>
      <th> Price</th>

    </tr>
    </thead>
  <c:forEach items="${products}" var="product">
    <tr>
      <td>${product.id}</td>
      <td>${product.name}</td>
      <td>${product.category.name}</td>
      <td>${product.price}</td>
    </tr>
  </c:forEach>
  </table>

<form action="/cleanBucket">
  <td><input type="submit" class="btn btn-info btn-large" href='/cleanBucket' value="more purchases!"></td>
</form>

</body>
</html>

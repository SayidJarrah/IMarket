<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>${user.login}'s profile</title>
  <spring:url value="/resources/theme1/css/styles.css" var="mainCss" />
  <link href="${mainCss}" rel="stylesheet" />
  <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
</head>
<body>

<section>
  <div class="jumbotron">
    <div class="container">
      <h1>IMarket</h1>
    </div>
  </div>
</section>
<br>

<b>Login: </b>${user.login}
<b>Name: </b>${user.firstName}
<b>Surname:  </b>${user.secondName}
<b>email:  </b>${user.email}
<b>Phone:  </b>${user.phone}
<b>City:  </b>${user.city}
<b>Registration date:  </b>${user.registrationDate}



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
                <b>Login :</b><label>${user.login}</label>
              </div>
              <div class="form-group">
                <b>Name :</b><label>${user.firstName}</label>
              </div>
              <div class="form-group">
                <b>Surname :</b><label>${user.secondName}</label>
              </div>
            </fieldset>
            <input class="btn btn-lg btn-success btn-block" type="submit" value="Submit"/>
          </sf:form>
        </div>
      </div>
    </div>
  </div>
</div>




<form action="/history">
  <input type="submit" href='/history' value="history">
</form>

</body>
</html>
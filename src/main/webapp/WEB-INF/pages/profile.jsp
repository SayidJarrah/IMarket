<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
  <title>User profile</title>

</head>
<body>
<br>
<b>Login: </b>${user.login}
<b>Name: </b>${user.firstName}
<b>Surname:  </b>${user.secondName}
<b>email:  </b>${user.email}
<b>Phone:  </b>${user.phone}
<b>City:  </b>${user.city}
<b>Registration date:  </b>${user.registrationDate}

<form action="/history">
  <input type="submit" href='/history' value="history">
</form>

</body>
</html>
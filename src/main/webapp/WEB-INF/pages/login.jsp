<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Spring Security</title>
</head>

<body>
  <c:url value="/j_spring_security_check" var="loginUrl" />
  <form action="${loginUrl}" method="post">
    <h2>Please sign in</h2>
    <input type="text" name="j_username" placeholder="Email address">
    <input type="password" name="j_password" placeholder="Password">
    <button type="submit">Enter</button>
  </form>

</body>
</html>
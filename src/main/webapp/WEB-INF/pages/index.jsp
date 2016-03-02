<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Spring Security</title>
</head>

<body>

    <sec:authorize access="!isAuthenticated()">
      <p><a  href="<c:url value="/login" />" role="button">Enter</a></p>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
      <p>Your login: <sec:authentication property="principal.username" /></p>
      <p><a href="<c:url value="/logout" />" role="button">Sign out</a></p>
    </sec:authorize>

</div>
</body>
</html>
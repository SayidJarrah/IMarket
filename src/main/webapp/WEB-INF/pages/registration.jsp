<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>

<sf:form method="post" modelAttribute="user">
  <fieldset>
    <table cellspacing="0">

      <tr>
        <th><label for="login">Login : </label></th>
        <td><sf:input path="login" id="login"/></td>
      </tr>

      <tr>
        <th><label for="name">Password : </label></th>
        <td><sf:input path="password" id="password"/></td>
      </tr>


      <tr>
        <th><label for="name">First name : </label></th>
        <td><sf:input path="firstName" id="name"/></td>
      </tr>

      <tr>
        <th><label for="surname">Second name : </label></th>
        <td><sf:input path="secondName" id="surname"/></td>
      </tr>

      <tr>
        <th><label for="email">Email : </label></th>
        <td><sf:input path="email" id="email"/></td>
      </tr>

      <tr>
        <th><label for="city">City : </label></th>
        <td><sf:input path="city" id="city"/></td>
      </tr>
      <tr>
        <th><label for="address">Address : </label></th>
        <td><sf:input path="address" id="address"/></td>
      </tr>

      <tr>
        <th><label for="phone">Phone : </label></th>
        <td><sf:input path="phone" id="phone"/></td>
      </tr>

    </table>
  </fieldset>
  <input type="submit" value="Submit"/>
</sf:form>
</body>
</html>

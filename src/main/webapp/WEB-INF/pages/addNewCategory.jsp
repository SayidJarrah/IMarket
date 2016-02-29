<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>Add new category</title>
</head>
<body>

<sf:form method="post" modelAttribute="category">
  <fieldset>
    <table cellspacing="0">
      <tr>
        <th><label for="category_name">Category name : </label></th>
        <td><sf:input path="name" id="category_name"/></td>
      </tr>

      <tr>
        <th><label for="category_description">Category description : </label></th>
        <td><sf:input path="description" id="category_description"/></td>
      </tr>

    </table>
  </fieldset>
  <input type="submit" value="Add"/>
</sf:form>
</body>
</html>
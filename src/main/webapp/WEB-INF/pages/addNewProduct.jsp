<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add new product</title>
</head>
<body>

<sf:form method="post" modelAttribute="product">
<fieldset>
    <table cellspacing="0">
        <tr>
            <th><label for="product_id">Product id : </label></th>
            <td><sf:input path="id" size="15" id="product_id"/></td>
        </tr>
        <tr>
            <th><label for="product_category">Product category</label></th>
            <td><sf:select  id="product_category" path="category">
                <c:forEach items="${categories}" var="category">
                    <sf:option value="${category}">
                        <c:out value="${category.id}"/> - <c:out value="${category.name}"/>
                    </sf:option>
                </c:forEach>
            </sf:select>
            </td>
        </tr>

        <tr>
            <th><label for="product_name">Product name : </label></th>
            <td><sf:input path="name" size="25" id="product_name"/></td>
        </tr>

        <tr>
            <th><label for="product_price">Product price : </label></th>
            <td><sf:input path="price" size="10" id="product_price"/></td>
        </tr>
    </table>
</fieldset>
<button style="height: 25px;width: 125px" type="submit" value="Add">
    </sf:form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add new product</title>

</head>
<body>

<sf:form method="post" modelAttribute="product" id="newProductForm" enctype="multipart/form-data">
    <fieldset>
        <table cellspacing="0">
            <th><label for="product_category">Product category</label></th>
            <td><sf:select id="product_category" path="id">
                <c:forEach items="${categories}" var="categories">
                    <sf:option value="${categories.id}">
                        <c:out value="${categories.id}"/> - <c:out value="${categories.name}"/>
                    </sf:option>

                </c:forEach>
            </sf:select>

            </td>
            </tr>

            <tr>
                <th><label for="product_name">Product name : </label></th>
                <td><sf:input path="name" id="product_name"/></td>
            </tr>

            <tr>
                <th><label for="product_price">Product price : </label></th>
                <td><sf:input path="price" id="product_price"/></td>
            </tr>

            <tr>
                <th><label for="amount">Product amount : </label></th>
                <td><sf:input path="availableAmount" id="amount"/></td>
            </tr>

            <tr>
                <th><label for="description">Product description : </label></th>
                <td><sf:input path="description" id="description"/></td>
            </tr>

            <tr>
                <th><label for="image">Product image : </label></th>
                <td><input type="file" name="file" id="image"/>
            </tr>
        </table>
    </fieldset>
    <input type="submit" value="Add"/>
</sf:form>



</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add new product</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
    <spring:url value="/resources/theme1/css/styles.css" var="mainCss" />
    <spring:url value="/resources/theme1/js/main.js" var="mainJs" />
    <link href="${mainCss}" rel="stylesheet" />
    <script type="text/javascript" src="${mainJs}"></script>
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
                <th><label for="product_amount">Product amount : </label></th>
                <td><sf:input path="availableAmount" id="product_amount"/></td>
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
</sf:form>
<input type="button" value="submit" onclick="newProductDoAjaxPost()">

<div id="feedback"></div>

</body>
</html>
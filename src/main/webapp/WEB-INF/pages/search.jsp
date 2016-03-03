<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<html>
<head>
    <title>Search</title>
</head>
<body>
<h2>Enter something about product :</h2>

<form method="post">

    <label for="textfield">Keyword : </label>
    <input name="keyword" id="textfield"/>
    <input type="submit" value="Search"/>
</form>

<table style="border : 2px solid black">
    <c:forEach items="${products}" var="product">
        <tr>

                <td> ${product.id}</td>
                <td><a href='<spring:url value="/detail?id=${product.id}"/>'> ${product.name} </a></td>
                <td> ${product.price}</td>
                <td> ${product.category.name}</td>
                <td> ${product.availableAmount}</td>
                <td> ${product.appearanceDate}</td>
                <td><img height="90px" width="90px" src="/public/imageDisplay?id=${product.id}"/></td>
                <input type="hidden" name="id" value="${product.id}">
            <form action="/admin/edit" method="get">
                <td><input type="submit" name="edit" value="edit"></td>
                <input type="hidden" name="id" value="${product.id}">
            </form>
            <form method="get" action="/admin/search/${product.id}">
               <td> <input type="submit"  onclick="location.href='/admin/search/${product.id}" value="Remove" ></td>
            </form>
        </tr>
    </c:forEach>
</table>

</body>
</html>

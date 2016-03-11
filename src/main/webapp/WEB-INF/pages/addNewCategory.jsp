<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add new category</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>
    <spring:url value="/resources/theme1/css/styles.css" var="mainCss" />
    <spring:url value="/resources/theme1/js/main.js" var="mainJs" />
    <link href="${mainCss}" rel="stylesheet" />
    <script type="text/javascript" src="${mainJs}"></script>
</head>
<body>

<label for="category_name">Category name : </label>
<input name="name" id="category_name"/></td>

<label for="category_description">Category description : </label>
<input name="description" id="category_description"/>

<input type="button" value="submit" onclick="newCategoryDoAjaxPost()">


<div id="feedback"></div>
</body>
</html>
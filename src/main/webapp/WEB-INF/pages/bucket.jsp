<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My bucket</title>
</head>
<body>

<table style="border : 2px solid black">
    <c:forEach items="${products}" var="product">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.category.name}</td>
            <td>${product.price}</td>
            <td>
                <form method="get" action="/bucket/${product.id}">
                    <td><input type="submit" onclick="location.href='/bucket/${product.id}" value="Remove"></td>
                </form>
            </td>
        </tr>
    </c:forEach>

</table>
</body>
</html>

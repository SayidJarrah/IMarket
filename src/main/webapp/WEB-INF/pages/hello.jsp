<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
<h1>${message}</h1>


<form:form>
<h3>
     <c:choose>
		 <c:when test="${pageContext.request.userPrincipal.name != null}">
			 Welcome,  ${pageContext.request.userPrincipal.name} !
		 </c:when>
		 <c:otherwise>
			 Welcome,  Guest !
		 </c:otherwise>
	 </c:choose>

	<br>
	<br>
	<a href="/login.html">LOG IN </a>
	<br>
	<a href="/registration.html">SIGN UP </a>
	<br>
	<a href="/public/products.html">VIEW ALL PRODUCTS... </a>
	<br>
	<a href="/admin/addNewProduct.html">ADD NEW PRODUCT </a>
	<br>
	<a href="/admin/addNewCategory.html">ADD NEW CATEGORY </a>
	<br>
	<a href="/search.html">SEARCH PRODUCT</a>
	<br>
	<a href="/bucket.html">CHECK OUT</a>
</form:form>
</h3>
</body>
</html>
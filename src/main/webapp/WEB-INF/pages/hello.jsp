<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page session="true"%>
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
	<a href="/login">LOG IN </a>
	<br>
	<a href="/registration">SIGN UP </a>
	<br>
	<a href="/profile">USER PROFILE</a>
	<br>
	<a href="/public/products">VIEW ALL PRODUCTS... </a>
	<br>
	<a href="/admin/addNewProduct">ADD NEW PRODUCT </a>
	<br>
	<a href="/admin/addNewCategory">ADD NEW CATEGORY </a>
	<br>
	<a href="/search">SEARCH PRODUCT</a>
	<br>
	<a href="/bucket">CHECK OUT</a>
</form:form>
</h3>

	<!-- For login user -->
	<c:url value="/j_spring_security_logout" var="logoutUrl" />
	<form action="${logoutUrl}" method="post" id="logoutForm">
		<input type="hidden" name="${_csrf.parameterName}"
			   value="${_csrf.token}" />
	</form>
	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>

	<c:if test="${pageContext.request.userPrincipal.name != null}">
		<h2>
			User : ${pageContext.request.userPrincipal.name} | <a
				href="javascript:formSubmit()"> Logout</a>
		</h2>
	</c:if>


</body>
</html>
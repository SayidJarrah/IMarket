<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login Page</title>
    <link rel="stylesheet"
          href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
</head>
<body onload='document.loginForm.username.focus();'>

<section>
    <div class="jumbotron">
        <div class="container">
            <h1>IMarket</h1>

            <p>Add products</p>
        </div>
    </div>
</section>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Please sign in</h3>
                </div>
                <div class="panel-body">
                    <c:if test="${not empty error}">
                    <div class="error">${error}</div>
                    </c:if>
                    <c:if test="${not empty msg}">
                    <div class="msg">${msg}</div>
                    </c:if>

                    <form name='loginForm'
                          action="<c:url value='/j_spring_security_check'/>" method='POST'>
                        <fieldset>

                            <div class="form-group">
                                <input class="form-control" placeholder="User Name" type='text' name='username'
                                       value=''></td>
                            </div>
                            <div class="form-group">
                                <td><input class="form-control" type='password' name='password'/></td>
                            </div>
                            <input class="btn btn-lg btn-success btn-block" name="submit" type="submit"
                                   value="submit"/></td>
                        </fieldset>

                        <input type="hidden" name="${_csrf.parameterName}"
                               value="${_csrf.token}"/>

                    </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
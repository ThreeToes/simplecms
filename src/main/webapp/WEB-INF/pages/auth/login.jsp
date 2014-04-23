<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:message var="userString" code="authentication.user" />
<spring:message var="passwordString" code="authentication.password" />
<html>
    <head>
        <title>Login Page</title>
    </head>
    <body onload='document.loginForm.username.focus();'>

        <h1>Spring Security Custom Login Form (XML)</h1>

        <div id="login-box">

            <h3>Login with Username and Password</h3>

            <c:if test="${not empty error}">
                <div>${error}</div>
            </c:if>
            <c:if test="${not empty msg}">
                <div>${msg}</div>
            </c:if>

            <form name='loginForm'
                  action="<c:url value='/j_spring_security_check' />" method='POST'>
                <div>
                    ${userString}: <input type='text' name='username' value='' />
                </div>
                <div>  
                    ${passwordString}: <input type='password' name='password' />
                </div>
                <div>
                    <input name="submit" type="submit"
                           value="submit" />
                </div>
                <!-- CSRF token. See more about cross site forgeries at http://en.wikipedia.org/wiki/Cross-site_request_forgery -->
                <input type="hidden" name="${_csrf.parameterName}"
                       value="${_csrf.token}" />

            </form>
        </div>

    </body>
</html>
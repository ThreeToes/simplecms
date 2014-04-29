<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
    <head>
        <title>Login Page</title>
    </head>
    <body onload='document.loginForm.username.focus();'>

        <h1>Spring Security Custom Login Form (XML)</h1>

        <div id="login-box">

            <h3>Login with Username and Password</h3>

            <div th:if="${error}">${error}</div>
            <div th:if="${msg}">${msg}</div>

            <form name='loginForm'
                  th:action="@{/j_spring_security_check}" method='POST'>
                <div>
                    <label th:text="#{authentication.user}">User</label> <input type='text' name='username' value='' />
                </div>
                <div>  
                    <label th:text="#{authentication.password}">Password</label> <input type='password' name='password' />
                </div>
                <div>
                    <input name="submit" type="submit"
                           value="submit" />
                </div>
                <!-- CSRF token. See more about cross site forgeries at http://en.wikipedia.org/wiki/Cross-site_request_forgery -->
                <input type="hidden" th:attr="name=${_csrf.parameterName},value=${_csrf.token}" />

            </form>
        </div>

    </body>
</html>
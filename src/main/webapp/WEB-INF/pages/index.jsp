<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:message var="pageTitle" code="index.label.pageTitle" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${pageTitle}</title>
    </head>
    <body>
        <%-- Just print the message from the ModelMap object we were passed--%>
        <h1>${message}</h1>
    </body>
</html>

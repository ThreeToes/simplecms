<%-- 
    Document   : contentok
    Created on : Apr 3, 2014, 12:29:17 AM
    Author     : Stephen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:message var="pageTitle" code="contentok.label.pageTitle" />
<spring:message var="description" code="contentok.message.description" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${pageTitle}</title>
    </head>
    <body>
        <h1>${description}</h1>
    </body>
</html>

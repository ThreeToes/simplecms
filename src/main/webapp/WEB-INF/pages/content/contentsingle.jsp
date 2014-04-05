<%-- 
    Document   : contentsingle
    Created on : Apr 5, 2014, 9:25:52 AM
    Author     : Stephen
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:message var="pageTitle" code="singlecontent.label.pageTitle" />

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${pageTitle} ${content.title}</title>
    </head>
    <body>
        <h1>${content.title}</h1>
        <div>
            ${content.body}
        </div>
    </body>
</html>

<%-- 
    Document   : allContent
    Created on : Apr 3, 2014, 11:55:24 AM
    Author     : Stephen
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:message var="pageTitle" code="allContent.label.pageTitle" />

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${pageTitle}</title>
    </head>
    <body>
        <c:forEach var="node" items="${nodes}">
            <div>
                <h2>${node.title}</h2>
                <div>${node.body}</div>
            </div>
        </c:forEach>
    </body>
</html>

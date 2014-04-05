<%-- 
    Document   : newcontent
    Created on : Apr 3, 2014, 12:12:40 AM
    Author     : Stephen
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!-- Pulling data from messages.properties -->
<spring:message var="pageTitle" code="newcontent.label.pageTitle" />
<spring:message var="title" code="newcontent.label.title" />
<spring:message var="body" code="newcontent.label.body" />
<spring:message var="submit" code="newcontent.label.submit" />

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${pageTitle}</title>
    </head>
    <body>
        <!-- Spring form  -->
        <form:form action="new" modelAttribute="content">
            <div>${title}</div>
            <div>
                <div>
                    <!-- Input box for the title -->
                    <form:input path="title"  />
                </div>
                <form:errors path="title">
                    <!-- Errors for the title field -->
                    <div><form:errors path="title" htmlEscape="false" /></div>
                </form:errors>
                </div>
            <div>${body}</div>
            <div>
                <div>
                    <!-- Input box for the body field -->
                    <form:textarea path="body"  />
                </div>
                <!-- Errors found for the body field -->
                <form:errors path="body">
                    <div><form:errors path="body" htmlEscape="false" /></div>
                </form:errors>
            </div> 
            <div class="gridRow yui-gf">
                <div class="yui-u first"></div>
                <div class="yui-u">
                    <input type="submit" value="${submit}" />
                </div>
		</div>
        </form:form>
    </body>
</html>

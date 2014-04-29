<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
    <head>
        <link th:href="@{/resources/bootstrap/css/bootstrap.min.css}" rel="stylesheet" />
        <link th:href="@{/resources/maintheme/main.css}" rel="stylesheet" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title th:text="#{index.label.pageTitle}">Index page</title>
    </head>
    <body>
        <!-- Just print the message from the ModelMap object we were passed -->
        <h1 th:text="${message}">Hello, world!</h1>
        <script th:src="@{/resources/js/jquery-2.1.0.min.js}"></script>
        <script th:src="@{/resources/bootstrap/js/bootstrap.min.js}"></script>
    </body>
</html>

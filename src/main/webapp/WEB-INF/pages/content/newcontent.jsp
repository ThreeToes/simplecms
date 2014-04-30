<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title th:text="#{newcontent.label.pageTitle}">New content node</title>
    </head>
    <body>
        <!-- Spring form  -->
        <form th:action="@{/content/new}" th:object="${content}" method="POST">
            <div th:text="#{newcontent.label.title}">New content page</div>
            <div>
                <div>
                    <!-- Input box for the title -->
                    <input type="text" th:field="*{title}"  />
                </div>
                <!-- Errors for the title field -->
                <div th:if="${#fields.hasErrors('title')}">
                    <p th:errors="*{title}">
                        Title field has errors
                    </p>
                </div>
            </div>
            <div th:text="#{newcontent.label.body}">Content body</div>
            <div>
                <div>
                    <!-- Input box for the body field -->
                    <textarea th:field="*{body}" />
                </div>
                <!-- Errors found for the body field -->
                
                <div th:if="${#fields.hasErrors('body')}">
                    <p th:errors="*{body}">
                        Body field has errors
                    </p>
                </div>
            </div> 
            <div>
                <div>
                    <input type="submit" th:attr="value=#{newcontent.label.submit}" />
                </div>
            </div>
        </form>
    </body>
</html>

<!DOCTYPE html>
<!-- The th namespace is declared like so -->
<html xmlns:th="http://www.thymeleaf.org">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <!-- 
            Using the # notation in this way will use a string defined 
            in our resource bundles. Within the tag is what gets set
            as default text on failure
        -->
        <title th:text="#{newcontent.label.pageTitle}">New content node</title>
    </head>
    <body>
        <!-- 
            The th:action attribute along with the @ annotated path provide 
            an application relative path. This becomes /simplecms/content/new
            when Thymeleaf processes the file.
        
            th:object specifies the object in our model to bind form fields
            to
        -->
        <form th:action="@{/content/new}" th:object="${content}" method="POST">
            <!-- th:text is the usual way to set tag content -->
            <div th:text="#{newcontent.label.title}">New content title</div>
            <div>
                <div>
                    <!-- Input box for the title -->
                    <!--
                        The th:field file binds this to the model
                        field named with the *
                    -->
                    <input type="text" th:field="*{title}"  />
                </div>
                <!-- Errors for the title field -->
                <!-- 
                    th:if should be obvious, we're checking to see if
                    the 'title' field has any errors, and will render this
                    div if there is any errors
                -->
                <div th:if="${#fields.hasErrors('title')}">
                    <!-- 
                        th:errors sets the content of this p tag to the
                        errors of the title field
                    -->
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

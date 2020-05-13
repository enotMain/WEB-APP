<%@page isErrorPage="true" %>
<%@page contentType="text/html; charset=UTF-8" language="java" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <title>Ошибка</title>
    </head>
    <body>
        <h3>Произошло исключение!</h3>
        Exception is: <%= exception.getMessage()%>
    </body>
</html>
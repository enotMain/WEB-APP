<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>
    <p>Hello ${login}</p>
    <p>Your password: ${cookie.get("password").value}</p>
    <form action="login" method="post">
        <input type="submit" value="Exit">
    </form>
</body>
</html>

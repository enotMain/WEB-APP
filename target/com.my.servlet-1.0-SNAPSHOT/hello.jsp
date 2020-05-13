<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>
    <p>Hello ${login}</p>
    <a href="picture">NICE CAR CLICK HERE!!!</a>
    <form method="post" action="hello">
        <input type="submit" value="Exit">
    </form>
    <h3>Загрузка файла: </h3>
    Выбор файла для загрузки: <br />
    <form action="upload" method="post" enctype="multipart/form-data">
        <input type="file" name="file" />
        <br />
        <input type="submit" value="Загрузить файл">
    </form>
</body>
</html>

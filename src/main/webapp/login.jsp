<%--
  Created by IntelliJ IDEA.
  User: kiarash
  Date: 7/11/2022
  Time: 1:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>LOGIN</title>
</head>
<body>
    <form action="/login" method="post">
        Name: <input name="name" type="text"/>
        password: <input name="password" type="password"/>
        <input type="submit" title="continue"/>
    </form>
    <a href="/adduser"> create new user</a>
</body>
</html>

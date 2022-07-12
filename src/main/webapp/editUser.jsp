<%--
  Created by IntelliJ IDEA.
  User: kiarash
  Date: 7/12/2022
  Time: 10:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit User</title>
</head>
<body>
<form action="/edituser" method="post">
    password: <input name="password" type="password"/>
    new name: <input name="name" type="text"/>
    <input type="submit">Continue</input>
</form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: kiarash
  Date: 7/12/2022
  Time: 6:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>HomePage</title>
</head>
<body>
    ${name}
    <form action="/home" method="post">
        password: <input name="password" type="password"/>
        new name: <input name="name" type="text"/>
        <input type="submit" content="continue"/>
    </form>
</body>
</html>

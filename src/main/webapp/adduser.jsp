<%--
  Created by IntelliJ IDEA.
  User: kiarash
  Date: 7/11/2022
  Time: 1:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADDUSER</title>
</head>
<body>
    <form action="/adduser" method="post">
        Name: <input name="name" type="text"/>
        Password <input name="password" type="password"/>
        Confirm Password: <input name="password2" type="password"/>
        Date of Birth: <input name="date" type="date"/>
        <input type="submit">Continue </input>
        <p id="message">${message}</p>
    </form>
</body>
</html>

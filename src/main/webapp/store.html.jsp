
<%--
  Created by IntelliJ IDEA.
  User: kiarash
  Date: 7/11/2022
  Time: 1:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>STore</title>
</head>
<body>
    <h3>Select Item</h3>
    <ul>
        <li>item1</li>
        <li>item2</li>
        <li>item3</li>
    </ul>
    <form action="/store" method="post">
        <input name="item" type="text"/>
        <input type="submit"/>
    </form>
</body>
</html>

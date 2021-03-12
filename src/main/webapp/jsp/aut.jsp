<%--
  Created by IntelliJ IDEA.
  User: Nameless
  Date: 02.03.2021
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form authorization</title>
</head>
<body>
<form action="authorUser" method="POST">
<table style="with: 100%">
    <h2>Авторизация</h2>
    <tr>
        <td>UserName</td>
        <td><input type="text" name="name"/></td>
    </tr>
    <tr>
        <td>Password</td>
        <td><input type="password" name="password"/></td>
    </tr>

</table>
<input type="submit" value="Submit"/>
</form>

</body>
</html>

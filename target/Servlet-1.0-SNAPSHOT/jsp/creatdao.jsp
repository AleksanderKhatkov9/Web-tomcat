<%--
  Created by IntelliJ IDEA.
  User: Nameless
  Date: 03.03.2021
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CREAT DATABASE</title>
</head>
<body>
<h2>Creat database the fest java servlet CURD</h2>
<form action="creatdao" method="POST">
    <table style="with: 100%">
        <h2>Creat book</h2>
        <tr>
            <td>Title</td>
            <td><input type="text" name="title"/></td>
        </tr>
        <tr>
            <td>Author</td>
            <td><input type="text" name="author"/></td>
        </tr>
        <tr>
            <td>Price</td>
            <td><input type="number" name="price"/></td>
        </tr>

    </table>
    <input type="submit" value="Submit"/>
</form>
</body>
</html>

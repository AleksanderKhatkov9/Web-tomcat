<%--
  Created by IntelliJ IDEA.
  User: sasha
  Date: 6.04.21
  Time: 13:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Books Store Application</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>

<body>
<div class="container">
    <div class="jumbotron">
<%--    <form action="insert" method="POST">--%>
<%--    <form action="<%=request.getContextPath() %>/ed">--%>
        <form action=edit" method="POST">
        <table class="table">
            <h3 class="text-info">Edit book</h3>
            <tr>
                <td class="text-primary">Title</td>
                <td><input type="text" id="title" name="title" value="title" size="30"/></td>
            </tr>
            <tr>
                <td class="text-primary">Author</td>
                <td><input type="text" id="author" name="author" value="author" size="30"/>
            </tr>
            <tr>
                <td class="text-primary">Price</td>
                <td><input type="text" id="price" name="price" value="price" size="30"/>
            </tr>

        </table>
        <button type="отправить" class="btn btn-success">Отправить</button>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <button type="отмена" class="btn btn-danger">Отмена</button>
    </form>
</div>
</div>
</body>
</html>

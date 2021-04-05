<%--
  Created by IntelliJ IDEA.
  User: sasha
  Date: 5.04.21
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Books Store Application</title>
</head>
<body>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Books</h2></caption>
        <tr>
            <th>ID</th>
            <th>Title</th>
            <th>Author</th>
            <th>Price</th>
            <th>Actions</th>
        </tr>
        <c:forEach var="book" items="${listBook}">
        <tr>
            <td><c:out value="${book.id}" /></td>
            <td><c:out value="${book.title}" /></td>
            <td><c:out value="${book.author}" /></td>
            <td><c:out value="${book.price}" /></td>
            <td>
                <a href="/edit?id=<c:out value='${book.id}' />">Edit</a>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <a href="/delete?id=<c:out value='${book.id}' />">Delete</a>
            </td>
        </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
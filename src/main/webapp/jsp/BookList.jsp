<%--
  Created by IntelliJ IDEA.
  User: sasha
  Date: 5.04.21
  Time: 11:14
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
        <a href="menu.jsp"><img
                src="https://img2.freepng.ru/20180429/zte/kisspng-computer-icons-avatar-user-laptop-5ae67d2c9fba76.3873242315250547646543.jpg"
                width="50" height="50" alt="Пример"></a>
        &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;

        <a href="creatdao.jsp"/><img
            src="http://s1.iconbird.com/ico/2013/8/429/w128h1281377937728185024computerimac3.png"
            width="50" height="50" alt="Пример"></a>

            <form action="list" method="POST">
                <table class="table">
                    <h2 class="align-content-center">List of Books</h2>
                    <tr>
                        <th>ID</th>
                        <th>Title</th>
                        <th>Author</th>
                        <th>Price</th>
                        <th>Actions</th>
                    </tr>
                    <c:forEach var="book" items="${listBook}">
                        <tr>
                            <td><c:out value="${book.id}"/></td>
                            <td><c:out value="${book.title}"/></td>
                            <td><c:out value="${book.author}"/></td>
                            <td><c:out value="${book.price}"/></td>
                            <td>
                                <a href="edit?id=<c:out value='${book.id}' />">Edit</a>
                                &nbsp;&nbsp;&nbsp;&nbsp;
                                <a href="delete?id=<c:out value='${book.id}' />">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
<%--                    <c:if test="${book.id != null}">--%>
<%--                    <form action="update" method="POST">--%>
<%--                        </c:if>--%>
                </table>
                <button type="submit" class="btn btn-success">submit</button>
            </form>
    </div>
</div>
</body>
</html>
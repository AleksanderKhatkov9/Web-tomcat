<%--
  Created by IntelliJ IDEA.
  User: Nameless
  Date: 03.03.2021
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>CREAT DATABASE</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<div class="container">
    <div class="jumbotron">
<%--        <form action="creatDao" method="POST">--%>
            <form action="<%=request.getContextPath() %>/insert">
            <table class="table">
                <h3>Creat database the fest java servlet CURD</h3>
                <h3 style="color: Blue">Creat book</h3>
                <br>

                <img src="jpg\book.jpg" class="rounded" alt="Cinque Terre" width="200" height="180">
<%--                C:\Users\ipoli\IdeaProjects\Web-tomcat\src\main\resources\jpg\book.jpg--%>
<%--                jpg\book.jpg--%>
<%--                --%>
                <br><br><br>
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
                </tr>

            </table>
            <button type="отправить" class="btn btn-success">Отправить</button>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <button type="отмена" class="btn btn-danger">Отмена</button>
        </form>

    </div>
    <div class="jumbotron text-center" style="margin-bottom:0">
        <footer>
            <p style="color: #443fff">Author: Alexander Khatkov</p>
            <p><a href="mailto:bendar01@tut.by">web@example.com</a></p>
            <p style="font-size:30px">
                &#128512; &#128516; &#128525; &#128400;
            </p>

        </footer>
    </div>
</div>
</body>
</html>

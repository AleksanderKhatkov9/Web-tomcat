<%--
  Created by IntelliJ IDEA.
  User: Nameless
  Date: 02.03.2021
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Form authorization</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<div class="container">
    <div class="jumbotron">
        <a href="menu.jsp"><img
                src="https://img2.freepng.ru/20180429/zte/kisspng-computer-icons-avatar-user-laptop-5ae67d2c9fba76.3873242315250547646543.jpg"
                width="50" height="50" alt="Пример"></a>
        <br><br><br>
        <form action="authorUser" method="POST">
            <table class="table">
                <h3 style="color: Blue">Авторизация</h3>
                <br>

                <img src="https://proslang.ru/wp-content/uploads/2019/03/avatarka_1-300x300.jpg" class="rounded"
                     alt="Cinque Terre" width="200" height="180">

                <br><br><br>

                <tr>
                    <td class="text-primary">Имя</td>
                    <td><input type="name" id="name" name="name" value="name" size="30"/></td>
                </tr>
                <tr>
                    <td class="text-primary">Пароль</td>
                    <td><input type="password" id="password" name="password" value="password" size="30"/></td>
                </tr>
            </table>
            <button type="submit" class="btn btn-success">submit</button>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <button type="cancel" class="btn btn-danger">cancel</button>
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

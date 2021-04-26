<%--
  Created by IntelliJ IDEA.
  User: benda
  Date: 26.04.2021
  Time: 23:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</head>
<body>
<div class="container">
<div class="jumbotron">
    <h2 class="text-info">WEB Application Book Shop CRUD</h2>

    <p>
        <img src="  https://media.timeout.com/images/103637416/image.jpg" class="rounded"
             alt="Cinque Terre" width="300" height="250">
    </p>



    <table class="table">
        <tr>
            <td><a href="creatdao.jsp">Регестрация</a></td>
        </tr>
        <tr>
            <td><a href="BookList.jsp">BookList</a></td>
        </tr>
        <tr>
            <td><a href="ListAllBook.jsp">All book</a></td>
        </tr>
        <tr>
            <td><a href="BookForm.jsp">Edd book</a></td>
        </tr>

    </table>
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

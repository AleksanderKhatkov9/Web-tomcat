<%--
  Created by IntelliJ IDEA.
  User: Nameless
  Date: 02.03.2021
  Time: 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration Form</title>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<%--    <link rel="stylesheet" href="./jsp/style/css/bootstrap.min.css">--%>
<%--    <script src="jsp/style/js/bootstrap.min.js"></script>--%>



</head>
<body>
<div class="container">
    <div class="jumbotron">
        <form action="creatUser" method="POST">
            <table class="table">
                <h3 class="text-info">Регистрация</h3>
                <img src="resources/jpg/reg.jpg"class="rounded" alt="Cinque Terre" width="200" height="140">


                <tr>
                    <td class="text-primary">UserName</td>
                    <td><input type="text" name="name"/></td>
                </tr>
                <tr>
                    <td class="text-primary">Password</td>
                    <td><input type="password" name="password"/></td>
                </tr>
                <tr>
                    <td class="text-primary">Email</td>
                    <td><input type="email" name="email"/>
                </tr>
            </table>
            <button type="submit"  class="btn btn-success">Submit</button>
        </form>

        <div class="jumbotron text-center" style="margin-bottom:0">
            <footer>
                <p>Author: Alexander Khatkov</p>
                <p><a href="mailto:bendar01@tut.by">web@example.com</a></p>
                <p style="font-size:30px">
                    &#128512; &#128516; &#128525; #128400;
                </p>
            </footer>
        </div>
    </div>

</div>
</body>
</html>
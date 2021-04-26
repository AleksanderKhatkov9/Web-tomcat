<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Creat Web application</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <%--    <link rel="stylesheet" href="<c:url value="/jsp/style/css/bootstrap.min.css"/>">--%>
    <%--    <link href="/jsp/style/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>--%>
    <%--    <link rel="stylesheet" href="<%=request.getContextPath()%>/jsp/style/css/bootstrap.min.css" type="text/css">--%>

</head>
<body>
<%--<img src="/resources/jpg/reg.jpg" width="200" height="200">--%>
<%--<img src="${pageContext.request.contextPath}../../resources/jpg/reg.jpg"/>--%>

<div class="container">
    <div class="jumbotron">
        <h2 class="text-info">WEB Application CRUD</h2>
        <p>
            <img src=" https://onlibank.ru/uploads/posts/2019-11/medium/1573374380_1.jpg" class="rounded"
                 alt="Cinque Terre" width="300" height="250">
        </p>

        <table class="table">
            <tr>
                <td><a href="check.jsp">Регестрация</a></td>
            </tr>
            <tr>
                <td><a href="aut.jsp">Авторизация</a></td>
            </tr>
            <tr>
                <td><a href="menu.jsp">Menu books</a></td>
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

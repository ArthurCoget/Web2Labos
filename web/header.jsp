<%--
  Created by IntelliJ IDEA.
  User: Arthur
  Date: 17/11/2020
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<nav>
    <ul>
        <li><a class="${param.home}" href="index.jsp">home</a></li>
        <li><a class="${param.overview}" href="StudentInfo?command=overview">tabel</a></li>
        <li><a class="${param.search}" href="zoekForm.jsp">zoeken</a></li>
        <li><a class="${param.form}" href="studentForm.jsp">toevoegen</a></li>
    </ul>
</nav>
</body>
</html>

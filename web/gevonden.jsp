<%--
  Created by IntelliJ IDEA.
  User: Arthur
  Date: 29/09/2020
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String gevonden = request.getAttribute("Naam") + " " + request.getAttribute("Voornaam") + " (" + request.getAttribute("Leeftijd") + " jaar): " + request.getAttribute("Studierichting") ; %>
<!DOCTYPE html>
<html>
<head>
    <title>Gevonden</title>
</head>
<body>
<nav>
    <ul>
        <li><a href="index.jsp">home</a></li>
        <li><a href="StudentInfo?command=overview">tabel</a></li>
        <li><a href="zoekForm.jsp">zoeken</a></li>
        <li><a href="studentForm.jsp">toevoegen</a></li>
    </ul>
</nav>
<p id="boodschap">Je vroeg naar volgende gegevens: <%= gevonden %></p>
</body>
</html>

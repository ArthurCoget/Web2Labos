<%--
  Created by IntelliJ IDEA.
  User: Arthur
  Date: 29/09/2020
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Zoeken | Studenten Overzicht</title>
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
<p>Geef hier de voornaam en de naam van de gezochte student:</p>
<form action="StudentInfo" method="get">
    <p><label for="naam">Naam: <input type="text" id="naam" name="naam" placeholder="Naam..."></label></p>
    <p><label for="voornaam">Voornaam:<input type="text" id="voornaam" name="voornaam" placeholder="Voornaam..."></label></p>
    <p><input type="submit" name="command"  id="zoek" value="Zoeken"></p>

</form>

</body>
</html>

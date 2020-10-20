<%--
  Created by IntelliJ IDEA.
  User: Arthur
  Date: 12/10/2020
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Voeg een student toe</title>

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
<h1>Voeg een student toe</h1>
<form action="StudentInfo?command=voegtoe" method="post" novalidate>
    <% if (request.getAttribute("nietok") != null ){%>
        <p id="message"><%= request.getAttribute("nietok")%></p>
    <%}%>

    <label for="naam">Naam:<input type="text" name="naam" id="naam" placeholder="Naam..."></label>
    <label for="voornaam">Voornaam:<input type="text" name="vnaam" id="voornaam" placeholder="Voornaam..."></label>
    <label for="leeftijd">Leeftijd:<input type="number" name="leeftijd" id="leeftijd" placeholder="Leeftijd..."></label>
    <label for="studierichting">Studierichting:<input type="text" name="studierichting" id="studierichting" placeholder="Studierichting..."></label>
    <input type="submit" id="bewaar">
</form>

</body>
</html>

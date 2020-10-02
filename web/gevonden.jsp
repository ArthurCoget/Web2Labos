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
    <title>Gevonden | Studenten Overzicht</title>
</head>
<body>
<p>Je vroeg naar volgende gegevens: <%= gevonden %></p>
</body>
</html>

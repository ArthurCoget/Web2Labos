<%--
  Created by IntelliJ IDEA.
  User: Arthur
  Date: 29/09/2020
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <title>Zoeken | Studenten Overzicht</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="title" value="search"/>
</jsp:include>
<p>Geef hier de voornaam en de naam van de gezochte student:</p>
<form action="StudentInfo" method="get">
    <p><label for="naam">Naam: <input type="text" id="naam" name="naam" placeholder="Naam..."></label></p>
    <p><label for="voornaam">Voornaam:<input type="text" id="voornaam" name="voornaam" placeholder="Voornaam..."></label></p>
    <p><input type="submit" name="command"  id="zoek" value="Zoeken"></p>

</form>

</body>
</html>

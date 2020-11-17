<%--
  Created by IntelliJ IDEA.
  User: Arthur
  Date: 29/09/2020
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <title>Gevonden</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<jsp:include page="header.jsp"/>
<p id="boodschap">Je vroeg naar volgende gegevens: ${Naam} ${Voornaam} (${Leeftijd} jaar): ${Studierichting}.</p>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Arthur
  Date: 12/10/2020
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <title>Voeg een student toe</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

<jsp:include page="header.jsp">
    <jsp:param name="title" value="form"/>
</jsp:include>

<h1>Voeg een student toe</h1>
<form action="StudentInfo?command=voegtoe" method="post" novalidate>
    <c:if test="${not empty nietok}">
        <p id="message">${nietok}</p>
    </c:if>

    <label for="naam">Naam:<input type="text" name="naam" id="naam" placeholder="Naam..."></label>
    <label for="voornaam">Voornaam:<input type="text" name="vnaam" id="voornaam" placeholder="Voornaam..."></label>
    <label for="leeftijd">Leeftijd:<input type="number" name="leeftijd" id="leeftijd" placeholder="Leeftijd..."></label>
    <label for="studierichting">Studierichting:<input type="text" name="studierichting" id="studierichting" placeholder="Studierichting..."></label>
    <input type="submit" id="bewaar">
</form>

</body>
</html>

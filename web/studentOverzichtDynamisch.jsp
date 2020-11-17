<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Overzicht Studenten</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<jsp:include page="header.jsp">
    <jsp:param name="overview" value="currentPage"/>
    <jsp:param name="home" value=""/>
    <jsp:param name="search" value=""/>
    <jsp:param name="form" value=""/>
</jsp:include>
<h2>Overzicht studenten</h2>
<table>

    <thead>
    <tr>
        <th>Naam</th>
        <th>Voornaam</th>
        <th>Leeftijd</th>
        <th>Studierichting</th>
        <th>verwijder</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="student" items="${database}">
    <tr >
        <td > ${student.naam} </td >
        <td > ${student.voornaam} </td >
        <td > ${student.leeftijd} </td >
        <td > ${student.studierichting} </td >
        <td><a href="StudentInfo?command=verwijderBevestigd&naam=${student.naam}&voornaam=${student.voornaam}">verwijder</a></td>
    </tr >
    </c:forEach>
    </tbody >

</table>

</body>
</html>

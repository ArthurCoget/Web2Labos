<%@ page import="domain.model.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="domain.db.StudentDB" %>
<% StudentDB studentDB = new StudentDB(); %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>domain.model.Student Info: Overzicht</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<nav>
    <ul>
        <li><a href="index.html">home</a></li>
        <li><a href="studentInfoOverzicht.jsp">tabel</a></li>
        <li><a href="zoek.jsp">zoeken</a></li>
    </ul>
</nav>
<table>
    <thead>
    <tr>
        <th>Naam</th>
        <th>Voornaam</th>
        <th>Leeftijd</th>
        <th>Studierichting</th>
    </tr>
    </thead>
    <tbody>
    <tr >
    <% for (Student a: studentDB.getStudentslijst()) {%>
        <td > <%= a.getNaam() %> </td >
        <td > <%= a.getVoornaam()%> </td >
        <td > <%= a.getLeeftijd() %> </td >
        <td ><%= a.getStudierichting() %> </td >
    </tr >
    <% } %>
    </tbody >

</table>

</body>
</html>

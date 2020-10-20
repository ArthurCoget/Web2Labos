<%@ page import="domain.model.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="domain.db.StudentDB" %>
<% ArrayList<Student> lijst = (ArrayList<Student>)request.getAttribute("database"); %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Overzicht Studenten</title>
    <link rel="stylesheet" type="text/css" href="style.css">
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
    <%for (Student a: lijst) {%>
    <tr >

        <td > <%= a.getNaam() %> </td >
        <td > <%= a.getVoornaam()%> </td >
        <td > <%= a.getLeeftijd() %> </td >
        <td ><%= a.getStudierichting() %> </td >
        <td><a href="StudentInfo?command=verwijderBevestigd&naam=<%=a.getNaam()%>&voornaam=<%=a.getVoornaam()%>">verwijder</a></td>
    </tr >
    <% }%>
    </tbody >

</table>

</body>
</html>

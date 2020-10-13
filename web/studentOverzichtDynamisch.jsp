<%@ page import="domain.model.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="domain.db.StudentDB" %>
<% ArrayList<Student> lijst = (ArrayList<Student>)request.getAttribute("database"); %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Overzicht Studenten</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<nav>
    <ul>
        <li><a href="index.html">home</a></li>
        <li><a href="studentInfoOverzicht.jsp">tabel</a></li>
        <li><a href="zoekForm.jsp">zoeken</a></li>
        <li><a href="studentForm.jsp">voegtoe</a></li>
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
    </tr>
    </thead>
    <tbody>
    <tr >
        <%for (Student a: lijst) {%>
        <td > <%= a.getNaam() %> </td >
        <td > <%= a.getVoornaam()%> </td >
        <td > <%= a.getLeeftijd() %> </td >
        <td ><%= a.getStudierichting() %> </td >
    </tr >
    <% }%>
    </tbody >

</table>

</body>
</html>

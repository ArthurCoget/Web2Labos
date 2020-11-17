<%--
  Created by IntelliJ IDEA.
  User: Arthur
  Date: 20/10/2020
  Time: 11:35
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html>
<head>
    <title>Verijwder | StudentInfo</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<h1>Hier kan je een student verwijderen</h1>
<p>Bent u zeker dat u: ${param.voornaam} ${param.naam} wilt verwijderen</p>
<form action="StudentInfo?command=verwijder" method="post">
    <input type="hidden" name="naam" value="${param.naam}">
    <input type="hidden" name="voornaam" value="${param.voornaam}">
    <input type="submit" value="verwijder" name="verwijder">
    <input type="submit" value="annuleren" name="annuleren">
</form>
</body>
</html>

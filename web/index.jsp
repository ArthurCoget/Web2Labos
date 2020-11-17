<%--
  Created by IntelliJ IDEA.
  User: Arthur
  Date: 19/10/2020
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Home | Studenten Overzicht</title>
  <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<jsp:include page="header.jsp">
  <jsp:param name="home" value="currentPage"/>
  <jsp:param name="overview" value=""/>
  <jsp:param name="search" value=""/>
  <jsp:param name="form" value=""/>
</jsp:include>
<p>Op deze site ga je studenten kunnen opzoeken</p>
</body>
</html>
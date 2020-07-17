<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 01.06.2020
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<jsp:useBean id="Login" class="main.lsea.LSEA" scope="session">
    <jsp:setProperty name="Login" property="*"/>
</jsp:useBean>
    <h1>Welcome to KMZ app ${profile}</h1>
    <p>Hi <jsp:getProperty name="pass" property="Login"/></p>
<a href="index.jsp">index</a>
    <h2>Menu</h2>
    <form action="CarOffers" method="post">

    <a href="CarOffers">Show all car offers</a><br>
    </form>
    <a href="bikeOffers.jsp">Show all bike offers</a><br>

</body>
</html>

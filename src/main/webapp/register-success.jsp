<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<jsp:include page="header_footer/header.html"/>
    <h1 align="center">User Management</h1>
    <h2 align="center">
        <form action="<%=request.getContextPath()%>/MainDashboard">
            <input type="submit" value="Add new User"/>
        </form>
        <form action="<%=request.getContextPath()%>/MainDashboard">
            <input type="submit" value="List All Users"/>
        </form>
    </h2>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Users</h2></caption>
        <tr>
            <th>ID</th>
            <th>Nick</th>
            <th>Password</th>
            <th>Name</th>
            <th>Surname</th>
            <th>Age</th>
            <th>Money</th>
            <th>Action</th>
        </tr>
        <c:forEach var="prof" items="${listProf}">
            <tr>
                <td><c:out value="${prof.id}" /></td>
                <td><c:out value="${prof.nick}" /></td>
                <td><c:out value="${prof.password}" /></td>
                <td><c:out value="${prof.name}" /></td>
                <td><c:out value="${prof.surname}" /></td>
                <td><c:out value="${prof.age}" /></td>
                <td><c:out value="${prof.money}" /></td>
                <td>
                    <a href="edit?id=<c:out value='${prof.id}' />">Edit</a>
                    &nbsp;&nbsp;&nbsp;&nbsp;
                    <a href="delete?id=<c:out value='${prof.id}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<jsp:include page="header_footer/footer.jsp"/>
</body>
</html>
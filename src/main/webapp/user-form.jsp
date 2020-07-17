<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 03.06.2020
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
    <h1 align="center">User Management</h1>
    <h2 align="center">
        <a href="new">Add New User</a>
        &nbsp;&nbsp;&nbsp;
        <a href="list">List All Users</a>

    </h2>
<div align="center">
    <c:if test="${prof != null}">
    <form action="update" method="post">
        </c:if>
        <c:if test="${prof == null}">
        <form action="insert" method="post">
            </c:if>
            <table border="1" cellpadding="5">
                <caption>
                    <h2>
                        <c:if test="${prof != null}">
                            Edit User
                        </c:if>
                        <c:if test="${prof == null}">
                            Add New User
                        </c:if>
                    </h2>
                </caption>
                <c:if test="${prof != null}">
                    <input type="hidden" name="id" value="<c:out value='${prof.id}' />" />
                </c:if>
                <tr>
                    <th>User Nick: </th>
                    <td>
                        <input type="text" name="nick" size="45"
                               value="<c:out value='${prof.nick}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>User Password: </th>
                    <td>
                        <input type="text" name="password" size="45"
                               value="<c:out value='${prof.password}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>User Name: </th>
                    <td>
                        <input type="text" name="name" size="45"
                               value="<c:out value='${prof.name}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>User Surname: </th>
                    <td>
                        <input type="text" name="surname" size="45"
                               value="<c:out value='${prof.surname}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>User Age: </th>
                    <td>
                        <input type="number" name="age" size="45"
                               value="<c:out value='${prof.age}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <th>User Money: </th>
                    <td>
                        <input type="number" name="money" size="15"
                               value="<c:out value='${prof.money}' />"
                        />
                    </td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Save" />
                    </td>
                </tr>
            </table>
        </form>
</div>
</body>
</html>

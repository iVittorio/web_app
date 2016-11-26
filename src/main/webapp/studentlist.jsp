<%@ page import="ru.innopolis.uni.bean.User" %>
<%@ page import="ru.innopolis.uni.dao.UserDAO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    List<User> list = UserDAO.getUsers();
    request.setAttribute("list", list);
%>
<html>
<head>
    <title>Student List</title>
</head>
<body>
<center>
    <table border="1" width="70%">
        <thead>Students list</thead>
        <tr>
            <td colspan="6" align="center">
                <a href="main.jsp">Back</a>
            </td>
        </tr>
        <c:forEach items="${list}" var="u">
            <tr>
                <td>${u.id}</td>
                <td>${u.login}</td>
                <td>${u.fullName}</td>
                <td>${u.email}</td>
                <td>${u.sex}</td>
                <td>${u.role}</td>
            </tr>
        </c:forEach>
    </table>
</center>
</body>
</html>

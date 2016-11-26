<%@page import="ru.innopolis.uni.bean.Lection,ru.innopolis.uni.dao.LectionDAO,java.util.List" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
    List<Lection> list = LectionDAO.getLections();
    request.setAttribute("list", list);
%>
<html>
<head>
    <title>Lection List</title>
</head>
<body>
<center>
    <table border="1" width="40%">
        <thead>Lection list</thead>
        <tr>
            <td colspan="4" align="center">
                <a href="addlection.jsp">Add New Lection</a>
            </td>
        </tr>
        <c:forEach items="${list}" var="u">
            <tr>
                <td>${u.getName()}</td>
                <td><a href="showlection.jsp?id=${u.getId()}">Show</a></td>
                <td><a href="editlection.jsp?id=${u.getId()}">Edit</a></td>
                <td><a href="DeleteLection?id=${u.getId()}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>


</center>
<br/>
</body>
</html>

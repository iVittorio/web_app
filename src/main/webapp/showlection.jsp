<%@ page import="ru.innopolis.uni.bean.Lection" %>
<%@ page import="ru.innopolis.uni.dao.LectionDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int id = Integer.parseInt(request.getParameter("id"));
    Lection lection = LectionDAO.getLectionById(id);
%>

<html>
<head>
    <title>Lection</title>
</head>
<body>
<center>
    <table border="1" width="50%">
        <tr>
            <th>
                Lection name: <%=lection.getName()%>
            </th>
        </tr>
        <tr>
            <th>
                <%=lection.getText()%>
            </th>
        </tr>
    </table>
</center>
<a href="lectionlist.jsp">Back to lection list</a>
</body>
</html>

<%@ page import="ru.innopolis.uni.bean.Lection" %>
<%@ page import="ru.innopolis.uni.dao.LectionDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    int id = Integer.parseInt(request.getParameter("id"));
    Lection lection = LectionDAO.getLectionById(id);
%>
<html>
<head>
    <title>Edit Lection</title>
</head>
<body>
<form action="EditLection" method="post">
    <center>
        <p>Lection name:</p>
        <input type="text" name="name" value="<%=lection.getName()%>"/>
        <input type="hidden" name="id" value="<%=id%>">
        <p><b>Lection text:</b></p>
        <p><textarea name="text">
            <%=lection.getText()%>
        </textarea></p>
        <p><input type="submit" value="Edit Lection"></p>
    </center>
</form>
</body>
</html>

<%@ page import="ru.innopolis.uni.UserBean" %><%--
  Created by IntelliJ IDEA.
  User: i.viktor
  Date: 20/11/2016
  Time: 16:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title> User Logged Successfully </title>
</head>

<body>

<center>
    <% UserBean currentUser = (UserBean)session.getAttribute("session");%>

    Welcome <%= currentUser.getFirstName() + " " + currentUser.getLastName() %>
</center>

</body>

</html>

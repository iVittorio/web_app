<%@ page import="ru.innopolis.uni.UserBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title> User Logged Successfully </title>
</head>

<body>

<center>
    <% UserBean currentUser = (UserBean) session.getAttribute("session");%>

    Welcome <%= currentUser.getFirstName() + " " + currentUser.getLastName()%>
</center>

</body>

</html>

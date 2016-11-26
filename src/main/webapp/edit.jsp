<%@ page import="ru.innopolis.uni.bean.User" %>
<%@ page import="ru.innopolis.uni.dao.UserDAO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    int userID = (int) session.getAttribute("UserID");
    User userById = UserDAO.getUserById(userID);
    String login = null;
    String fullName = null;
    String email = null;
    String sex = null;
    String role = null;
    if (userById != null) {
        login = userById.getLogin();
        fullName = userById.getFullName();
        email = userById.getEmail();
        sex = userById.getSex().toString();
        role = userById.getRole().toString();
    }
%>
<html>
<head>
    <%--<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css"/>
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.2.3.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>--%>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edit User Data</title>

    <%-- <script type="text/javascript">
         $(document).ready(function () {
             $("#edit_table").dataTable();
         });
     </script>--%>
</head>
<body>
<form action="EditServlet" method="post">
    <table id="edit_table" class="display">
        <tbody>
        <tr>
            <td>Current login: <%=login%>
            </td>
            <td><input type="text" name="login" value="<%=login%>"/></td>
        </tr>
        <tr>
            <td>Current e-mail: <%=email%>
            </td>
            <td><input type="email" name="email" value="<%=email%>"/></td>
        </tr>
        <tr>
            <td>Current Full Name: <%=fullName%>
            </td>
            <td><input type="text" name="fullName" value="<%=fullName%>"/></td>
        </tr>
        <tr>
            <td>Current sex: <%=sex%>
            </td>
            <td><input type="text" name="sex" value="<%=sex%>"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Edit"/></td>
            <td>Press to edit the data</td>
        </tr>
        </tbody>
    </table>
</form>
</body>
</html>

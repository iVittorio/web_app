<%@ page import="ru.innopolis.uni.UserBean" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    UserBean userBean = (UserBean) session.getAttribute("bean");
    String login = null;
    String email = null;
    String name = null;
    String family = null;
    if (userBean != null) {
        login = userBean.getLogin();
        email = userBean.getEmail();
        name = userBean.getName();
        family = userBean.getLastName();
    } else response.sendRedirect("index.jsp");
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edit User Data</title>
</head>
<body>
<form action="EditServlet" method="post">
    <center>
        <table border="1" width="30%" cellpadding="3">
            <thead>
            <tr>
                <th colspan="2">Edit Data</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Current login: <%=login%>
                </td>
                <td><input type="text" name="login" value="<%=login%>"/></td>
            </tr>
            <tr>
                <td>Current e-mail: <%=email%>
                </td>
                <td><input type="email" name="email" value="<%=email%>"/>
                </td>
            </tr>
            <tr>
                <td>Current name: <%=name%>
                </td>
                <td><input type="text" name="name" value="<%=name%>"/>
                </td>
            </tr>
            <tr>
                <td>Current surname: <%=family%>
                </td>
                <td><input type="text" name="family" value="<%=family%>"/>
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="Save"/></td>
                <td>Press to edit the data</td>
            </tr>
            </tbody>
        </table>
    </center>
</form>
</body>
</html>

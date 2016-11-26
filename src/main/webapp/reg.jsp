<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registration</title>
</head>
<body>
<form action="registration" method="post">
    <center>
        <table border="1" width="30%">
            <thead>
            <tr>
                <th colspan="2">Enter Information Here</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>Login</td>
                <td><input type="text" name="login" value=""/></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><input type="password" name="password" value=""/></td>
            </tr>
            <tr>
                <td>Full name</td>
                <td><input type="text" name="fullName" value=""/></td>
            </tr>
            <tr>
                <td>E-mail</td>
                <td><input type="email" name="email" value=""/></td>
            </tr>
            <tr>
                <td>Sex</td>
                <td><select name="sex">
                    <option value="MALE">MALE</option>
                    <option value="FEMALE">FEMALE</option>
                </select></td>
            </tr>
            <tr>
                <td><input type="submit" value="Submit"/></td>
                <td><input type="reset" value="Reset"/></td>
            </tr>
            <tr>
                <td><a href="index.jsp">Login Here</a></td>
            </tr>
            </tbody>
        </table>
    </center>
</form>
</body>
</html>

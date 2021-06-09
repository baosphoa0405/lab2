<%-- 
    Document   : login
    Created on : Jun 1, 2021, 9:29:00 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>Login </div>
        <form method="POST" action="login">
            userID <input type="text" name="userID" value="${requestScope.userID}" /><br/>
            <p style="color: red">${requestScope.errors.errorID}</p>
            password <input type="password" name="password" value="${requestScope.password}" /><br/>
            <p style="color: red">${requestScope.errors.errorPassword}</p>
            <input type="submit" value="Login" name="Login" />
        </form>
        <p style="color: red">${requestScope.errors.errorLogin}</p>
        <p style="color: red">${requestScope.mess}</p>
    </body>
</html>

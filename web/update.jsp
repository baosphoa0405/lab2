<%-- 
    Document   : update
    Created on : Jun 4, 2021, 8:59:39 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Page</title>
    </head>
    <body>
        <h1>Update Page</h1>
        <h1 style="color: green">${requestScope.updateSuccess}</h1>
        <form method="POST" action="update" enctype="multipart/form-data">
            UserName <input type="text" name="userName" value="${not empty requestScope.user ? requestScope.user.username : requestScope.userUpdate.username}" /><br/>
            <p style="color: red">${requestScope.errorUser.errorName}</p>
            <p style="color: red">${requestScope.errorUser.errorNameFormat}</p>
            <p style="color: red">${requestScope.errorUser.errorNameLength}</p>
            PassWord <input type="password" name="password" value="${requestScope.userUpdate.password}" /><br/>
            <p style="color: red">${requestScope.errorUser.errorPassword}</p>
            <p style="color: red">${requestScope.errorUser.errorPasswordLength}</p>
            Email <input type="text" name="email" value="${not empty requestScope.user ? requestScope.user.email : requestScope.userUpdate.email}" /><br/>
            <p style="color: red">${requestScope.errorUser.errorEmail}</p>
            <p style="color: red">${requestScope.errorUser.errorEmailFormat}</p>
            <p style="color: red">${requestScope.errorUser.errorEmailLength}</p>
            phone <input type="text" name="phone" value="${not empty requestScope.user ? requestScope.user.phone : requestScope.userUpdate.phone}" /><br/>
            <p style="color: red">${requestScope.errorUser.errorPhone}</p>
            <p style="color: red">${requestScope.errorUser.errorPhoneFormat}</p>
            photo <input type="file" name="photo" /><br/>
            <p style="color: red">${requestScope.errorUser.errorPhoto}</p>
            <p style="color: red">${requestScope.errorFormat}</p>
            <label for="Role">Roles</label>
            <select id="Role" name="role">
                <c:forEach items="${requestScope.listRole}" var="item">
                    <option value="${item.roleName}" ${requestScope.userUpdate.roleDTO.roleName eq item.roleName ? "selected" : ""}>${item.roleName}</option>
                </c:forEach>
            </select><br/>
            <input type="hidden" name="userID" value="${not empty requestScope.user ? requestScope.user.userID : requestScope.userUpdate.userID }" />
            <input type="submit" value="Update"/>
        </form>
        <form action="search" method="POST">
            <input type="submit" value="View List User" />
        </form>
    </body>
</html>

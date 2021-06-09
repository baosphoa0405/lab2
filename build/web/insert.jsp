<%-- 
    Document   : insert
    Created on : Jun 2, 2021, 10:40:57 PM
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
        <h1>Insert Page</h1>
        <h1 style="color: green">${requestScope.success}</h1>
        <form method="POST" action="insert" enctype="multipart/form-data">
            UserID <input type="text" name="userID" value="${requestScope.userNew.userID}" /><br/>
            <p style="color: red">${requestScope.usersError.errorID}</p>
            <p style="color: red">${requestScope.usersError.errorIDlength}</p>
            <p style="color: red">${requestScope.usersError.errorIDformat}</p>
            <p style="color: red">${requestScope.usersError.errorIDduplicate}</p>
            UserName <input type="text" name="userName" value="${requestScope.userNew.username}" /><br/>
            <p style="color: red">${requestScope.usersError.errorName}</p>
            <p style="color: red">${requestScope.usersError.errorNameFormat}</p>
            <p style="color: red">${requestScope.usersError.errorNameLength}</p>
            PassWord <input type="password" name="password" value="${requestScope.userNew.password}" /><br/>
            <p style="color: red">${requestScope.usersError.errorPassword}</p>
            <p style="color: red">${requestScope.usersError.errorPasswordLength}</p>
            Re-PassWord <input type="password" name="rePassword" value="${requestScope.repassword}" /><br/>
            <p style="color: red">${requestScope.usersError.errorRePassword}</p>
            Email <input type="text" name="email" value="${requestScope.userNew.email}" /><br/>
            <p style="color: red">${requestScope.usersError.errorEmail}</p>
            <p style="color: red">${requestScope.usersError.errorEmailFormat}</p>
            <p style="color: red">${requestScope.usersError.errorEmailLength}</p>
            phone <input type="text" name="phone" value="${requestScope.userNew.phone}" /><br/>
            <p style="color: red">${requestScope.usersError.errorPhone}</p>
            <p style="color: red">${requestScope.usersError.errorPhoneFormat}</p>
            <label for="Role">Roles</label>
            <select id="Role" name="role">
                <c:forEach items="${requestScope.listRole}" var="item">
                    <option value="${item.roleName}">${item.roleName}</option>
                </c:forEach>
            </select></br>
            photo <input type="file" name="photo" /><br/>
            <p style="color: red">${requestScope.usersError.errorPhoto}</p>
            <p style="color: red">${requestScope.errorFile}</p>
            <input type="submit" value="Insert"  />
        </form>
        <p style="color: red">${requestScope.usersError.errorConfirm}</p>
        <form action="search" method="POST">
            <input type="submit" value="View List User" />
        </form>
    </body>
</html>

<%-- 
    Document   : DetailUser
    Created on : Jun 5, 2021, 12:35:57 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detail User Page</title>
    </head>
    <body>
        <h1>Detail User hello,${sessionScope.user.username}</h1>
        <form method="POST" action="logout">
            <input type="submit" value="Logout" />
        </form>
        <p> userID: ${sessionScope.user.userID}</p>
        <p> name: ${sessionScope.user.username}</p>
        <p> email: ${sessionScope.user.email}</p>
        <p> phone: ${sessionScope.user.phone}</p>
        <p> image: <img src="./image/${sessionScope.user.photo}" width="100px" height="100px"/></p>
        <p>${requestScope.mess}</p>
        <c:if test="${empty requestScope.mess}">
            <table border="1">
                <thead>
                    <tr>
                        <th>Assign Date</th>
                        <th>Promotion Name</th>
                        <th>Rank</th>
                        <th>Status</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${requestScope.listHistory}">
                        <tr>
                            <td>${item.assignDate}</td>
                            <td>${item.promotionDTO.promotionName}</td>
                            <td>${item.statusDTO.statusName}</td>
                            <td>${item.rankDTO.rankValue}</td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
        </c:if>

    </body>
</html>

<%-- 
    Document   : ViewHistoryPromotion
    Created on : Jun 9, 2021, 6:57:26 PM
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
        <h1>List history</h1>
        <c:if test="${not empty requestScope.mess}">
            <p>${requestScope.mess}</p>
        </c:if>
        <c:if test="${empty requestScope.mess}">
            <table border="1">
                <thead>
                    <tr>
                        <th>UserID</th>
                        <th>Assign Date</th>
                        <th>Promotion Name</th>
                        <th>Status Name</th>
                        <th>Rank</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${requestScope.listHistory}">
                        <tr>
                            <td>${item.userID}</td>
                            <td>${item.assignDate}</td>
                            <td>${item.promotionDTO.promotionName}</td>
                            <td>${item.statusDTO.statusName}</td>
                            <td>${item.rankDTO.rankValue}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        <form action="viewListPromotion" method="POST">
            <input type="submit" value="View List Promotion" />
        </form>
    </body>
</html>

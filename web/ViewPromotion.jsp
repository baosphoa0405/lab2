<%-- 
    Document   : ViewPromotion
    Created on : Jun 8, 2021, 7:12:48 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List Promotion Page</title>
    </head>
    <body>
        <h1>List Promotion</h1>
        <table border="1">
            <thead>
                <tr>
                    <th>promotionID</th>
                    <th>promotionName</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="item" items="${requestScope.listPromotion}">
                    <tr>
                        <td>${item.promotionID}</td>
                        <td>${item.promotionName}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <form action="search" method="POST">
            <input type="submit" value="View List User" />
        </form>
    </body>
</html>

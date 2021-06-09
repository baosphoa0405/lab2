<%-- 
    Document   : UpdatePromotion
    Created on : Jun 8, 2021, 8:26:05 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update promotion Page</title>
    </head>
    <body>
        <h1>Update promotion</h1>
        <h1 style="color: green">${requestScope.mess}</h1>
        <p> userID: ${requestScope.historyPromotion.userID}</p>
        <p>Assign Date: ${requestScope.historyPromotion.assignDate}</p>
        <form method="POST" action="ConfirmUpdatedPromotion">
            <p>Promotion Name: <select name="promotionName">
                    <c:forEach items="${requestScope.listPromotion}" var="item">
                        <option value="${item.promotionName}" ${item.promotionName eq requestScope.historyPromotion.promotionDTO.promotionName ? "selected" : ""}>${item.promotionName}</option>
                    </c:forEach>
                </select> </p>
            <p>StatusName: ${requestScope.historyPromotion.statusDTO.statusName}</p>
            <p>Rank:<select name="rank">
                    <c:forEach items="${requestScope.listRank}" var="item">
                        <option value="${item.rankValue}" ${item.rankValue eq requestScope.historyPromotion.rankDTO.rankValue ? "selected" : ""}>${item.rankValue}</option>
                    </c:forEach>
                </select></p>
            <input type="hidden" name="status" value="${requestScope.historyPromotion.statusDTO.statusName}" />
            <input type="hidden" name="userID" value="${requestScope.historyPromotion.userID}" />
            <input type="submit" value="update submit" />
        </form>
          
        <form action="search" method="POST">
            <input type="submit" value="View List User" />
        </form>
            
    </body>
</html>

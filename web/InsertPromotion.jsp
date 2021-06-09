<%-- 
    Document   : InsertPromotion
    Created on : Jun 7, 2021, 11:45:19 PM
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
        <h1>Insert Promotion</h1>
        <label>Promotion</label>

        <form method="POST" action="insertPromotionConfirm">
            <select name="namePromotion">
                <c:forEach var="item" items="${requestScope.listPromotion}">
                    <option value="${item.promotionName}" ${requestScope.namePromotion eq item.promotionName ? "selected" : ""}>${item.promotionName}</option>
                </c:forEach>
            </select><br/>
            <input type="hidden" name="userID" value="${requestScope.userID}" />
            <input type="submit" value="Confirm" style="display: none" id="submit"/>
            ${requestScope.addSuccess}
            ${requestScope.addFail}
        </form>
        <button onclick="haha()">Submit</button>
        <form action="search" method="POST">
            <input type="submit" value="View List User" />
        </form>
        ${sessionScope.listHistory}
        <script>
            function haha() {
                confirmModal = confirm("Do you want to ")
                if(confirmModal){
                    document.getElementById("submit").click();
                }
            }
        </script>
    </body>
</html>

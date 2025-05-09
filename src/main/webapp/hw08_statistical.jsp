<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 09/05/2025
  Time: 09:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>Revenue Statistics</title>
</head>
<body>

<h2>Doanh Thu Các Tháng</h2>

<table border="1">
    <tr>
        <th>Tháng</th>
        <th>Doanh Thu</th>
    </tr>

    <c:set var="total" value="0" />
    <c:forEach var="r" items="${revenues}">
        <tr>
            <td>${r.month}</td>
            <td>${r.amount}</td>
        </tr>
        <c:set var="total" value="${total + r.amount}" />
    </c:forEach>
</table>

<h3>Tổng Doanh Thu: ${total}</h3>

<c:choose>
    <c:when test="${total > 10000}">
        <p style="color: green;"> Doanh thu vượt mốc 10,000! Quá đỉnh!</p>
    </c:when>
    <c:otherwise>
        <p style="color: red;"> Doanh thu chưa vượt mốc 10,000, cần cố gắng thêm nhé!</p>
    </c:otherwise>
</c:choose>

</body>
</html>

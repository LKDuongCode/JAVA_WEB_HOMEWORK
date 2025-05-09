<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 08/05/2025
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>hw01</title>
</head>
<body>

<h2>danh sách tất cả</h2>
<table border="1">
    <tr>
        <th>name </th>
        <th>price</th>
        <th>des</th>
    </tr>
    <c:forEach var="p" items="${hw01_products}">
        <tr>
            <td>${p.getName()}</td>
            <td>${p.getPrice()}</td>
            <td>${p.getDes()}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

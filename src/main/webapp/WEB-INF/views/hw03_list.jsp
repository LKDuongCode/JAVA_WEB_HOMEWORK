<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 27/05/2025
  Time: 08:48
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bus List</title>
</head>
<style>
    .btn-basic {
        display: inline-block;
        padding: 2px 6px;
        font-size: 13px;
        background-color: #e0e0e0;
        border: 1px solid #aaa;
        border-radius: 3px;
        text-decoration: none;
    }

    .btn-basic:hover {
        background-color: #d5d5d5;
    }
</style>
<body>
<h3>Bus List</h3>

<a href="${pageContext.request.contextPath}/buses/add" class="btn-basic">Add Bus</a>
<br><br>

<table border="1">
    <tr>
        <th>ID</th>
        <th>License Plate</th>
        <th>Type</th>
        <th>Row</th>
        <th>Col</th>
        <th>Total</th>
        <th>Image</th>
        <th>Action</th>
    </tr>

    <c:choose>
        <c:when test="${empty buses}">
            <tr><td colspan="8">No buses found!</td></tr>
        </c:when>
        <c:otherwise>
            <c:forEach var="b" items="${buses}">
                <tr>
                    <td>${b.id}</td>
                    <td>${b.licensePlate}</td>
                    <td>${b.busType}</td>
                    <td>${b.rowSeat}</td>
                    <td>${b.colSeat}</td>
                    <td>${b.totalSeat}</td>
                    <td><img src="${pageContext.request.contextPath}/uploads/${b.image}" width="150" alt="bus image"/></td>
                    <td>
                        <div style="display:flex; gap:5px;">
                            <a class="btn-basic" href="${pageContext.request.contextPath}/buses/edit/${b.id}">Edit</a>
                            <form method="post"
                                  action="${pageContext.request.contextPath}/buses/delete/${b.id}"
                                  onsubmit="return confirm('Delete this bus?')"
                                  style="display:inline;">
                                <button class="btn-basic" type="submit">Delete</button>
                            </form>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</table>
</body>
</html>


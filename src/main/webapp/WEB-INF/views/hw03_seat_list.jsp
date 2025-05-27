<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 27/05/2025
  Time: 08:49
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Seat List</title></head>
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
<h3>Seat List for Bus ID: ${busId}</h3>

<a href="${pageContext.request.contextPath}/seats/add/${busId}" class="btn-basic">Add Seat</a>
<br><br>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Status</th>
        <th>Action</th>
    </tr>

    <c:choose>
        <c:when test="${empty seats}">
            <tr><td colspan="5">No seats available!</td></tr>
        </c:when>
        <c:otherwise>
            <c:forEach var="s" items="${seats}">
                <tr>
                    <td>${s.id}</td>
                    <td>${s.nameSeat}</td>
                    <td>${s.price}</td>
                    <td>${s.status}</td>
                    <td>
                        <div style="display:flex; gap:5px;">
                            <a href="${pageContext.request.contextPath}/seats/edit/${s.id}" class="btn-basic">Edit</a>
                            <form method="post" action="${pageContext.request.contextPath}/seats/delete/${s.id}"
                                  onsubmit="return confirm('Delete this seat?')" style="display:inline;">
                                <button class="btn-basic" type="submit">Delete</button>
                            </form>
                        </div>
                    </td>
                </tr>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</table>

<a href="${pageContext.request.contextPath}/buses" class="btn-basic">Back to Bus List</a>
</body>
</html>

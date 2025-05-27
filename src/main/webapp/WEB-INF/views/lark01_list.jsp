<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 27/05/2025
  Time: 09:32
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head><title>Student List</title></head>
<body>
<h3>Student Lark List</h3>
<a href="${pageContext.request.contextPath}/students-lark/add">Add Student</a> <br>
<form action="${pageContext.request.contextPath}/students-lark/search" method="get" style="margin-top: 10px;">
    <input type="text" name="keyword" placeholder="Search by name..." value="${keyword}" required/>
    <button type="submit">Search</button>
</form>
<br><br>

<table border="1">
    <tr>
        <th>ID</th><th>Name</th><th>Email</th><th>Phone</th>
        <th>Sex</th><th>Birthdate</th><th>Status</th><th>Avatar</th><th>Action</th>
    </tr>
    <c:forEach var="s" items="${students}">
        <tr>
            <td>${s.id}</td>
            <td>${s.name}</td>
            <td>${s.email}</td>
            <td>${s.phone}</td>
            <td>${s.sex}</td>
            <td>${s.bod}</td>
            <td>${s.status}</td>
            <td>
                <c:if test="${not empty s.avatar}">
                    <img src="${pageContext.request.contextPath}/uploads/${s.avatar}" width="80"/>
                </c:if>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/students-lark/edit/${s.id}">Edit</a>
                <form method="post"  action="${pageContext.request.contextPath}/students-lark/delete/${s.id}" style="display:inline;">
                    <button type="submit" onclick="return confirm('Delete?')">Delete</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>


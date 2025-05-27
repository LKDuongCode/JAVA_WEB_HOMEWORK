<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 27/05/2025
  Time: 09:34
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Search Students</title></head>
<body>

<h3>Search Students by Name</h3>

<form action="${pageContext.request.contextPath}/students-lark/search" method="get">
    <input type="text" name="keyword" placeholder="Enter name to search" value="${keyword}" required/>
    <button type="submit">Search</button>
</form>

<br>

<c:if test="${not empty results}">
    <h4>Found ${fn:length(results)} result(s):</h4>
    <table border="1">
        <tr>
            <th>ID</th><th>Name</th><th>Email</th><th>Phone</th>
            <th>Sex</th><th>Birthdate</th><th>Status</th><th>Avatar</th><th>Action</th>
        </tr>
        <c:forEach var="s" items="${results}">
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
                    <form method="post" action="${pageContext.request.contextPath}/students-lark/delete/${s.id}">
                        <button type="submit" onclick="return confirm('Delete?')">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<c:if test="${empty results && not empty keyword}">
    <p>No results found for "<strong>${keyword}</strong>"</p>
</c:if>

</body>
</html>

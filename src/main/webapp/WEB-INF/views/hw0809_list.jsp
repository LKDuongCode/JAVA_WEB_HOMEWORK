<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 23/05/2025
  Time: 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Category List</title>
</head>
<body>
<h1>Category List</h1>

<c:if test="${not empty message}">
    <p style="color: green">${message}</p>
</c:if>

<a href="${pageContext.request.contextPath}/hw0809-add-form">Add New</a>
<br><br>

<table border="1" cellpadding="8">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Status</th>
    </tr>
    <c:forEach var="cat" items="${categories}">
        <tr>
            <td>${cat.id}</td>
            <td>${cat.name}</td>
            <td>
                <a href="${pageContext.request.contextPath}/hw0809-edit/${cat.id}">edit</a> |
                <form action="${pageContext.request.contextPath}/hw0809-delete/${cat.id}" method="post" style="display:inline;">
                    <button type="submit" onclick="return confirm('Bạn chắc chắn xóa?')">delete</button>
                </form>

            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>

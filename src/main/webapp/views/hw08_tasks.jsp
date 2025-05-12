<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 12/05/2025
  Time: 08:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh Sách Task</title>
</head>
<body>
<h2>Danh sách Task</h2>
<a href="${pageContext.request.contextPath}/hw08?action=add">Thêm Task Mới</a>
<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>ID</th>
        <th>Mô Tả</th>
        <th>Hạn Chót</th>
        <th>Hoàn Thành</th>
        <th>Hành Động</th>
    </tr>
    <c:forEach var="task" items="${tasks}">
        <tr>
            <td>${task.id}</td>
            <td>${task.description}</td>
            <td>${task.dueDate}</td>
            <td><c:if test="${task.completed}">hoàn thành</c:if><c:if test="${!task.completed}">chưa hoàn thành</c:if></td>
            <td>
                <a href="${pageContext.request.contextPath}/hw08?action=edit&id=${task.id}">Sửa</a> |
                <form action="${pageContext.request.contextPath}/hw08" method="post" style="display:inline;">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="id" value="${task.id}">
                    <input type="submit" value="Xóa" onclick="return confirm('Xác nhận xóa task?');">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

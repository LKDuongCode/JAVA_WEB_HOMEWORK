<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 13/05/2025
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cập nhật nhân viên</title>
</head>
<body>
<h1>Cập nhật nhân viên</h1>

<form method="post" action="${pageContext.request.contextPath}/employees">
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="id" value="${employee.id}">
    <label>Tên: <input type="text" name="name" value="${employee.name}" required></label><br>
    <label>Ngày sinh: <input type="date" name="birthday" value="${employee.birthday}" required></label><br>
    <label>SĐT: <input type="text" name="phone" value="${employee.phone}" required></label><br>
    <label>Email: <input type="email" name="email" value="${employee.email}" required></label><br>
    <label>Lương: <input type="number" step="0.01" name="salary" value="${employee.salary}" required></label><br>
    <label>Chức vụ: <input type="text" name="position" value="${employee.position}" required></label><br>
    <button type="submit">Cập nhật</button>
</form>

<a href="${pageContext.request.contextPath}/employees">Quay lại danh sách</a>
</body>
</html>

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
    <title>Thêm nhân viên</title>
</head>
<body>
<h1>Thêm nhân viên mới</h1>

<form method="post" action="${pageContext.request.contextPath}/employees">
    <input type="hidden" name="action" value="add">
    <label>Tên: <input type="text" name="name" required></label><br>
    <label>Ngày sinh: <input type="date" name="birthday" required></label><br>
    <label>SĐT: <input type="text" name="phone" required></label><br>
    <label>Email: <input type="email" name="email" required></label><br>
    <label>Lương: <input type="number" step="0.01" name="salary" required></label><br>
    <label>Chức vụ: <input type="text" name="position" required></label><br>
    <button type="submit">Thêm mới</button>
</form>

<a href="${pageContext.request.contextPath}/employees">Quay lại danh sách</a>
</body>
</html>


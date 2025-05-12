<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 12/05/2025
  Time: 08:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sửa Thông Tin Sinh Viên</title>
</head>
<body>
<h2>Sửa Thông Tin Sinh Viên</h2>
<form action="${pageContext.request.contextPath}/hw04/edit" method="post">
    <input type="hidden" name="id" value="${student.id}">
    Họ Tên: <input type="text" name="name" value="${student.name}" required><br><br>
    Tuổi: <input type="number" name="age" value="${student.age}" required><br><br>
    Địa Chỉ: <input type="text" name="address" value="${student.address}" required><br><br>
    <input type="submit" value="Cập Nhật">
</form>
</body>
</html>

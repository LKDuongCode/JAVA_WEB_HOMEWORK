<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 13/05/2025
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Danh sách nhân viên</title>
</head>
<body>
<h1>Danh sách nhân viên</h1>

<form method="get" action="${pageContext.request.contextPath}/employees">
    <input type="text" name="search" placeholder="Tìm theo tên hoặc ID">
    <button type="submit">Tìm kiếm</button>
</form>

<a href="${pageContext.request.contextPath}/views/hw04/addEmployee.jsp">+ Thêm nhân viên mới</a>

<table border="1" cellpadding="10" cellspacing="0">
    <thead>
    <tr>
        <th>ID</th>
        <th>Tên</th>
        <th>Ngày sinh</th>
        <th>SĐT</th>
        <th>Email</th>
        <th>Lương</th>
        <th>Chức vụ</th>
        <th>Hành động</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="employee" items="${employees}">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.name}</td>
            <td>${employee.birthday}</td>
            <td>${employee.phone}</td>
            <td>${employee.email}</td>
            <td>${employee.salary}</td>
            <td>${employee.position}</td>
            <td>
                <a href="${pageContext.request.contextPath}/employees?action=edit&id=${employee.id}">Sửa</a> |
                <a href="${pageContext.request.contextPath}/employees?action=delete&id=${employee.id}"
                   onclick="return confirm('Xác nhận xóa nhân viên này?')">Xóa</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

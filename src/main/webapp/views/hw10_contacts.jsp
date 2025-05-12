<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 12/05/2025
  Time: 08:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh Sách Liên Hệ</title>
</head>
<body>
<h2>Danh Sách Liên Hệ</h2>
<a href="${pageContext.request.contextPath}/contacts?action=add">Thêm Liên Hệ Mới</a>
<table border="1" >
    <tr>
        <th>Họ</th>
        <th>Tên</th>
        <th>Email</th>
        <th>Số Điện Thoại</th>
        <th>Hành Động</th>
    </tr>
    <c:forEach var="contact" items="${contacts}">
        <tr>
            <td>${contact.lastName}</td>
            <td>${contact.firstName}</td>
            <td>${contact.email}</td>
            <td>${contact.phone}</td>
            <td>
                <a href="${pageContext.request.contextPath}/contacts?action=edit&id=${contact.id}">Sửa</a> |
                <form action="${pageContext.request.contextPath}/contacts" method="post" style="display:inline;">
                    <input type="hidden" name="action" value="delete">
                    <input type="hidden" name="id" value="${contact.id}">
                    <input type="submit" value="Xóa" onclick="return confirm('Xác nhận xóa liên hệ?');">
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>


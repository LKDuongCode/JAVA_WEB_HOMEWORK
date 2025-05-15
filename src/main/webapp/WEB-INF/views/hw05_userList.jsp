<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh sách người dùng</title>
</head>
<body>
<h1>Danh sách người dùng</h1>
<table border="1" cellpadding="10" cellspacing="0">
    <tr>
        <th>STT</th>
        <th>Tên</th>
        <th>Tuổi</th>
        <th>Ngày sinh</th>
        <th>Email</th>
        <th>Số điện thoại</th>
    </tr>
    <c:forEach var="user" items="${users}" varStatus="status">
        <tr>
            <td>${status.index + 1}</td>
            <td>${user.name}</td>
            <td>${user.age}</td>
            <td>${user.birthday}</td>
            <td>${user.email}</td>
            <td>${user.phone}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Danh sách sản phẩm</title>
</head>
<body>
<h2>Danh sách sản phẩm</h2>

<table border="1">
    <tr>
        <th>Mã</th>
        <th>Tên</th>
        <th>Giá</th>
        <th>Hành động</th>
    </tr>
    <c:forEach items="${products}" var="p">
        <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.price}</td>
            <td>
                <a href="${pageContext.request.contextPath}/hw02/delete/${p.id}">Xoá</a>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="${pageContext.request.contextPath}/hw02/add">Thêm mới</a>
</body>
</html>

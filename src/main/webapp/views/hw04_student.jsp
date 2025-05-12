<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh Sách Sinh Viên</title>
</head>
<body>
<h2>Danh Sách Sinh Viên</h2>
<table border="1" >
    <tr>
        <th>STT</th>
        <th>Họ Tên</th>
        <th>Tuổi</th>
        <th>Địa Chỉ</th>
        <th>Hành Động</th>
    </tr>
    <c:forEach var="student" items="${students}" varStatus="loop">
        <tr>
            <td>${loop.index + 1}</td>
            <td>${student.name}</td>
            <td>${student.age}</td>
            <td>${student.address}</td>
            <td>
                <a href="${pageContext.request.contextPath}/hw04/edit?id=${student.id}">Sửa</a>
                |
                <a href="${pageContext.request.contextPath}/hw04/delete?id=${student.id}&page=${currentPage}"
                   onclick="return confirm('Bạn có chắc chắn muốn xóa sinh viên này không?');">Xóa</a>
            </td>
        </tr>
    </c:forEach>
</table>

<br>
<div>
    <c:if test="${currentPage > 1}">
        <a href="${pageContext.request.contextPath}/hw04?page=${currentPage - 1}">Trước</a>
    </c:if>

    Trang ${currentPage} của ${totalPages}

    <c:if test="${currentPage < totalPages}">
        <a href="${pageContext.request.contextPath}/hw04?page=${currentPage + 1}">Tiếp</a>
    </c:if>
</div>
<p><a href="${pageContext.request.contextPath}/logout">Đăng Xuất</a></p>
</body>
</html>

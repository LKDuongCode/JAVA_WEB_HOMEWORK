<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 16/05/2025
  Time: 07:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Danh sách phim</title>
</head>
<body>
<h1>Phim đang chiếu</h1>

<table border="1" cellpadding="10">
    <tr>
        <th>Tiêu đề</th>
        <th>Đạo diễn</th>
        <th>Thể loại</th>
        <th>Chi tiết</th>
    </tr>
    <c:forEach var="movie" items="${movies}">
        <tr>
            <td>${movie.title}</td>
            <td>${movie.director}</td>
            <td>${movie.genre}</td>
            <td><a href="movie/${movie.id}">Xem</a></td>
        </tr>
    </c:forEach>
</table>

<p>hw03 : Khi hiển thị chi tiết phim, render tất cả các lịch chiếu phim đang chiếu hoặc sắp chiếu của phim đó để người dùng có thể xem.</p>
</body>
</html>

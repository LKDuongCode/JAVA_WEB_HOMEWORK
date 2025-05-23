
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh sách phim</title>
</head>
<body>
<h2>Danh sách phim</h2>

<a href="${pageContext.request.contextPath}/hw10/add">Thêm phim</a>
<br/><br/>

<table border="1" cellpadding="5" cellspacing="0">
    <tr>
        <th>Id</th>
        <th>Tiêu đề</th>
        <th>Đạo diễn</th>
        <th>Ngày phát hành</th>
        <th>Thể loại</th>
        <th>Poster</th>
        <th>Hành động</th>
    </tr>
    <c:forEach var="movie" items="${movies}">
        <tr>
            <td>${movie.id}</td>
            <td>${movie.title}</td>
            <td>${movie.director}</td>
            <td>${movie.releaseDate}</td>
            <td>${movie.genre}</td>
            <td>
                <c:if test="${not empty movie.poster}">
                    <img src="${movie.poster}" alt="poster" width="100"/>
                </c:if>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/hw10/edit/${movie.id}">Sửa</a> |
                <a href="${pageContext.request.contextPath}/hw10/delete/${movie.id}" onclick="return confirm('Xác nhận xoá?')">Xoá</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 16/05/2025
  Time: 08:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Chi tiết phim</title>
</head>
<body>

<c:if test="${not empty error}">
    <p style="color: red">${error}</p>
</c:if>

<c:if test="${not empty movie}">
    <h1>${movie.title}</h1>
    <p><strong>Đạo diễn:</strong> ${movie.director}</p>
    <p><strong>Thể loại:</strong> ${movie.genre}</p>
    <p><strong>Thời lượng:</strong> ${movie.duration} phút</p>
    <p><strong>Ngôn ngữ:</strong> ${movie.language}</p>
    <p><strong>Mô tả:</strong> ${movie.description}</p>

    <h3>Lịch chiếu</h3>
    <c:if test="${empty schedules}">
        <p>Hiện chưa có lịch chiếu cho phim này.</p>
    </c:if>

    <c:if test="${not empty schedules}">
        <table border="1" cellpadding="10">
            <tr>
                <th>Thời gian chiếu</th>
                <th>Phòng</th>
                <th>Ghế còn lại</th>
                <th>Định dạng</th>
                <th>Đặt vé</th>
            </tr>
            <c:forEach var="s" items="${schedules}">
                <tr>
                    <td>${s.showTime}</td>
                    <td>${s.screenRoomId}</td>
                    <td>${s.availableSeats}</td>
                    <td>${s.format}</td>
                    <td><a href="<c:url value='/ticket/booking/${s.id}'/>">Đặt vé</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>

    <p><a href="<c:url value='/home'/>">Quay lại</a></p>
</c:if>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 12/05/2025
  Time: 08:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh Sách Bài Viết</title>
</head>
<body>
<h2>Danh Sách Bài Viết</h2>
<table border="1" >
    <tr>
        <th>Tiêu Đề</th>
        <th>Tác Giả</th>
        <th>Ngày Đăng</th>
        <th>Xem Chi Tiết</th>
    </tr>
    <c:forEach var="post" items="${posts}">
        <tr>
            <td>${post.title}</td>
            <td>${post.author}</td>
            <td>${post.publishDate}</td>
            <td><a href="${pageContext.request.contextPath}/hw09/post?id=${post.id}">Xem</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

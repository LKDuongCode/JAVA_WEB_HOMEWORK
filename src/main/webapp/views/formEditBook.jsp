<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 12/05/2025
  Time: 21:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>sửa sách</title>
</head>
<body>
<h1>Sửa sách</h1>
<form action="${pageContext.request.contextPath}/book?action=edit" method="post">
    <input type="number" name="id" readonly value="${edit_book.id}">
    <input type="text" name="title" placeholder="title..." value="${edit_book.title}">
    <input type="text" name="author" placeholder="author..." value="${edit_book.author}">
    <input type="text" name="category" placeholder="category..." value="${edit_book.category}">
    <input type="number" name="quantity" placeholder="quantity..." value="${edit_book.quantity}">
    <button type="submit">update now!</button>
</form>

<a href="${pageContext.request.contextPath}/book?action=list">quay lại</a>
</body>
</html>

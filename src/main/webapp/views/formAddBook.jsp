<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 12/05/2025
  Time: 18:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>thêm sách mới</title>
</head>
<body>
<h1>Thêm sách mới</h1>
<form action="${pageContext.request.contextPath}/book?action=create" method="post">
    <input type="text" name="title" placeholder="name...">
    <input type="text" name="author" placeholder="author...">
    <input type="text" name="category" placeholder="category...">
    <input type="number" name="quantity" placeholder="quantity...">
    <button type="submit">add now!</button>
</form>

<a href="${pageContext.request.contextPath}/book?action=list">quay lại</a>
</body>
</html>

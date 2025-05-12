<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 12/05/2025
  Time: 08:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Chi Tiết Bài Viết</title>
</head>
<body>
<h2>${post.title}</h2>
<p><strong>Tác Giả:</strong> ${post.author}</p>
<p><strong>Ngày Đăng:</strong> ${post.publishDate}</p>
<hr>
<p>${post.content}</p>

<br>
<a href="${pageContext.request.contextPath}/hw09">Quay Về Danh Sách</a>
</body>
</html>


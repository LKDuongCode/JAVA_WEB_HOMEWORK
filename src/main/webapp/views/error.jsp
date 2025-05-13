<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 12/05/2025
  Time: 18:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page isErrorPage="true" contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>ERROR</title>
    <style>
        body { font-family: sans-serif; text-align: center; margin-top: 100px; }
        h1 { color: red; }
        .details { margin-top: 20px; color: gray; }
        a { text-decoration: none; color: blue; }
    </style>
</head>
<body>
<h1>OOPS</h1>

<c:if test="${not empty errorMessage}">
    <p>${errorMessage}</p>
</c:if>

<!-- Thông báo lỗi hệ thống -->
<c:if test="${not empty exception}">
    <div class="details">
        <p><b>Loại lỗi:</b> ${exception.class.name}</p>
        <p><b>Chi tiết:</b> ${exception.message}</p>
    </div>
</c:if>

<!-- Lỗi HTTP status -->
<c:if test="${not empty pageContext.errorData}">
    <div class="details">
        <p><b>Mã lỗi HTTP:</b> ${pageContext.errorData.statusCode}</p>
        <p><b>URL bị lỗi:</b> ${pageContext.errorData.requestURI}</p>
    </div>
</c:if>

<p><a href="${pageContext.request.contextPath}/">Quay về trang chủ</a></p>
</body>
</html>


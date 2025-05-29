<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 29/05/2025
  Time: 09:40
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Đăng nhập</title>
</head>
<body>
<h2>Đăng nhập</h2>

<c:if test="${not empty error}">
    <p style="color: red">${error}</p>
</c:if>

<form:form action="${pageContext.request.contextPath}/hw07/login" method="post" modelAttribute="loginForm">
    <label>Tên đăng nhập:</label><br>
    <form:input path="username"/><br><br>

    <label>Mật khẩu:</label><br>
    <form:password path="password"/><br><br>

    <label>
        <form:checkbox path="rememberMe"/> Ghi nhớ tôi
    </label><br><br>

    <button type="submit">Đăng nhập</button>
</form:form>
</body>
</html>

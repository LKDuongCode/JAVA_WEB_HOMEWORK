<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 16/05/2025
  Time: 07:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>login</title>
</head>
<body>
<form action="login" method="post">
    <input type="text" name="username" placeholder="Username...">
    <input type="password" name="password" placeholder="Password...">
    <button type="submit">Login</button>
</form>

<c:if test="${not empty error}">
    <p style="color: red">${error}</p>
</c:if>

</body>
</html>

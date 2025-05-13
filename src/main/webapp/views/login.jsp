<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 13/05/2025
  Time: 08:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<h1>LOGIN</h1>
<div>
    <form action="${pageContext.request.contextPath}/auth?action=login" method="post" style="display: flex; flex-direction: column; gap: 10px">
        <input type="text" name="email" placeholder="email...">
        <input type="password" name="password" placeholder="password...">
        <button type="submit">login</button>
    </form>
</div>
<c:if test="${not empty errorMessage}">
    <p style="color: red;">${errorMessage}</p>
</c:if>

<br>
<a href="${pageContext.request.contextPath}/auth?action=register">create new account</a>
</body>
</html>

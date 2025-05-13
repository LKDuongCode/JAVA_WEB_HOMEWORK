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
    <title>register</title>
</head>
<body>
<h1>REGISTER</h1>
<form action="${pageContext.request.contextPath}/auth?action=register" method="post" style="display: flex; flex-direction: column; gap: 10px">
    <input type="text" name="username" placeholder="username...">
    <input type="text" name="email" placeholder="email...">
    <input type="text" name="phone" placeholder="phone...">
    <input type="text" name="password" placeholder="password...">
    <button type="submit">register</button>
</form>
<c:if test="${not empty errorMessage}">
    <p style="color: red;">${errorMessage}</p>
</c:if>

<br>

<p style="display: flex; gap: 10px">
    <p>have an account?</p>
    <a href="${pageContext.request.contextPath}/auth?action=login">login now!</a>
</p>

</body>
</html>

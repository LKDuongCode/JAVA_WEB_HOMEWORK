<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
<form action="hw02" method="post">
    <input type="text" name="username" placeholder="username...">
    <input type="password" name="password" placeholder="password...">
    <button type="submit">Login</button>
</form>

<c:if test="${not empty loginSuccess}">
    <c:choose>
        <c:when test="${loginSuccess}">
            <p style="color: green;">Welcome, ${username}!</p>
        </c:when>
        <c:otherwise>
            <p style="color: red;"> Wrong username or password. Please try again!</p>
        </c:otherwise>
    </c:choose>
</c:if>
</body>
</html>

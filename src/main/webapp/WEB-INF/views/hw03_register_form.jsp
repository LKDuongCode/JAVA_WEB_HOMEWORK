<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 18/05/2025
  Time: 08:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>
<c:choose>
    <c:when test="${empty account.email and empty account.username and empty account.password}">
        <h3>register</h3>
        <form:form method="post" action="hw03-register" modelAttribute="account">
            <form:input path="username"/>
            <form:input path="email"/>
            <form:input path="password"/>
            <form:button>register</form:button>
        </form:form>
    </c:when>
    <c:otherwise>
        <h3>Your account was registered!</h3>
    </c:otherwise>
</c:choose>
</body>
</html>

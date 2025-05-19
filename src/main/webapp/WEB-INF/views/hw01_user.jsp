<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 17/05/2025
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>hw01</title>
</head>
<body>
<h3>personal info</h3>
<br>
<form:form method="post" action="hw01" modelAttribute="user">
    <form:input path="name" placeholder="name..."/>
    <br>
    <form:input path="age"  type="number"/>
    <br>
    <form:input path="address" placeholder="address..."/>
    <br>
    <form:button type="submit">submit</form:button>
</form:form>
</body>
</html>

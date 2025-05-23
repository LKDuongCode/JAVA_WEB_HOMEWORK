<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 22/05/2025
  Time: 22:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>custom validator</title>
</head>
<body>
<h3>test custom validate</h3>
<form:form method="post" action="hw03" modelAttribute="hw03DTO">
  <form:input path="email"/>
    <br>
    <form:errors path="email" cssStyle="color: red" placeholder="email..."/>
    <br>
  <form:button>test</form:button>
</form:form>
</body>
</html>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 22/05/2025
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>user info</title>
</head>
<body>
<h3>user info</h3>
<form:form method="post" modelAttribute="infoDTO" action="hw01">
  <form:input path="name" placeholder="name..."/>
  <br>

  <form:input path="email"  placeholder="email..."/>
  <br>

  <form:input path="phone"  placeholder="phone..."/>
  <br>
  <form:input path="password"  placeholder="password..."/>
  <br>
  status: <form:checkbox path="status"/>
  <form:button>submit</form:button>

  <br>
  <form:errors path="name" cssStyle="color: red"/>
  <br>
  <form:errors path="password" cssStyle="color: red"/>
  <br>
  <form:errors path="phone" cssStyle="color: red"/>
  <br>
  <form:errors path="email" cssStyle="color: red"/>
  <br>
</form:form>
</body>
</html>

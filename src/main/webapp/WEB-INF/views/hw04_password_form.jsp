<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 23/05/2025
  Time: 00:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>password test</title>
</head>
<body>
<h3>test password</h3>
<form:form action="hw04" method="post" modelAttribute="password">
  <form:input path="password" placeholder="password..."/>
    <br>
    <form:errors path="password" cssStyle="color: red"/>
    <br>
  <form:button>test</form:button>
</form:form>
</body>
</html>

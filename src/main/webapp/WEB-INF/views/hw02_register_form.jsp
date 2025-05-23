<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 22/05/2025
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>
<form:form action="hw02" method="post" modelAttribute="registerDTO">
    <form:input placeholder = "name..." path="name"/>
    <br>
    
    <form:errors  cssStyle="color: red"  path="name"/>
    <br>
    <form:input placeholder = "email..." path="email"/>
    <br>
    
    <form:errors  cssStyle="color: red" path="email"/>
    <br>
    <form:input placeholder = "password..." path="password"/>
    <br>
    
    <form:errors  cssStyle="color: red" path="password"/>
    <br>
    <form:button>register</form:button>
</form:form>
</body>
</html>

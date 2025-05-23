<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 23/05/2025
  Time: 08:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>group form</title>
</head>
<body>
<form:form modelAttribute="userDTO" method="post" action="hw05">
  <form:input path="username" placeholder="username..."/>
  <div style="color:red">${usernameError}</div>
    <br>
  <form:input path="email"  placeholder="email..."/>
  <div style="color:red">${emailError}</div>
    <br>
  <form:radiobutton path="role" value="ADMIN"/> admin
    <br>
  <form:radiobutton path="role" value="NORMAL" /> normal
    <br>
  <c:if test="${userDTO.role.toString() eq 'ADMIN'}">
        <form:input path="adminCode"  placeholder="admin code..."/>
      <div style="color:red">${adminCodeError}</div>
    </c:if>
    <br>
    <form:button>register</form:button>

</form:form>
</body>
</html>

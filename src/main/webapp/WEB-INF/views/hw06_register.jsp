<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 29/05/2025
  Time: 09:47
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
  <title><spring:message code="hw06.form.title"/></title>
</head>
<body>
<h2><spring:message code="hw06.form.title"/></h2>

<form:form action="${pageContext.request.contextPath}/hw06/register" method="post" modelAttribute="userDTO">
  <label><spring:message code="hw06.label.username"/></label><br>
  <form:input path="username"/><form:errors path="username"/><br><br>

  <label><spring:message code="hw06.label.password"/></label><br>
  <form:password path="password"/><form:errors path="password"/><br><br>

  <label><spring:message code="hw06.label.confirmPassword"/></label><br>
  <form:password path="confirmPassword"/><form:errors path="confirmPassword"/><br><br>

  <label><spring:message code="hw06.label.email"/></label><br>
  <form:input path="email"/><form:errors path="email"/><br><br>

  <button type="submit"><spring:message code="hw06.button.submit"/></button>
</form:form>

<p>
  Ngôn ngữ:
  <a href="?lang=vi">Tiếng Việt</a> |
  <a href="?lang=en">English</a>
</p>

</body>
</html>

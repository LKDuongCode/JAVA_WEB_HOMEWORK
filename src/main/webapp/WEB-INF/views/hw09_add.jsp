<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 29/05/2025
  Time: 09:21
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title><spring:message code="hw09.form.title"/></title>
</head>
<body>
<h2><spring:message code="hw09.form.title"/></h2>

<form action="${pageContext.request.contextPath}/hw09/add" method="post">
    <label><spring:message code="hw09.label.description"/></label><br>
    <input type="text" name="description"/><br><br>

    <label><spring:message code="hw09.label.amount"/></label><br>
    <input type="number" step="0.01" name="amount"/><br><br>

    <label><spring:message code="hw09.label.type"/></label><br>
    <select name="type">
        <option value="income"><spring:message code="hw09.type.income"/></option>
        <option value="expense"><spring:message code="hw09.type.expense"/></option>
    </select><br><br>

    <button type="submit"><spring:message code="hw09.button.submit"/></button>
</form>

<p>
    <a href="${pageContext.request.contextPath}/hw09/list">
        <spring:message code="hw09.list.link"/>
    </a>
</p>

<p>Ngôn ngữ:
    <a href="?lang=vi">Tiếng Việt</a> |
    <a href="?lang=en">English</a>
</p>
</body>
</html>

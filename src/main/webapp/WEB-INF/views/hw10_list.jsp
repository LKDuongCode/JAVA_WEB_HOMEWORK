<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 29/05/2025
  Time: 08:34
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title><spring:message code="list.title"/></title>
</head>
<body>
<h2><spring:message code="list.title"/></h2>

<table border="1">
    <tr>
        <th>ID</th>
        <th><spring:message code="list.name"/></th>
        <th><spring:message code="list.description"/></th>
    </tr>
    <c:forEach items="${categories}" var="cat">
        <tr>
            <td>${cat.id}</td>
            <td>${cat.categoryName}</td>
            <td>${cat.description}</td>
        </tr>
    </c:forEach>
</table>

<br>
<a href="${pageContext.request.contextPath}/categories/add">
    <spring:message code="form.title"/>
</a>

<p>
    Ngôn ngữ: <a href="?lang=vi">Tiếng Việt</a> | <a href="?lang=en">English</a>
</p>
</body>
</html>

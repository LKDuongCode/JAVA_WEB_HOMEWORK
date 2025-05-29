<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 29/05/2025
  Time: 09:25
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
  <meta charset="UTF-8">
  <title><spring:message code="hw09.list.title"/></title>
</head>
<body>
<h2><spring:message code="hw09.list.title"/></h2>

<table border="1">
  <tr>
    <th>#</th>
    <th><spring:message code="hw09.list.description"/></th>
    <th><spring:message code="hw09.list.amount"/></th>
    <th><spring:message code="hw09.list.type"/></th>
    <th><spring:message code="hw09.list.delete"/></th>
  </tr>
  <c:forEach items="${transactions}" var="t" varStatus="status">
    <tr>
      <td>${status.index}</td>
      <td>${t.description}</td>
      <td>${t.amount}</td>
      <td>
        <c:choose>
          <c:when test="${t.type == 'income'}">
            <spring:message code="hw09.type.income"/>
          </c:when>
          <c:otherwise>
            <spring:message code="hw09.type.expense"/>
          </c:otherwise>
        </c:choose>
      </td>
      <td>
        <a href="${pageContext.request.contextPath}/hw09/delete/${status.index}">
          <spring:message code="hw09.list.delete"/>
        </a>
      </td>
    </tr>
  </c:forEach>
</table>

<p>
  <a href="${pageContext.request.contextPath}/hw09/add">
    <spring:message code="hw09.form.title"/>
  </a>
</p>

<p>
  Ngôn ngữ:
  <a href="?lang=vi">Tiếng Việt</a> |
  <a href="?lang=en">English</a>
</p>
</body>
</html>

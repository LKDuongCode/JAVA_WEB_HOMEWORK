<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Danh sách nhân viên</title>
</head>
<body>
<h1>Danh sách nhân viên</h1>

<c:if test="${not empty message}">
  <p style="color:green;">${message}</p>
</c:if>

<table border="1" cellpadding="10" cellspacing="0">
  <tr>
    <th>STT</th>
    <th>Tên</th>
    <th>Email</th>
    <th>Vị trí</th>
  </tr>
  <c:forEach var="employee" items="${employees}" varStatus="status">
    <tr>
      <td>${status.index + 1}</td>
      <td>${employee.name}</td>
      <td>${employee.email}</td>
      <td>${employee.position}</td>
    </tr>
  </c:forEach>
</table>

<br/>
<a href="${pageContext.request.contextPath}/hw06/employees/add">Thêm nhân viên mới</a>
</body>
</html>

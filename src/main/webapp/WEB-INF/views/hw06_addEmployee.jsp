<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
  <title>Thêm nhân viên mới</title>
</head>
<body>
<h1>Form Thêm Nhân Viên</h1>

<form:form action="${pageContext.request.contextPath}/hw06/employees" method="post" modelAttribute="employee">
  Tên: <form:input path="name" /><br/><br/>
  Email: <form:input path="email" /><br/><br/>
  Vị trí: <form:input path="position" /><br/><br/>
  <input type="submit" value="Thêm mới">
</form:form>

<br/>
<a href="${pageContext.request.contextPath}/hw06/employees">Quay về danh sách</a>
</body>
</html>

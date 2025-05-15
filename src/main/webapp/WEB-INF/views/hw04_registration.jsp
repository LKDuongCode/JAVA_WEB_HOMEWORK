<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
  <title>Đăng ký người dùng</title>
</head>
<body>
<h1>Form Đăng Ký</h1>

<form:form action="${pageContext.request.contextPath}/hw04/register" method="post" modelAttribute="user">
  Tên: <form:input path="name" />
  <br/>
  <c:if test="${not empty nameError}">
    <span style="color:red;">${nameError}</span>
  </c:if>
  <br/><br/>

  Email: <form:input path="email" />
  <br/>
  <c:if test="${not empty emailError}">
    <span style="color:red;">${emailError}</span>
  </c:if>
  <br/><br/>

  Số điện thoại: <form:input path="phone" />
  <br/>
  <c:if test="${not empty phoneError}">
    <span style="color:red;">${phoneError}</span>
  </c:if>
  <br/><br/>

  <input type="submit" value="Đăng ký">
</form:form>
</body>
</html>


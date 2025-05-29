
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Đăng nhập</title></head>
<body>

<h2>Đăng nhập</h2>

<c:if test="${not empty error}">
  <p style="color:red">${error}</p>
</c:if>

<form:form action="${pageContext.request.contextPath}/hw01/login" method="post" modelAttribute="loginUserDTO">
  Tên người dùng: <form:input path="name"/><br>
  Mật khẩu: <form:password path="password"/><br>
  <button type="submit">Đăng nhập</button>
</form:form>

</body>
</html>

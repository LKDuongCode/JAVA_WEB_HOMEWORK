<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Đăng ký</title>
</head>
<body>
<h1>Đăng ký tài khoản</h1>
<form action="${pageContext.request.contextPath}/hw08/register" method="post">
  Tên đăng nhập: <input type="text" name="username" /><br/><br/>
  Mật khẩu: <input type="password" name="password" /><br/><br/>
  Email: <input type="email" name="email" /><br/><br/>
  <input type="submit" value="Đăng ký">
</form>

<c:if test="${not empty error}">
  <p style="color:red;">${error}</p>
</c:if>

<p>Đã có tài khoản? <a href="${pageContext.request.contextPath}/hw08/login">Đăng nhập</a></p>
</body>
</html>

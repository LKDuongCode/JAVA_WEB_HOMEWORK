<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Đăng nhập</title>
</head>
<body>
<h1>Đăng nhập</h1>
<form action="${pageContext.request.contextPath}/hw08/login" method="post">
  Tên đăng nhập: <input type="text" name="username" /><br/><br/>
  Mật khẩu: <input type="password" name="password" /><br/><br/>
  <input type="submit" value="Đăng nhập">
</form>

<c:if test="${not empty error}">
  <p style="color:red;">${error}</p>
</c:if>

<p>Chưa có tài khoản? <a href="${pageContext.request.contextPath}/hw08/register">Đăng ký</a></p>
</body>
</html>

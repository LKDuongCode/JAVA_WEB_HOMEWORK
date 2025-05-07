<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 07/05/2025
  Time: 08:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Đăng kí thông tin</h1>
<form action="user-registration-servlet" method="post">
  <label for="name">name:</label>
  <input type="text" name="name" id="name">
  <label for="email">email:</label>
  <input type="text" name="email" id="email">
  <label for="password">password:</label>
  <input type="text" name="password" id="password">

  <button type="submit">register now!</button>
</form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 07/05/2025
  Time: 07:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>đăng kí</title>
</head>
<body>
<form action="register" method="post">
  <label for="username">username:</label>
  <input type="text" name="username" id="username">

  <label for="email">email:</label>
  <input type="text" name="email" id="email">

  <button type="submit">submit</button>
</form>

<div>${error}</div>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 06/05/2025
  Time: 16:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Thông tin người dùng</h1>
<form action="user-info" method="post">
  <p>Tên của bạn:</p>
  <input type="text" name="username" required>

  <p>Tuổi:</p>
  <input type="number" name="age" min="0">

  <button type="submit">submit</button>
</form>

<h2>Result:</h2>
<p>name: ${name}</p>
<p>age: ${age}</p>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 12/05/2025
  Time: 07:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Thông Tin Sinh Viên</title>
</head>
<body>
<h2>Nhập Thông Tin Sinh Viên</h2>
<form action="${pageContext.request.contextPath}/hw03" method="post">
    Họ Tên: <input type="text" name="name" required><br><br>
    Tuổi: <input type="number" name="age" required><br><br>
    Địa Chỉ: <input type="text" name="address" required><br><br>
    <button type="submit">submit</button>
</form>

<c:if test="${not empty errorMsg}">
    <p style="color:red;">${errorMsg}</p>
</c:if>
</body>
</html>


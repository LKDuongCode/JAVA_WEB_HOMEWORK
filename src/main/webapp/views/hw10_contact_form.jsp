<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 12/05/2025
  Time: 08:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>${contact != null ? 'Chỉnh Sửa' : 'Thêm'} Liên Hệ</title>
</head>
<body>
<h2>${contact != null ? 'Chỉnh Sửa' : 'Thêm Mới'} Liên Hệ</h2>
<form action="${pageContext.request.contextPath}/contacts" method="post">
  <input type="hidden" name="action" value="${contact != null ? 'update' : 'create'}">
  <c:if test="${contact != null}">
    <input type="hidden" name="id" value="${contact.id}">
  </c:if>

  <label>Họ:</label><br>
  <input type="text" name="lastName" value="${contact != null ? contact.lastName : ''}" required><br><br>

  <label>Tên:</label><br>
  <input type="text" name="firstName" value="${contact != null ? contact.firstName : ''}" required><br><br>

  <label>Email:</label><br>
  <input type="email" name="email" value="${contact != null ? contact.email : ''}" required><br><br>

  <label>Số Điện Thoại:</label><br>
  <input type="text" name="phone" value="${contact != null ? contact.phone : ''}" required><br><br>

  <input type="submit" value="Lưu">
</form>
</body>
</html>


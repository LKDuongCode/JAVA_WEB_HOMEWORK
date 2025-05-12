<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 12/05/2025
  Time: 08:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>${task != null ? 'Chỉnh Sửa' : 'Thêm Mới'} Task</title>
</head>
<body>
<h2>${task != null ? 'Chỉnh Sửa' : 'Thêm Mới'} Task</h2>
<form action="${pageContext.request.contextPath}/hw08" method="post">
  <input type="hidden" name="action" value="${task != null ? 'update' : 'create'}">
  <c:if test="${task != null}">
    <input type="hidden" name="id" value="${task.id}">
  </c:if>
  <label>Mô Tả:</label><br>
  <input type="text" name="description" value="${task != null ? task.description : ''}" required><br><br>

  <label>Hạn Chót:</label><br>
  <input type="date" name="dueDate" value="${task != null ? task.dueDate : ''}" required><br><br>

  <c:if test="${task != null}">
    <label>Hoàn Thành:</label>
    <input type="checkbox" name="completed" ${task.completed ? 'checked' : ''}><br><br>
  </c:if>


  <input type="submit" value="Lưu">
</form>
</body>
</html>

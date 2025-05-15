<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Shop Hạt giống</title>
</head>
<body>
<h1>Shop Hạt Giống</h1>
<table border="1" cellpadding="10" cellspacing="0">
  <tr>
    <th>Hình ảnh</th>
    <th>Tên hạt giống</th>
    <th>Giá</th>
  </tr>
  <c:forEach var="seed" items="${seeds}">
    <tr>
      <td><img src="${seed.imageUrl}" width="100"/></td>
      <td>${seed.seedsName}</td>
      <td>${seed.price}</td>
    </tr>
  </c:forEach>
</table>

<br/>
<a href="${pageContext.request.contextPath}/hw08/home">Về trang chủ</a>
</body>
</html>

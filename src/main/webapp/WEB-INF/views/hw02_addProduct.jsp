<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Thêm sản phẩm mới</title>
</head>
<body>
<h1>Thêm sản phẩm mới</h1>
<form action="${pageContext.request.contextPath}/hw02/add" method="post">
  Tên sản phẩm: <input type="text" name="name" /><br/><br/>
  <input type="submit" value="Thêm mới">
</form>
</body>
</html>

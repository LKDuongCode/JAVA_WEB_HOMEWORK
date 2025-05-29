<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm sản phẩm</title>
</head>
<body>
<h2>Thêm sản phẩm vào giỏ hàng</h2>

<form:form method="post" action="${pageContext.request.contextPath}/hw04/add" modelAttribute="product">
    Tên sản phẩm: <form:input path="name"/><br>
    Số lượng: <form:input path="quantity" type="number"/><br>
    <button type="submit">Thêm</button>
</form:form>

</body>
</html>


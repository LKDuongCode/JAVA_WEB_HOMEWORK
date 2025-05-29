
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Thêm sản phẩm</title>
</head>
<body>
<h2>Thêm sản phẩm</h2>

<form:form action="${pageContext.request.contextPath}/hw02/add" method="post" modelAttribute="productItem">
    Mã sản phẩm: <form:input path="id"/><br>
    Tên sản phẩm: <form:input path="name"/><br>
    Giá: <form:input path="price"/><br>
    <button type="submit">Thêm</button>
</form:form>

<a href="${pageContext.request.contextPath}/hw02/list">Xem danh sách</a>
</body>
</html>

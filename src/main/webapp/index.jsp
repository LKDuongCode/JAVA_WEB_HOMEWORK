<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Spring MVC Homework Menu</title>
</head>
<body>
<h1>Spring MVC - Homework Menu</h1>

<ul>
    <li><a href="${pageContext.request.contextPath}/home">Hw01 </a></li>
    <li><a href="${pageContext.request.contextPath}/greet?name=Duong">Hw02</a></li>
    <li><a href="${pageContext.request.contextPath}/abcxyz">Hw03 </a></li>
    <li><a href="${pageContext.request.contextPath}/feedback/form">Hw04 </a></li>
    <li><a href="${pageContext.request.contextPath}/about">Hw05 </a></li>
    <li><a href="${pageContext.request.contextPath}/list">Hw06_07</a></li>
    <li><a href="${pageContext.request.contextPath}/products/clothes;color=red;size=M">Hw08</a></li>
    <li><a href="${pageContext.request.contextPath}/products">Hw09</a></li>
    <li><a href="${pageContext.request.contextPath}/courses">Hw10</a></li>
</ul>

</body>
</html>

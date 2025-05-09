<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 09/05/2025
  Time: 09:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Student List</title>
</head>
<body>
<h2>Student List</h2>

<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Age</th>
        <th>GPA</th>
    </tr>

    <c:set var="count" value="0" />
    <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.id}</td>
            <td>${student.name}</td>
            <td>${student.age}</td>
            <td>${student.gpa}</td>
        </tr>
        <c:if test="${student.gpa > 7.0}">
            <c:set var="count" value="${count + 1}" />
        </c:if>
    </c:forEach>
</table>

<p>Số sinh viên có điểm trung bình > 7.0 =  ${count} người</p>

</body>
</html>

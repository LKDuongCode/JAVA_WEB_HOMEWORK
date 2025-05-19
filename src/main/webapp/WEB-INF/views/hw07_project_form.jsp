<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<html>
<head>
    <title>Tạo Dự Án</title>
</head>
<body>
<h2>Tạo Dự Án Mới</h2>

<c:if test="${not empty message}">
    <p style="color:green;">${message}</p>
</c:if>
<c:if test="${not empty errorMessage}">
    <p style="color:red;">${errorMessage}</p>
</c:if>

<form:form method="post"
           action="${empty editIndex ? 'hw07-create' : 'hw07-update'}"
           modelAttribute="project"
           enctype="multipart/form-data">

    <label>Tên dự án:</label><br>
    <form:input path="name"/><br><br>

    <label>Mô tả:</label><br>
    <form:textarea path="description"/><br><br>

    <label>Tài liệu:</label><br>
    <input type="file" name="documentFiles" multiple/><br><br>

    <c:if test="${not empty editIndex}">
        <input type="hidden" name="editIndex" value="${editIndex}" />
    </c:if>

    <button type="submit">${empty editIndex ? 'Tạo dự án' : 'Cập nhật dự án'}</button>
</form:form>

<hr>
<h3>Danh sách dự án</h3>
<table border="1" cellpadding="8">
    <tr>
        <th>Tên</th>
        <th>Mô tả</th>
        <th>Số tài liệu</th>
        <th>Hành động</th>
    </tr>
    <c:forEach items="${projectList}" var="p" varStatus="loop">
        <tr>
            <td>${p.name}</td>
            <td>${p.description}</td>
            <td><c:out value="${fn:length(p.documents)}" /></td>
            <td>
                <a href="hw07-edit?index=${loop.index}">Sửa</a> |
                <a href="hw07-delete?index=${loop.index}" onclick="return confirm('Bạn chắc chắn muốn xoá?')">Xoá</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

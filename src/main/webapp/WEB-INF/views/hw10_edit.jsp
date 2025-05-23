<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Sửa phim</title>
</head>
<body>
<h2> Sửa phim</h2>

<form:form modelAttribute="movieUpdateDTO" method="post" action="${pageContext.request.contextPath}/hw10/edit">
    <form:hidden path="id"/>

    <div>
        <label>Tiêu đề:</label>
        <form:input path="title"/>
        <form:errors path="title" cssStyle="color: red"/>
    </div>
    <div>
        <label>Đạo diễn:</label>
        <form:input path="director"/>
        <form:errors path="director" cssStyle="color: red"/>
    </div>
    <div>
        <label>Ngày phát hành:</label>
        <form:input type="date" path="releaseDate"/>
        <form:errors path="releaseDate" cssStyle="color: red"/>
    </div>
    <div>
        <label>Thể loại:</label>
        <form:input path="genre"/>
        <form:errors path="genre" cssStyle="color: red"/>
    </div>
    <div>
        <label>Poster URL:</label>
        <form:input path="poster"/>
        <form:errors path="poster" cssStyle="color: red"/>
    </div>
    <div>
        <button type="submit">Cập nhật</button>
        <a href="${pageContext.request.contextPath}/hw10">Huỷ</a>
    </div>
</form:form>
</body>
</html>

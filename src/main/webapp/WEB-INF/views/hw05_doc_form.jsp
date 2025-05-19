<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 19/05/2025
  Time: 09:57
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Upload</title>
</head>
<body>
<h3>upload file</h3>
<form:form method="post" modelAttribute="document" action="${pageContext.request.contextPath}/hw05-doc-upload" enctype="multipart/form-data">
  <table>
    <tr>
      <td>Tiêu đề:</td>
      <td><form:input path="title"/></td>
    </tr>
    <tr>
      <td>Mô tả:</td>
      <td><form:input path="description"/></td>
    </tr>
    <tr>
      <td>Chọn file:</td>
      <td><input type="file" name="file"/></td>
    </tr>
    <tr>
      <td colspan="2"><input type="submit" value="Upload"/></td>
    </tr>
  </table>
</form:form>

<c:if test="${not empty message}">
  <p style="color:green;">${message}</p>
  <p><strong>Tiêu đề:</strong> ${title}</p>
  <p><strong>Mô tả:</strong> ${description}</p>
  <p><strong>File đã upload:</strong> ${uploadedFile}</p>
</c:if>

<c:if test="${not empty errorMessage}">
  <p style="color:red;">${errorMessage}</p>
</c:if>
</body>
</html>


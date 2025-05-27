<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 27/05/2025
  Time: 08:00
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Edit Product</title>
</head>
<style>
  .edit-container {
    display: flex;
    flex-direction: column;
    gap: 4px;
  }

  .edit-form {
    width: 300px;
    display: flex;
    flex-direction: column;
    gap: 4px;
    border: black solid;
    padding: 6px;
  }
</style>
<body>
<h3>Edit Product</h3>

<form:form method="post" modelAttribute="updateDTO" action="${pageContext.request.contextPath}/products/edit"
           cssClass="edit-form" enctype="multipart/form-data">
  <form:hidden path="id"/>
  <form:hidden path="image"/> <!-- giữ ảnh cũ nếu không upload mới -->

  <div class="edit-container">
    <p>Name</p>
    <form:input path="name"/>
    <form:errors path="name" cssStyle="color: red"/>
  </div>

  <div class="edit-container">
    <p>Price</p>
    <form:input path="price" type="number"/>
    <form:errors path="price" cssStyle="color: red"/>
  </div>

  <div class="edit-container">
    <p>Quantity</p>
    <form:input path="quantity" type="number"/>
    <form:errors path="quantity" cssStyle="color: red"/>
  </div>

  <div class="edit-container">
    <p>Current Image</p>
    <img src="${pageContext.request.contextPath}/uploads/${updateDTO.image}" width="200" alt="image"/>
  </div>

  <div class="edit-container">
    <p>Upload New Image</p>
    <form:input path="imageFile" type="file"/>
    <form:errors path="imageFile" cssStyle="color: red"/>
  </div>

  <form:button>Update</form:button>
  <a href="${pageContext.request.contextPath}/products">Back to list</a>
</form:form>

</body>
</html>


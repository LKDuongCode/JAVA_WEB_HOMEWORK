    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%--
      Created by IntelliJ IDEA.
      User: duong
      Date: 18/05/2025
      Time: 21:31
      To change this template use File | Settings | File Templates.
    --%>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>
    <head>
        <title>Upload Info</title>
    </head>
    <body>
    <h1>Upload Avatar</h1>

    <c:if test="${not empty message}">
        <p style="color: green;">${message}</p>
    </c:if>

    <c:if test="${not empty errorMessage}">
        <p style="color: red;">${errorMessage}</p>
    </c:if>


    <form:form method="post" action="hw04-upload-server" modelAttribute="user-profile" enctype="multipart/form-data">
        <label>Username:</label>
        <form:input path="username"/><br><br>

        <label>Avatar:</label>
        <form:input path="avatar" type="file"/><br><br>

        <input type="submit" value="Upload"/>
    </form:form>


    <c:if test="${not empty uploadedFile}">
        <h3>Kết quả:</h3>
        <p>Username: ${username}</p>
        <p>File đã upload:</p>
        <img src="${pageContext.request.contextPath}/uploads/}" />

    </c:if>


    </body>
    </html>


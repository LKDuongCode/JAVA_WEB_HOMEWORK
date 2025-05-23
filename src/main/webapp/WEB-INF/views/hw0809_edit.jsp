<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit</title>
</head>
<body>
<h2>edit</h2>

<form:form method="post" modelAttribute="categoryUpdateDTO" action="${pageContext.request.contextPath}/hw0809-update">

    <form:hidden path="id" />

    <div>
        <label for="categoryName">name</label>
        <form:input path="name" id="categoryName"/>
        <form:errors path="name" cssStyle="color: red"/>
    </div>

    <div>
        <button type="submit">update</button>
        <a href="${pageContext.request.contextPath}/hw0809">back</a>
    </div>
</form:form>


</body>
</html>

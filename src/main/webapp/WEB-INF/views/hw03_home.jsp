
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><spring:message code="title"/></title>
</head>
<body>
<h2><spring:message code="title"/></h2>
<p><spring:message code="description"/></p>
<p><spring:message code="instruction"/></p>

<form action="${pageContext.request.contextPath}/hw03/change-lang" method="post">
    <select name="lang">
        <option value="vi">Tiếng Việt</option>
        <option value="en">English</option>
    </select>
    <button type="submit">Chuyển ngôn ngữ</button>
</form>
</body>
</html>

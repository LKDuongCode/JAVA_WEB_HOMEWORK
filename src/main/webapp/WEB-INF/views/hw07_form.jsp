<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: duong
  Date: 23/05/2025
  Time: 09:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>rating product form</title>
</head>
<body>
<form:form modelAttribute="reviewDTO" method="post" action="hw07">
  <form:input path="name" placeholder="name..."/>
  <br>
  <form:input path="email" placeholder="email"/>
  <br>
  <form:textarea path="note" placeholder="comment..."/>
  <br>
  <div style="display: flex; gap: 14px">
    <div>
      <form:radiobutton path="star" value="1"/> 1 star
    </div>
    <div>
      <form:radiobutton path="star" value="2"/> 2 stars
    </div>
    <div>
      <form:radiobutton path="star" value="3"/> 3 stars
    </div>
    <div>
      <form:radiobutton path="star" value="4"/> 4 stars
    </div>
    <div>
      <form:radiobutton path="star" value="5"/> 5 stars
    </div>
  </div>

  <form:button>submit</form:button>
  <br>
  <form:errors path="name" cssStyle="color: red"/>
  <br>
  <form:errors path="email" cssStyle="color: red"/>
  <br>
  <form:errors path="note" cssStyle="color: red"/>
</form:form>
</body>
</html>

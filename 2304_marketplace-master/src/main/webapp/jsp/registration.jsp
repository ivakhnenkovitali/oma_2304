<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="by.itclass.constants.AppConst" %>
<%@ page import="by.itclass.constants.JspConst" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Registration</title>
    <link rel="stylesheet" href="/css/styles.css">
</head>
<body>
    <jsp:include page="<%=JspConst.MENU_JSP%>"/>
    <img class="default-image" src="<%=JspConst.BACKGROUND_IMAGE%>" alt="img">
    <div class="form-box">
        <h2>Registration</h2>
        <form action="<%=AppConst.REGISTRATION_CONTROLLER%>" method="post">
            <input name="<%=JspConst.NAME_PARAM%>" placeholder="Name">
            <input name="<%=JspConst.EMAIL_PARAM%>" placeholder="Email">
            <input name="<%=JspConst.LOGIN_PARAM%>" placeholder="Login">
            <input type="password" name="<%=JspConst.PASS_PARAM%>" placeholder="Password">
            <input type="submit" value="Register">
        </form>
        <c:if test="${not empty message}">
            <h2 class="error">${message}</h2>
        </c:if>
    </div>
</body>
</html>

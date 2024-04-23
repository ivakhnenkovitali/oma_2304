<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="by.itclass.constants.AppConst" %>
<%@ page import="by.itclass.constants.JspConst" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul class="nav-ul">
    <c:choose>
        <c:when test="${empty user}">
            <li class="nav-li">
                <a href="<%=JspConst.LOGIN_JSP%>">Login</a></li>
            <li class="nav-li">
                <a href="<%=JspConst.REGISTRATION_JSP%>">Registration</a></li>
        </c:when>
        <c:otherwise>
            <li class="nav-li float-left">
                <a class="active" href="<%=JspConst.HOME_JSP%>">Home</a></li>
            <li class="nav-li">
                <a href="<%=AppConst.LOGOUT_CONTROLLER%>">Logout</a></li>
            <li class="nav-li float-left">
                <a href="<%=AppConst.TV_STOCK%>">TV</a></li>
            <li class="nav-li float-left">
                <a href="<%=AppConst.LAPTOP_STOCK%>">Laptop</a></li>
        </c:otherwise>
    </c:choose>
</ul>

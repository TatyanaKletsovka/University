<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
<%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>

<fmt:bundle basename="page_content">
    <fmt:message key="login.title" var="title"/>
    <fmt:message key="login.log_in" var="log_in"/>
    <fmt:message key="login.enter_login" var="enter_login"/>
    <fmt:message key="login.enter_password" var="enter_password"/>
</fmt:bundle>
<html>


    <body class="page">

        <input type="hidden" name="pageUrl" value="/jsp/common/main.jsp" />

        <div>
           <%@ include file="/jsp/common/header.jsp"%>
        </div>

        <div>
           <%@ include file="/jsp/common/mainMenu.jsp"%>
        </div>


        <div>
            <%@ include file="/jsp/common/footer.jsp"%>
        </div>
    </body>
</html>
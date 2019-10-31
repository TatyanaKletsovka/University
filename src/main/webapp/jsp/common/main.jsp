<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
<%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib uri="https://epam.by/datetag" prefix="datetag"%>

<fmt:bundle basename="page_content">
    <fmt:message key="main.welcome" var="welcome"/>
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

        <h1 class="welcome">${pageScope.welcome}</h1>
    </body>
</html>
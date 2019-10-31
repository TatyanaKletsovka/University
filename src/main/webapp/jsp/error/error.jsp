<%@ page isErrorPage="true" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<fmt:bundle basename="page_content">
    <fmt:message key="error.title" var="title"/>
    <fmt:message key="error.error_number" var="error_number"/>
    <fmt:message key="error.message" var="message"/>
</fmt:bundle>

<html>
    <head>
        <title>${pageScope.title}</title>
    </head>

    <body class="page">
        <div>
           <%@ include file="/jsp/common/header.jsp"%>
        </div>

        <div>
           <%@ include file="/jsp/common/mainMenu.jsp"%>
        </div>

        <div class="error_form">
            <h1>
                ${pageScope.error_number}
            </h1>
            <p>
                ${pageScope.message}
            </p>
            Request from ${pageContext.errorData.requestURI} is failed
            <br/>
            Servlet name or type: ${pageContext.errorData.servletName}
            <br/>
            Status code: ${pageContext.errorData.statusCode}
            <br/>
            Exception: ${pageContext.errorData.throwable}
        </div>
    </body>
</html>
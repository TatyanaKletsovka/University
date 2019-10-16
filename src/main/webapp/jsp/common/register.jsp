<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/lib/css/font-awesome.min.css">

<fmt:bundle basename="page_content">
    <fmt:message key="register.title" var="title"/>
    <fmt:message key="register.enter_login" var="enter_login"/>
    <fmt:message key="register.enter_password" var="enter_password"/>
    <fmt:message key="register.repeat_password" var="repeat_password"/>
    <fmt:message key="register.first_name" var="first_name"/>
    <fmt:message key="register.last_name" var="last_name"/>
    <fmt:message key="register.register_submit" var="register_submit"/>
</fmt:bundle>

<html>
    <head>
        <title>${pageScope.title}</title>
    </head>

    <body class="page">
        <div>
            <%@ include file="/jsp/common/header.jsp"%>
        </div>

        <div class="reg_form">
            <form id="reg" name="RegisterForm" method="POST" action="${pageContext.request.contextPath}/controller">
                <input type="hidden" name="command" value="common_register"/>
                <p><span>${pageScope.enter_login}</span>
                    <input id="login" title="${pageScope.title_login}" type="text" name="login" value="" onkeyup="checkLogin();"/>
                </p>
                <p><span>${pageScope.enter_password}</span>
                    <input id="password" title="${pageScope.title_password}" type="password" name="password" value=""
                           onkeyup="checkPassword();"/>
                </p>
                <p><span>${pageScope.repeat_password}</span>
                    <input id="confirm_password" title="${pageScope.title_confirm_password}" type="password" value=""
                           onkeyup="checkPassword();"/>
                </p>
                <p><span>${pageScope.first_name}</span>
                    <input id="first_name" title="${pageScope.title_first_name}" type="text" name="first_name" value=""
                           onkeyup="checkName();"/>
                </p>
                <p><span>${pageScope.last_name}</span>
                    <input id="last_name" title="${pageScope.title_last_name}" type="text" name="last_name" value=""
                           onkeyup="checkName();"/>
                </p>
                <input class="reg_submit" id="submit" type="submit" value="${pageScope.register_submit}" disabled/>
                ${errorUniqueLoginMessage}
            </form>
        </div>

        <div>
            <%@ include file="/jsp/common/footer.jsp"%>
        </div>

        <script>
            <jsp:directive.include file="/js/registerValidation.js"/>
        </script>
    </body>
</html>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">


<fmt:bundle basename="page_content">
    <fmt:message key="login.title" var="title"/>
    <fmt:message key="login.enter_login" var="enter_login"/>
    <fmt:message key="login.enter_password" var="enter_password"/>
    <fmt:message key="login.log_in" var="log_in"/>

</fmt:bundle>

<html>
    <head>
        <title>${pageScope.title}</title>
    </head>

    <body class="page">
        <div>
            <%@ include file="/jsp/common/header.jsp"%>
        </div>

        <div class="wrapper_form">
            <form name="loginForm" method="POST" action="${pageContext.request.contextPath}/controller">
            <input type="hidden" name="command" value="login" />
                <p>
                    <label>${pageScope.enter_login}<input class="log_input" type="text" name="login" value=""/></label>
                </p>
                <p>
                    <label>${pageScope.enter_password}<input class="log_input" type="password" name="password" value=""/></label>
                </p>
                ${errorLoginMessage}
            <br/>
                ${wrongAction}
            <br/>
                ${nullPage}
            <br/>
            <input type="submit" value="${pageScope.log_in}"/>
            </form>
        </div>

        <div>
            <%@ include file="/jsp/common/mainMenu.jsp"%>
        </div>

        <div>
            <%@ include file="/jsp/common/footer.jsp"%>
        </div>
    </body>
</html>
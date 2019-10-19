<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">

<fmt:bundle basename="page_content">
    <fmt:message key="show_all_users.title" var="title"/>
    <fmt:message key="show_all_users.number" var="number"/>
    <fmt:message key="show_all_users.login" var="login"/>
    <fmt:message key="show_all_users.role" var="role"/>
    <fmt:message key="show_all_users.delete" var="delete"/>
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

        <div class="table">
            <table>
                <tr>
                    <th>${pageScope.number}</th>
                    <th>${pageScope.login}</th>
                    <th>${pageScope.role}</th>

                    <c:if test="${sessionScope.user.role == 'ADMIN'}">
                        <th class="button">${pageScope.delete}</th>
                    </c:if>

                </tr>

                <c:forEach items="${showAllUsers}" var="user" begin="0" varStatus="loop">
                    <tr>
                        <td> ${loop.begin + loop.count}</td>
                        <td> ${user.login}</td>
                        <td> ${user.role}</td>
                            <c:if test="${sessionScope.user.role == 'ADMIN'}">
                                <td class="button">
                                    <button>${pageScope.delete}</button>
                                </td>
                            </c:if>
                    </tr>
                </c:forEach>

            </table>
        </div>
    </body>

    <div>
        <%@ include file="/jsp/common/footer.jsp"%>
    </div>
</html>

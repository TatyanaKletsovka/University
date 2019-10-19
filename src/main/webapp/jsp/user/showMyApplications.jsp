<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">

<fmt:bundle basename="page_content">
    <fmt:message key="show_my_applications.title" var="title"/>
    <fmt:message key="show_all_applications.number" var="number"/>
    <fmt:message key="show_all_applications.faculty" var="faculty"/>
    <fmt:message key="show_all_applications.places" var="places"/>
    <fmt:message key="show_all_applications.passing_points" var="passing_points"/>
    <fmt:message key="show_all_applications.first_name" var="first_name"/>
    <fmt:message key="show_all_applications.last_name" var="last_name"/>
    <fmt:message key="show_all_applications.certificate" var="certificate"/>
    <fmt:message key="show_all_applications.marks" var="marks"/>
    <fmt:message key="show_all_applications.status" var="status"/>
    <fmt:message key="show_all_applications.date_of_register" var="date_of_register"/>
    <fmt:message key="show_my_applications.delete" var="delete"/>
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
                    <th>${pageScope.faculty}</th>
                    <th>${pageScope.places}</th>
                    <th>${pageScope.passing_points}</th>
                    <th>${pageScope.first_name}</th>
                    <th>${pageScope.last_name}</th>
                    <th>${pageScope.certificate}</th>
                    <th>${pageScope.marks}</th>
                    <th>${pageScope.status}</th>
                    <th>${pageScope.date_of_register}</th>
                    <th class="button">${pageScope.delete}</th>
                </tr>

                <c:forEach items="${showMyApplications}" var="application" begin="0" varStatus="loop">
                    <tr>
                        <td> ${loop.begin + loop.count}</td>
                        <td> ${application.faculty.name}</td>
                        <td> ${application.faculty.places}</td>
                        <td> ${application.faculty.passingPoints}</td>
                        <td> ${application.student.firstName}</td>
                        <td> ${application.student.lastName}</td>
                        <td> ${application.student.certificate}</td>
                        <td> ${application.student.marks}</td>
                        <td> ${application.status}</td>
                        <td> ${application.dateTime}</td>
                        <td class="button">
                        <form name="button" method="POST" action="controller">
                        <input type="hidden" name="command" value="delete_application" />
                        <input type="hidden" class="log_input" type="text" name="applicationId" value="${application.id}"/>
                        <input type="submit" value="${pageScope.delete}"/>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>

        <div>
            <%@ include file="/jsp/common/footer.jsp"%>
        </div>
    </body>
</html>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">

<fmt:bundle basename="page_content">
    <fmt:message key="show_all_faculties.title" var="title"/>
    <fmt:message key="show_all_faculties.number" var="number"/>
    <fmt:message key="show_all_faculties.name" var="name"/>
    <fmt:message key="show_all_faculties.places" var="places"/>
    <fmt:message key="show_all_faculties.passing_points" var="passing_points"/>
    <fmt:message key="show_all_faculties.subjects" var="subjects"/>
    <fmt:message key="show_all_faculties.delete" var="delete"/>
    <fmt:message key="show_all_faculties.apply" var="apply"/>
    <fmt:message key="show_all_faculties.add_new_faculty" var="add_new_faculty"/>


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


        <div class="table_order">
            <table>
                <tr>
                    <th>${pageScope.number}</th>
                    <th>${pageScope.name}</th>
                    <th>${pageScope.places}</th>
                    <th>${pageScope.passing_points}</th>
                    <th>${pageScope.subjects}</th>
                        <c:if test="${sessionScope.user.role == 'ADMIN'}">
                            <th class="button">${pageScope.delete}</th>
                        </c:if>
                        <c:if test="${sessionScope.user.role == 'USER'}">
                            <th class="button">${pageScope.apply}</th>
                        </c:if>
                </tr>

                <c:forEach items="${showAllFaculties}" var="faculty">
                    <tr>
                        <td> ${faculty.id}</td>
                        <td> ${faculty.name}</td>
                        <td> ${faculty.places}</td>
                        <td> ${faculty.passingPoints}</td>
                        <td> ${faculty.subjects}</td>
                            <c:if test="${sessionScope.user.role == 'ADMIN'}">
                                <td class="button"><button>${pageScope.delete}</button></td>
                            </c:if>
                            <c:if test="${sessionScope.user.role == 'USER'}">
                                <td class="button">
                                    <form name="button" method="POST" action="controller">
                                    <input type="hidden" name="command" value="go_to_application_page" />
                                    <input type="hidden" class="log_input" type="text" name="facultyId" value="${faculty.id}"/>
                                    <input type="submit" value="${pageScope.apply}"/>
                                    </form>
                                </td>
                            </c:if>
                    </tr>
                </c:forEach>

                <c:if test="${sessionScope.user.role == 'ADMIN'}">
                <th class="button" colspan="2"><button>${pageScope.add_new_faculty}</button></th>
                </c:if>
            </table>
        </div>

        <div>
            <%@ include file="/jsp/common/footer.jsp"%>
        </div>
    </body>
</html>

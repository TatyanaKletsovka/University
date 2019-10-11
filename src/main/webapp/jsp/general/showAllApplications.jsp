<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">

<fmt:bundle basename="page_content">
    <fmt:message key="client.description_title" var="title"/>

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
        <th>№</th>
        <th>Faculty</th>
        <th>Places</th>
        <th>Passing points</th>
    <c:if test="${sessionScope.user.role == 'ADMIN'}">
        <th>First name</th>
        <th>Last name</th>
    </c:if>
        <th>Certificate</th>
        <th>Marks</th>
        <th>Status</th>
        <th>Date of register</th>
    </tr>
<c:forEach items="${showAllApplications}" var="application">
    <tr>
        <td> ${application.id}</td>
        <td> ${application.faculty.name}</td>
        <td> ${application.faculty.places}</td>
        <td> ${application.faculty.passingPoints}</td>
    <c:if test="${sessionScope.user.role == 'ADMIN'}">
        <td> ${application.student.firstName}</td>
        <td> ${application.student.lastName}</td>
    </c:if>
        <td> ${application.student.certificate}</td>
        <td> ${application.student.marks}</td>
        <td> ${application.status}</td>
        <td> ${application.dateTime}</td>
    </tr>
</c:forEach>
     <c:if test="${sessionScope.user.role == 'ADMIN'}">
         <th class="button" colspan="2">
            <form name="button" method="POST" action="controller">
            <input type="hidden" name="command" value="process_applications" />
            <input type="submit" value="Process applications"/>
         </th>
     </c:if>
</table>


</div>
</body>

    <div>
        <%@ include file="/jsp/common/footer.jsp"%>
    </div>
</html>

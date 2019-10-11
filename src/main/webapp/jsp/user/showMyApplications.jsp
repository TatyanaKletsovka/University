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
<table >
   <tr>
         <th>№</th>
         <th>Faculty</th>
         <th>Places</th>
         <th>Passing points</th>
         <th>First name</th>
         <th>Last name</th>
         <th>Certificate</th>
         <th>Marks</th>
         <th>Status</th>
         <th>Date of register</th>
         <th class="button">Delete</th>
  </tr>
        <c:forEach items="${showMyApplications}" var="application">
             <tr>
                   <td> ${application.id}</td>
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
                       <input type="submit" value="Delete"/>
                   </td>

       </tr>
         </c:forEach>

</table>

</div>
</body>

    <div>
        <%@ include file="/jsp/common/footer.jsp"%>
    </div>
</html>

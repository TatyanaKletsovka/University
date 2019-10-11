<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">


<fmt:bundle basename="page_content">
    <fmt:message key="exercise.create_title" var="title"/>
    <fmt:message key="exercise.select_level" var="level"/>
    <fmt:message key="exercise.beginner" var="beginner"/>
    <fmt:message key="exercise.expert" var="expert"/>
    <fmt:message key="exercise.pro" var="pro"/>
    <fmt:message key="exercise.description" var="description"/>
    <fmt:message key="exercise.create_exercise" var="create"/>
    <fmt:message key="exercise.name" var="name"/>
    <fmt:message key="title.exercise_name" var="title_name"/>
    <fmt:message key="title.exercise_level" var="title_level"/>
    <fmt:message key="title.exercise_description" var="title_description"/>
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

<div class="training_program_description_day">
    <form id="createExercise" name="createExercise" method="POST"
          action="${pageContext.request.contextPath}/controller">
        <input type="hidden" name="command" value="create_application"/>
        <input type="hidden" name="facultyId" value="${sessionScope.faculty.id}" />
        <h1>${sessionScope.faculty.name}</h1>

        <c:forEach items="${sessionScope.faculty.subjects}" var="subject">
            <label>${subject.name}
                <input id="mark_id" class="create_application_ball" type="text" name="${subject.id}" value="" onkeyup="checkMark();"/>
            </label>
         </c:forEach>
        <p>
            <label>Certificate
                <input id="certificate_id" class="create_exercise_name" type="text" name="certificate" value="" onkeyup="checkCertificate();"/>
            </label>
        </p>

        <button class="create_exercise_confirm" id="submit" type="submit" disabled>Apply</button>
    </form>
</div>

<script>
    <jsp:directive.include file="/js/applyValidation.js"/>
</script>

</body>

    <div>
        <%@ include file="/jsp/common/footer.jsp"%>
    </div>
</html>

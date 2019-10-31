<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">


<fmt:bundle basename="page_content">
    <fmt:message key="create_application.title" var="title"/>
    <fmt:message key="create_application.school_certificate" var="school_certificate"/>
    <fmt:message key="create_application.apply" var="apply"/>
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

    <div class="create_application_form">
        <form id="createExercise" name="createExercise" method="POST"
              action="${pageContext.request.contextPath}/controller">
            <input type="hidden" name="command" value="create_application"/>
            <input type="hidden" name="facultyId" value="${sessionScope.faculty.id}" />
            <h1>${sessionScope.faculty.name}</h1>
            <p>
                <label>${sessionScope.faculty.subjects[0].name}
                    <input id="mark_id0" class="create_application_ball" type="text" name="${sessionScope.faculty.subjects[0].id}"
                    value="" onkeyup="checkMark0();"/>
                </label>
                <label>${sessionScope.faculty.subjects[1].name}
                    <input id="mark_id1" class="create_application_ball" type="text" name="${sessionScope.faculty.subjects[1].id}"
                    value="" onkeyup="checkMark1();"/>
                </label>
                <label>${sessionScope.faculty.subjects[2].name}
                    <input id="mark_id2" class="create_application_ball" type="text" name="${sessionScope.faculty.subjects[2].id}"
                    value="" onkeyup="checkMark2();"/>
                </label>
            </p>
            <p>
                <label>${pageScope.school_certificate}
                    <input id="certificate_id" class="create_application_name" type="text" name="certificate"
                    value="" onkeyup="checkCertificate();"/>
                </label>
            </p>

            <button class="create_application_confirm" id="submit" type="submit" disabled>${pageScope.apply}</button>
        </form>
    </div>

    <script>
        <jsp:directive.include file="/js/applyValidation.js"/>
    </script>
    </body>
</html>

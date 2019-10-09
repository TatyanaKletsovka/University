<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<fmt:bundle basename="page_content">
    <fmt:message key="client.description_title" var="title"/>
    <fmt:message key="client.next" var="next"/>
    <fmt:message key="client.previous" var="previous"/>
</fmt:bundle>

<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">
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
         <th>Login</th>
         <th>Role</th>

         <c:if test="${sessionScope.user.role == 'ADMIN'}">
            <th class="button">Delete</th>
         </c:if>

  </tr>
        <c:forEach items="${showAllUsers}" var="user">
             <tr>
                   <td> ${user.id}</td>
                   <td> ${user.login}</td>
                   <td> ${user.role}</td>
                    <c:if test="${sessionScope.user.role == 'ADMIN'}">
                        <td class="button"><button>Delete</button></td>
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

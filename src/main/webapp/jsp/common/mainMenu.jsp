<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/lib/css/font-awesome.min.css">

<fmt:bundle basename="page_content">
    <fmt:message key="menu.show_faculties" var="show_faculties"/>

</fmt:bundle>

<div class="user_menu">
    <ul>

        <c:choose>

             <c:when test="${sessionScope.user.role == 'ADMIN'}">
                 <li>
                     <a href="${pageContext.request.contextPath}/jsp/common/main.jsp">Main</a>
                 </li>

                 <li>
                     <a href="${pageContext.request.contextPath}/controller?command=show_all_faculties">${pageScope.show_faculties}</a>
                 </li>

                 <li>
                     <a href="${pageContext.request.contextPath}/controller?command=show_all_students">show_all_students</a>
                 </li>

                 <li>
                     <a href="${pageContext.request.contextPath}/controller?command=show_all_users">show_all_users</a>
                 </li>

                 <li>
                     <a href="${pageContext.request.contextPath}/controller?command=admin_account">Admin account</a>
                 </li>

                 <li>
                     <a href="${pageContext.request.contextPath}/controller?command=show_all_applications">show_all_applications</a>
                 </li>
             </c:when>


             <c:when test="${sessionScope.user.role == 'USER'}">
                 <li>
                     <a href="${pageContext.request.contextPath}/jsp/common/main.jsp">Main</a>
                 </li>

                 <li>
                     <a href="${pageContext.request.contextPath}/controller?command=show_all_faculties">${pageScope.show_faculties}/Apply</a>
                 </li>

                 <li>
                     <a href="${pageContext.request.contextPath}/controller?command=show_all_applications">show_all_applications</a>
                 </li>

                 <li>
                     <a href="${pageContext.request.contextPath}/controller?command=show_my_applications">show_my_applications</a>
                 </li>

                 <li>
                     <a href="${pageContext.request.contextPath}/controller?command=account">Account</a>
                 </li>





             </c:when>


         </c:choose>


    </ul>
</div>
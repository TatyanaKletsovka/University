<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/lib/css/font-awesome.min.css">

<fmt:bundle basename="page_content">
    <fmt:message key="main_menu.main" var="main"/>
    <fmt:message key="main_menu.show_faculties" var="show_faculties"/>
    <fmt:message key="main_menu.show_faculties_admin" var="show_faculties_admin"/>
    <fmt:message key="main_menu.show_all_users" var="show_all_users"/>
    <fmt:message key="main_menu.show_all_applications" var="show_all_applications"/>
    <fmt:message key="main_menu.show_my_applications" var="show_my_applications"/>
</fmt:bundle>

<div class="user_menu">
    <ul>
        <c:choose>
             <c:when test="${sessionScope.user.role == 'ADMIN'}">
                 <li>
                     <a href="${pageContext.request.contextPath}/jsp/common/main.jsp">${pageScope.main}</a>
                 </li>

                 <li>
                     <a href="${pageContext.request.contextPath}/controller?command=show_all_faculties">${pageScope.show_faculties_admin}</a>
                 </li>

                 <li>
                     <a href="${pageContext.request.contextPath}/controller?command=show_all_users">${pageScope.show_all_users}</a>
                 </li>

                 <li>
                     <a href="${pageContext.request.contextPath}/controller?command=show_all_applications">${pageScope.show_all_applications}</a>
                 </li>
             </c:when>


             <c:when test="${sessionScope.user.role == 'USER'}">
                 <li>
                     <a href="${pageContext.request.contextPath}/jsp/common/main.jsp">${pageScope.main}</a>
                 </li>

                 <li>
                     <a href="${pageContext.request.contextPath}/controller?command=show_all_faculties">${pageScope.show_faculties}</a>
                 </li>

                 <li>
                     <a href="${pageContext.request.contextPath}/controller?command=show_all_applications">${pageScope.show_all_applications}</a>
                 </li>

                 <li>
                     <a href="${pageContext.request.contextPath}/controller?command=show_my_applications">${pageScope.show_my_applications}</a>
                 </li>
             </c:when>
         </c:choose>
    </ul>
</div>
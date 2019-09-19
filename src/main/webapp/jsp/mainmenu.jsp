<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/lib/css/font-awesome.min.css">

<fmt:bundle basename="page_content">
    <fmt:message key="menu.create_training_program" var="create_training_program"/>
    <fmt:message key="menu.create_exercise" var="create_exercise"/>
    <fmt:message key="menu.show_personal_clients" var="show_personal_clients"/>
    <fmt:message key="menu.show_clients" var="show_clients"/>
    <fmt:message key="menu.find_client" var="find_client"/>
    <fmt:message key="menu.orders_history" var="orders_history"/>
    <fmt:message key="menu.my_training_program" var="my_training_program"/>
    <fmt:message key="menu.make_order" var="make_order"/>
    <fmt:message key="menu.change" var="change"/>
    <fmt:message key="menu.language" var="language"/>
</fmt:bundle>

<div class="user_menu">
    <ul>
        <li><a href="${pageContext.request.contextPath}/jsp/index.jsp">Main</a></li>

        <li>
            <a href="${pageContext.request.contextPath}/controller?command=show_all_faculties">${pageScope.show_clients}</a>
        </li>




    </ul>
</div>
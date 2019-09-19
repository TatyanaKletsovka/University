<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/header.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/lib/css/font-awesome.min.css">

<fmt:bundle basename="page_content">
    <fmt:message key="menu.title" var="title"/>
        <fmt:message key="menu.title" var="title"/>
        <fmt:message key="menu.hello_guest" var="hello_guest"/>
        <fmt:message key="menu.register" var="register"/>
</fmt:bundle>

<html>
    <head>
        <meta charset="UTF-8">
        <title>${pageScope.title}</title>
    </head>

    <body>
        <header class="header">
            <h1 class="top">${pageScope.title}</h1>
            <div class="change_level">
                <ul>
                    <li>
                        <a href="${pageContext.request.contextPath}/controller?command=common_change_language&locale=ru">RU</a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/controller?command=common_change_language&locale=en">EN</a>
                    </li>
                </ul>
            </div>

            <div class="hello_message">
                <span class="hello_text">${pageScope.hello_guest}</span>
                <a class="register_login_a"
                   href="${pageContext.request.contextPath}/jsp/register.jsp">${pageScope.register}</a>
            </div>
        </header>
    </body>
</html>

<%@ page isErrorPage="true" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">

<html><head><title>Error Page</title></head>
<body>
<div>
   <%@ include file="/jsp/common/header.jsp"%>
</div>

<div>
   <%@ include file="/jsp/common/mainMenu.jsp"%>
</div>
Request from ${pageContext.errorData.requestURI} is failed
<br/>
Servlet name or type: ${pageContext.errorData.servletName}
<br/>
Status code: ${pageContext.errorData.statusCode}
<br/>
Exception: ${pageContext.errorData.throwable}

<div>
    <%@ include file="/jsp/common/footer.jsp"%>
</div>
</body></html>
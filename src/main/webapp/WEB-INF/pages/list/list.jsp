<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<tag:layout>

    <div id="mainPage">
        <link href="${pageContext.request.contextPath}/resources/css/list.css" rel="stylesheet">
        <jsp:include page="header.jsp"/>
        <div class="container">
            <div style="margin-left: 15%; margin-right: 15%;">
                <div style="text-align: center">
                    <h2><b><spring:message code="messages.taskManager"/></b></h2>
                    <h4 style="margin-top: -10px; margin-bottom: 50px">FROM SOFTSERVE</h4>
                </div>
                <div style="text-align: center" id="lists">
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp"/>
    </div>
</tag:layout>

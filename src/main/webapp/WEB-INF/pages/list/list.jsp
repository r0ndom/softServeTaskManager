<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

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
                <jsp:include page="taskListView.jsp">
                    <jsp:param name="hidden" value="hidden"/>
                </jsp:include>
                <div id="lists">
                    <c:forEach var="list" items="${listArray}">
                        <c:set var="listName" value="${list.name}"/>
                        <c:set var="listId" value="${fn:replace(listName, ' ', '_')}" scope="request"/>
                        <c:set var="listTasks" value="${list.tasks}" scope="request"/>
                        <jsp:include page="taskListView.jsp">
                            <jsp:param name="listId" value="${listId}"/>
                            <jsp:param name="listName" value="${list.name}"/>
                        </jsp:include>
                    </c:forEach>
                </div>
                <div style="text-align: center; margin-top: 50px; margin-bottom: 90px">
                    <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#taskListModal">
                        <span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;Add TODO List
                    </button>
                </div>
                <jsp:include page="modals/createNewTaskList.jsp"/>
                <jsp:include page="modals/editTaskList.jsp"/>
                <jsp:include page="modals/deleteTaskList.jsp"/>
                <jsp:include page="modals/editTask.jsp"/>
                <jsp:include page="modals/deleteTask.jsp"/>
            </div>
        </div>
        <jsp:include page="footer.jsp"/>
    </div>
</tag:layout>

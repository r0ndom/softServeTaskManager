<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div <c:choose>
        <c:when test="${param.listId != null}">
            id="<c:out value="${param.listId}"/>List"
        </c:when>
        <c:otherwise>
            id="taskListView"
        </c:otherwise>
    </c:choose>
    class="panel panel-default" ${param.hidden}>
    <div class="panel-heading divWithHidden" style="background-color: #337ab7; border-color: #2e6da4; color: #ffffff; padding-top: 10px; padding-bottom: 20px">
        <div style="text-align: right;">
            <h4 style="float: left">
                <span class="glyphicon glyphicon-list-alt" style="padding-right: 10px;" aria-hidden="true"></span>
                <span id="listName"><c:out value="${param.listName}"/></span>
            </h4>
            <button id="editButton" data-id="${param.listName}" class="submitButton hiddenButton" style="padding-top: 12px"
                    data-toggle="modal" data-target="#editTaskListModal">
                <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
            </button>
            <button id="deleteButton" data-id="${param.listName}" class="submitButton hiddenButton" style="padding-top: 12px"
                    data-toggle="modal" data-target="#deleteTaskListModal">
                <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
            </button>
        </div>
    </div>
    <div class="panel-body" style="background-color: #dcdcdc">
        <div style="min-width: 40px">
        <span class="glyphicon glyphicon-plus" aria-hidden="true" style="color: #588f71; font-size: 1.7em; padding-right: 10px; padding-top: 3px; float: left"></span>
        </div>
        <div class="input-group">
            <div id="inputNewTaskGroup">
                <input type="text" id="newTaskNameFor${param.listId}" name="name"
                    class="form-control" placeholder="Start typing here to create a task">
            </div>
            <span class="input-group-btn">
                <button class="btn btn-default" style="background-color: #70a789; padding-left: 30px; padding-right: 25px; color: #ffffff;"
                        id="addNewTaskButton" type="button">Add task</button>
            </span>
        </div>
    </div>

    <table class="table table-bordered">
        <tbody>
            <jsp:include page="tableContent.jsp">
                <jsp:param name="hidden" value="hidden"/>
            </jsp:include>
            <c:forEach var="task" items="${requestScope.listTasks}">
                <c:set var="taskName" value="${task.name}"/>
                <c:set var="taskId" value="${fn:replace(taskName, ' ', '_')}" />
                <jsp:include page="tableContent.jsp">
                    <jsp:param name="taskId" value="${taskId}"/>
                    <jsp:param name="taskName" value="${task.name}"/>
                    <jsp:param name="taskDeadline" value="${task.deadline}"/>
                </jsp:include>
            </c:forEach>
        </tbody>
    </table>
</div>


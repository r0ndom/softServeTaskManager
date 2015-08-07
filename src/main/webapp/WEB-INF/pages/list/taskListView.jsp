<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<div class="panel panel-default" id="List">
    <div class="panel-heading divWithHidden" style="background-color: #337ab7; border-color: #2e6da4; color: #ffffff; padding-top: 10px; padding-bottom: 20px">
        <div style="text-align: right;">
            <h4 style="float: left">
                <span class="glyphicon glyphicon-list-alt" style="padding-right: 10px;" aria-hidden="true"></span>
                <span id="listName">Tasks</span>
            </h4>
            <div style="padding-top: 25px"></div>
        </div>
    </div>
    <div class="panel-body" style="background-color: #dcdcdc">
        <div style="min-width: 40px">
        <span class="glyphicon glyphicon-plus" aria-hidden="true" style="color: #588f71; font-size: 1.7em; padding-right: 10px; padding-top: 3px; float: left"></span>
        </div>
        <div class="input-group">
            <input type="text" id="createTaskName" name="name"
                   class="form-control" style="width: 70%" placeholder="Start typing here to create a task">
            <input id="createTaskDeadline" name="deadline"
                   class="form-control" style="width: 30%" placeholder="Choose deadline">
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
            <c:forEach var="task" items="${tasks}">
                <jsp:include page="tableContent.jsp">
                    <jsp:param name="taskId" value="${task.id}"/>
                    <jsp:param name="taskName" value="${task.name}"/>
                    <jsp:param name="taskDeadline" value="${task.deadline}"/>
                </jsp:include>
            </c:forEach>
        </tbody>
    </table>
</div>


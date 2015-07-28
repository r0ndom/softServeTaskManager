<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tr <c:choose>
    <c:when test="${param.taskId != null}">
        id="${requestScope.listId}:${param.taskId}Task"
    </c:when>
    <c:otherwise>
        id="task"
    </c:otherwise>
</c:choose> class="controlLabels" ${param.hidden}>
    <div class="row">
        <td id="taskName" class="col-md-10" style="padding-top: 20px; padding-bottom: 20px; font-size: 10pt; vertical-align: middle;">
            ${param.taskName}
        </td>
        <td class="col-md-2" style="padding-top: 20px; padding-bottom: 20px; font-size: 10pt; vertical-align: middle;">
            <span id="taskDeadline" class="hideLabels col-md-2" style="text-align: center; font-weight: normal">${param.taskDeadline}</span>
            <div class="showLabels" style="text-align: center">
                <button id="editTask" data-id="${param.taskName}" class="submitButton hiddenLabel"
                        data-toggle="modal" data-target="#editTaskModal">
                    <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                </button>
                <button id="deleteTask" data-id="${param.taskName}" class="submitButton hiddenLabel"
                        data-toggle="modal" data-target="#deleteTaskModal">
                    <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                </button>
            </div>
        </td>
    </div>
</tr>
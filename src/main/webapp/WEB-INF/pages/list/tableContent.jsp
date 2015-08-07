<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<tr <c:choose>
    <c:when test="${param.taskId != null}">
        id=${param.taskId}
    </c:when>
    <c:otherwise>
        id="task"
    </c:otherwise>
</c:choose> class="controlLabels" ${param.hidden}>
    <div class="row">
        <td class="col-md-10" style="padding-top: 20px; padding-bottom: 20px; font-size: 10pt; vertical-align: middle;">
            <span id="taskName">${param.taskName}</span>
        </td>
        <td class="col-md-2" style="padding-top: 20px; padding-bottom: 20px; font-size: 10pt; vertical-align: middle;">
            <span id="taskDeadline" class="hideLabels col-md-2" style="font-weight: normal; width: 200%">${param.taskDeadline}</span>
            <div class="showLabels" style="text-align: center">
                <button id="editTask" data-id="${param.taskId}" class="submitButton hiddenLabel"
                        data-toggle="modal" data-target="#editTaskModal">
                    <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                </button>
                <button id="deleteTask" data-id="${param.taskId}" class="submitButton hiddenLabel"
                        data-toggle="modal" data-target="#deleteTaskModal">
                    <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
                </button>
            </div>
        </td>
    </div>
</tr>
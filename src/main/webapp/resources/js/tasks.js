$( document ).ready(function() {
    $( "tbody" ).sortable().disableSelection();
    $("#newDeadline").datepicker({minDate: 0, dateFormat: "yy-mm-dd"});
    $("#createTaskDeadline").datepicker({minDate: 0, dateFormat: "yy-mm-dd"});
});

$(document).on("click", "#addNewTaskButton", function () {
    var taskName = $("#createTaskName").val();
    var deadline = $("#createTaskDeadline").val();
    if (checkString(taskName)) {
        createTask(taskName, deadline);
    }
});
function createTask(taskName, deadline) {
    $.ajax({
        url: "/list/createTask/",
        method: "POST",
        data: JSON.stringify({name: taskName, deadline: deadline}),
        dataType: 'text',
        contentType: 'application/json',
        success: function(id) {
            createTaskView(id, taskName, deadline);
        }
    });
}
function createTaskView(id, taskName, deadline) {
    $("#createTaskName").val("");
    $("#createTaskDeadline").val("");
    var td = $("#task").clone();
    td.attr("id", id);
    td.find("#taskName").text(taskName);
    td.find("#taskDeadline").text(deadline);
    $("#List").find(".table").append(td);
    td.show();
}

$(document).on("click", "#editTask", function () {
    var id = $(this).data('id');
    $("#editTaskNameHidden").text(id);
    $("#editTaskModal").modal('show');
});
function editTask() {
    $("#editTaskModal").modal('hide');
    var name = $("#newTaskName").val();
    var deadline = $("#newDeadline").val();
    var id = $("#editTaskNameHidden").text();
    $.ajax({
        url: "/list/editTask/",
        method: "POST",
        data: JSON.stringify({"name": name, "deadline": deadline, "id":id}),
        contentType : 'application/json; charset=utf-8',
        success: editTaskView(id, name, deadline)
    });
}
function editTaskView(id, taskName, taskDeadline) {
    var tableData = $('#'+id).closest("tr");
    tableData.find('#taskName').text(taskName);
    tableData.find('#taskDeadline').text(taskDeadline);
    tableData.find('#editTask').attr("data-id", id);
    tableData.find('#deleteTask').attr("data-id", id);
}
$(document).on("click", "#deleteTask", function () {
    var id = $(this).data('id');
    $("#deleteTaskId").text(id);
    $("#deleteTaskModal").modal('show');
});
function deleteTask() {
    $("#deleteTaskModal").modal('hide');
    var id = $("#deleteTaskId").text();
    $.ajax({
        url: "/list/deleteTask/" + id,
        method: "POST",
        success: deleteTaskView(id)
    });
}
function deleteTaskView(id) {
    var tableData = $('#'+id).closest("tr");
    tableData.remove();
}
function checkString(str) {
    if (str.length == 0) {
        return false;
    }
    var count = 0;
    for (var i = 0; i < str.length; i++) {
        if (str.charAt(i) == " ") {
            count++;
        }
    }
    if (count == str.length) {
        return false;
    } else {
        return true;
    }
}



$( document ).ready(function() {
    $( "tbody" ).sortable().disableSelection();
    $("#newDeadline").datepicker({minDate: 0, dateFormat: "yy-mm-dd"});
});

$(document).on("click", "#addNewTaskButton", function () {
    var temp = $(this).closest('.panel-default').attr('id');
    var listName = temp.substr(0, temp.length - 4);
    var taskName = $("#newTaskNameFor" + listName.replace(/ /g, "_")).val();
    if (checkString(taskName)) {
        createTask(listName, taskName);
    }
});
function createTask(listName, taskName) {
    $.ajax({
        url: "/list/createTask/",
        method: "POST",
        data: {listName: listName.replace(/_/g, " "), name: taskName},
        success: createTaskView(listName, taskName)
    });
}
function createTaskView(listName, taskName) {
    $("#newTaskNameFor" + listName).val("");
    var td = $("#task").clone();
    td.attr("id", listName + "/" + taskName.replace(/ /g, "_") + "Task");
    td.find("#taskName").text(taskName);
    $("#" + listName + "List").find(".table").append(td);
    td.show();
}

$(document).on("click", "#editTask", function () {
    var temp = $(this).closest('.panel-default').attr('id');
    var listName = temp.substr(0, temp.length - 4);
    var oldName = $(this).data('id');
    $("#editListNameHidden").text(listName.replace(/_/g, " "));
    $("#editTaskNameHidden").text(oldName);
    $("#editTaskModal").modal('show');
});
function editTask() {
    var name = $("#editTaskForm").find("#newTaskName").val();
    var deadline = $("#editTaskForm").find("#newDeadline").val();
    var listName = $("#editListNameHidden").text();
    var taskName = $("#editTaskNameHidden").text();
    var task = {
        'name' : name,
        'deadline' : deadline
    };
    $.ajax({
        url: "/list/editTask/",
        method: "POST",
        data: JSON.stringify({"listName": listName, "oldName": taskName, "task": task}),
        contentType : 'application/json; charset=utf-8',
        dataType : 'json',
        success: editTaskView(listName, taskName, name, deadline)
    });
}
function editTaskView(listName, oldName, taskName, taskDeadline) {
    var template = listName.replace(/ /g, "_") + ":";
    var id = template + oldName.replace(/ /g, "_") + "Task";
    var newId = template + taskName.replace(/ /g, "_") + "Task";
    var tableData = $("#" + id);
    tableData.attr("id", newId);
//    tableData.find('#taskName').text(taskName);
//    tableData.find('#taskDeadline').text(taskDeadline);
//    tableData.find('#editTask').attr("data-id", taskName);
//    tableData.find('#deleteTask').attr("data-id", taskName);
}
$(document).on("click", "#deleteTask", function () {

});
function deleteTask(listName, taskName) {

}
function deleteTaskView(listName, taskName) {

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



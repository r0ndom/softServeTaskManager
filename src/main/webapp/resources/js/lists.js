function createList() {
    var data = $("#inputGroup :input").serialize();
    var name = document.getElementById("listNameInput").value;
    $.ajax({
        url: "/list/createList/",
        method: "POST",
        data: data,
        success: addDivForList(name)
    });
    document.getElementById("listNameInput").value = "";
    $('#taskListModal').modal('hide');
}

function addDivForList(name) {
    var div = $("#taskListView").clone();
    div.attr("id", name.replace(/ /g, "_") + "List");
    div.find("#listName").text(name);
    div.find("#newTaskNameFor").attr("id", "newTaskNameFor" + name.replace(/ /g, "_"));
    div.find(".submitButton").attr("data-id", name);
    div.show();
    $("#lists").prepend(div);
}
$(document).on("click", "#editButton", function () {
    var oldName = $(this).data('id');
    $("#oldName").text(oldName);
    $('#editTaskListModal').modal('show');
});
function editListName() {
    var oldName = $("#oldName").text();
    var newName = $("#newListName").val();
    $.ajax({
        url: "/list/editList/",
        method: "POST",
        data: {oldName: oldName, newName: newName},
        success: editDivName(oldName, newName)
    });
    $("#newListName").val("");
    $('#editTaskListModal').modal('hide');
}
function editDivName(oldName, newName) {
    var div = $("#" + oldName.replace(/ /g, "_") + "List");
    div.attr("id", newName.replace(/ /g, "_") + "List");
    div.find("#listName").text(newName);
    div.find(".submitButton").attr("data-id", newName);
}
$(document).on("click", "#deleteButton", function () {
    var name = $(this).data('id');
    $("#deleteListName").text(name);
    $('#deleteTaskListModal').modal('show');
});
function deleteList() {
    var name = $("#deleteListName").text();
    $.ajax({
        url: "/list/deleteList/",
        method: "POST",
        data: {name: name},
        success: deleteDivList(name)
    });
}
function deleteDivList(name) {
    var div = $("#" + name.replace(/ /g, "_") + "List");
    div.remove();
    $('#deleteTaskListModal').modal('hide');
}
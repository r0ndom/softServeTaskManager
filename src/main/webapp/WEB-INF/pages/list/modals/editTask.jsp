<div class="modal fade" id="editTaskModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Edit task list</h4>
            </div>
            <span id="editListNameHidden" hidden="hidden"></span>
            <span id="editTaskNameHidden" hidden="hidden"></span>
            <form onsubmit="editTask()">
            <div class="modal-body" id="editTaskForm">
                <div class="row">
                    <div class="col-md-5">
                        <label for="newTaskName" style="padding-top: 10px">Enter new task name:</label>
                    </div>
                    <div class="col-md-7">
                        <input class="form-control" id="newTaskName" required="required"/>
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="col-md-5">
                        <label for="newDeadline" style="padding-top: 10px">Select deadline:</label>
                    </div>
                    <div class="col-md-7">
                        <input class="form-control" id="newDeadline"/>
                    </div>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <button type="submit" class="btn btn-primary"> Save changes</button>
            </div>
            </form>
        </div>
    </div>
</div>

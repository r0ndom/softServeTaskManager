<div class="modal fade" id="taskListModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Create new task list</h4>
            </div>
            <form onsubmit="createList()">
            <div class="modal-body">
                <div class="row">
                    <div class="col-md-4">
                        <label style="padding-top: 10px">Enter task list name:</label>
                    </div>
                    <div class="col-md-8" id="inputGroup">
                        <input class="form-control" id="listNameInput" name="name" required="required"/>
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
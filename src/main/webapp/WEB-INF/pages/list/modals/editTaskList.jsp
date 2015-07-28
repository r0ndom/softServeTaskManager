<div class="modal fade" id="editTaskListModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Edit task list</h4>
            </div>
            <form onsubmit="editListName()">
            <div class="modal-body">
                <label>Old name: </label>
                <span id="oldName"></span>
                <div class="row">
                    <div class="col-md-5">
                        <label for="newListName" style="padding-top: 10px">Enter new task list name:</label>
                    </div>
                    <div class="col-md-7">
                        <input class="form-control" id="newListName" required="required"/>
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

<div class="modal fade" id="deleteTaskListModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Delete task list</h4>
            </div>
            <div class="modal-body">
                <span>Are you sure?</span>
                <span id="deleteListName" hidden="hidden"></span>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">No</button>
                <button type="button" class="btn btn-primary" onclick="deleteList()"> Yes</button>
            </div>
        </div>
    </div>
</div>


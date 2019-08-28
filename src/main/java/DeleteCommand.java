/**
 * Represent user command to delete tasks from their task list.
 */

public class DeleteCommand extends Command {

    protected int index;

    /**
     * Represents an action to delete task using the index in their task list.
     * @param command Type of task
     * @param index Task Index on their task list
     */
    public DeleteCommand(String command, int index) {
        super(command);
        this.index = index;
    }

    public int getIndex() {
        return this.index - 1;
    }

    public void execute(TaskList tasks, UI ui, Storage storage) throws DukeException {
        //check if the index is out of bound
        if (this.getIndex() < tasks.getTaskCount()) {
            Task deletedTask = tasks.getTask(this.getIndex());
            tasks.deleteTask(this.getIndex());
            ui.showDeleteMessage(deletedTask, tasks);
        } else {
            throw new DukeException("☹ Index is not within the list. Please enter a index within the list.");
        }
    }

    public boolean isExit() {
        return false;
    }
}

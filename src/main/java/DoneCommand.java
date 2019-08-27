public class DoneCommand extends Command {

    protected int index;

    public DoneCommand(String command, int index) {
        super(command);
        this.index = index;
    }

    public int getIndex() {
        return this.index - 1;
    }

    public void execute(TaskList tasks, UI ui, Storage storage) throws DukeException {
        //check if the index is out of bound
        if (this.getIndex() < tasks.getTaskCount()) {
            Task doneTask = tasks.getTask(this.getIndex());
            tasks.markTaskDone(this.getIndex());
            ui.showDoneMessage(doneTask);
        } else {
            throw new DukeException("☹ Index is not within the list. Please enter a index within the list.");
        }
    }

    public boolean isExit() {
        return false;
    }
}

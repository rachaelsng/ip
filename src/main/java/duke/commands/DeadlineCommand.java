package duke.commands;

import duke.*;
import duke.task.Deadline;

public class DeadlineCommand extends Command {
    private final String input;

    public DeadlineCommand(String input) {
        this.input = input;
    }

    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        if (input.isBlank()) {
            throw new DukeException("Hold up! Description cannot be empty!");
        }

        String[] str = input.split(" /by ", 2);
        if (str.length < 2 || str[1].trim().length() == 0) {
            throw new DukeException("Wait! When is the deadline??");
        }
        Deadline newDeadline = new Deadline(str[0], str[1]);

        taskList.addTask(newDeadline);
        ui.showAddTask(newDeadline, taskList);
    }

    public boolean isExit() {
        return false;
    }
}
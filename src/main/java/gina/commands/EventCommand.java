package gina.commands;

import gina.GinaException;
import gina.Storage;
import gina.TaskList;
import gina.Ui;
import gina.task.Event;

/**
 * Represents a command to create an event.
 */
public class EventCommand extends Command {
    private final String input;

    /**
     * Constructs a command to create a new event with the specified input.
     *
     * @param input The specified user input.
     */
    public EventCommand(String input) {
        this.input = input;
        assert(input != null);
    }

    /**
     * {@inheritDoc}
     */
    public String execute(TaskList taskList, Ui ui, Storage storage) throws GinaException {
        if (input.isBlank()) {
            throw new GinaException("Hold your horses! Description can't be empty!");
        }

        String[] str = input.split(" /at ", 2);
        if (str.length < 2 || str[1].trim().length() == 0) {
            throw new GinaException("Wait! When is this event??");
        }
        Event newEvent = new Event(str[0], str[1]);

        taskList.addTask(newEvent);
        storage.save(taskList);
        return ui.showAddTask(newEvent, taskList);
    }

    /**
     * {@inheritDoc}
     */
    public boolean isExit() {
        return false;
    }
}
package gina;

import gina.task.Task;
import java.util.ArrayList;

/**
 * Contains and manages the list of tasks
 */
public class TaskList {
    private ArrayList<Task> tasks;

    /**
     * Constructs an empty task list
     */
    public TaskList() {
        tasks = new ArrayList<>();
    }

    /**
     * Constructs a task list containing the specified tasks
     *
     * @param tasks The specified tasks
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
        assert(tasks != null);
    }

    /**
     * Returns the task at the specified index.
     *
     * @param i Index of the task in the task list.
     * @return Task at the specified index.
     * @throws GinaException If index is out of bounds.
     */
    public Task get(int i) throws GinaException {
        try {
            return tasks.get(i);
        } catch (IndexOutOfBoundsException e) {
            throw new GinaException("Please enter a valid task number!");
        }
    }

    /**
     * Returns the size of the task list.
     *
     * @return Size of task list.
     */
    public int size() {
        return tasks.size();
    }

    /**
     * Converts an ArrayList of Tasks to a list as a String.
     *
     * @param tasks List of tasks.
     * @return List of tasks as a string.
     */
    public static String convertTasksToListString(ArrayList<Task> tasks) {
        assert(tasks != null);
        StringBuilder list = new StringBuilder();
        for (int i = 0; i < tasks.size(); i++) {
            String newLine = (i + 1) + ". " + tasks.get(i).toString() + "\n";
            list.append(newLine);
        }
        return list.toString();
    }

    /**
     * Adds task to task list.
     *
     * @param task The specified task.
     */
    public void addTask(Task task) {
        assert(task != null);
        tasks.add(task);
    }

    /**
     * Deletes the specified task from task list.
     *
     * @param index The index of the specified task in the list.
     * @return Deleted task.
     * @throws GinaException If index is out of bounds.
     */
    public Task deleteTask(int index) throws GinaException {
        try {
            return tasks.remove(index);
        } catch (IndexOutOfBoundsException e) {
            throw new GinaException("I can't find such a task to delete!");
        }
    }

    /**
     * Returns a task list with tasks on the specified date.
     *
     * @param dateStr The specified date.
     * @return List of tasks with specified date.
     * @throws GinaException If date is blank or in the wrong format.
     */
    public TaskList getTasksOnDate(String dateStr) throws GinaException {
        ArrayList<Task> tasksOnDate = new ArrayList<>();
        for (Task t : tasks) {
            if (t.isOnThisDate(dateStr)) {
                tasksOnDate.add(t);
            }
        }
        return new TaskList(tasksOnDate);
    }

    public TaskList getTasksWithWord(String input) throws GinaException {
        ArrayList<Task> tasksWithWord = new ArrayList<>();
        for (Task t : tasks) {
            if (t.doesDescriptionContain(input)) {
                tasksWithWord.add(t);
            }
        }
        return new TaskList(tasksWithWord);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return convertTasksToListString(tasks);
    }
}
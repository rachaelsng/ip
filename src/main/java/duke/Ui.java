package duke;

import java.util.Scanner;

import duke.task.Task;

/**
 * Deals with interactions with the user
 */
public class Ui {
    /**
     * Returns the word with the correct plural or singular form
     *
     * @param taskList The list of tasks
     * @return The word with the correct plural or singular form
     */
    private static String showTaskTense(TaskList taskList) {
        return taskList.size() == 1 ? " task" : " tasks";
    }

    /**
     * Displays greeting
     */
    public String showGreeting() {
        return "Hi there! I'm Duke\n What's up?\n";
    }

    /**
     * Displays exit message
     */
    public String showExit() {
        return "Bye. Hope to see you again soon!";
    }

    /**
     * Displays error message
     *
     * @param message The error message
     */
    public String showError(String message) {
        return message;
    }

    /**
     * Displays added task message for the specified task
     *
     * @param task The specified task
     * @param taskList The list of tasks
     */
    public String showAddTask(Task task, TaskList taskList) {
        return "Got it. I've added this task:\n"
                + "  " + task.toString()
                + "\nNow you have " + taskList.size()
                + showTaskTense(taskList) + " in the list.";
    }

    /**
     * Displays the deleted task message for the specified task
     *
     * @param task The specified task
     * @param taskList The list of tasks
     */
    public String showDeleteTask(Task task, TaskList taskList) {
        return "Done! " + task.toString()
                + " has been deleted :(" + "\nNow you have " + taskList.size()
                + showTaskTense(taskList) + " left.";
    }

    /**
     * Displays the marked task message for the specified task
     *
     * @param task The specified task
     */
    public String showMarkedTask(Task task) {
        return "Good job!\n I've marked this task as done:\n" + task.toString();
    }

    /**
     * Displays the unmarked task message for the specified task
     *
     * @param task The specified task
     */
    public String showUnmarkedTask(Task task) {
        return "OK, I've marked this task as not done yet:\n" + task.toString();
    }

    /**
     * Displays the specified task list
     *
     * @param taskList The specified task list
     */
    public String showTaskList(TaskList taskList) {
        String list;
        if (taskList.size() == 0) {
             list = "Nothing to do right now...";
        } else {
             list = "Tasks: \n" + taskList;
        }
        list += "\nYou have " + taskList.size()
                + showTaskTense(taskList) + "!";
        return list;
    }

    /**
     * Displays the list of tasks on a specified date
     *
     * @param taskList The list of tasks on a specified date
     * @param dateStr The specified date
     */
    public String showTasksOnDate(TaskList taskList, String dateStr) {
        if (taskList.size() != 0) {
            return "These are the tasks on "
                    + dateStr + ":\n" + taskList
                    + "\nYou have " + taskList.size()
                    + showTaskTense(taskList) + " on " + dateStr + ".";
        } else {
            return "There are no tasks on this date!";
        }
    }

    /**
     * Displays the list of tasks with the relevant keyword if there are matches.
     *
     * @param taskList The list of tasks with the keyword.
     * @param input The keyword.
     */
    public String showFindings(TaskList taskList, String input) {
        if (taskList.size() != 0) {
            return "I found " + taskList.size() + showTaskTense(taskList)
                    + " for \"" + input + "\":\n" + taskList
                    + "\nDid you find what you were looking for?";
        } else {
            return "I couldn't find any tasks for \""
                    + input + "\""
                    + "\nPerhaps try another word!";
        }
    }
}

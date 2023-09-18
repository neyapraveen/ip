package duke;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The `Ui` class handles user interface interactions and provides methods
 * for displaying messages and reading user input.
 */
public class Ui {

    /**
     * A horizontal line used for separating messages.
     */
    public static String horizontalLine = "_".repeat(60) + "\n";

    /**
     * Displays a greeting message when the program starts.
     */
    public static void greet() {
        System.out.println("Hello! I'm Bot\n"
                + "What can I do for you?\n" + horizontalLine);
    }

    /**
     * Displays a farewell message when the program exits.
     */
    public static void sayBye() {
        System.out.println(horizontalLine
                + "Bye. Hope to see you again soon!\n" + horizontalLine);
    }

    /**
     * Displays an error message.
     *
     * @param errorMessage The error message to be displayed.
     */
    public static void showError(String errorMessage) {
        System.err.println(errorMessage);
    }

    /**
     * Reads a command from the user via the provided Scanner.
     *
     * @param sc The Scanner object for reading user input.
     * @return The user's input as a String.
     */
    public static String readCommand(Scanner sc) {
        return sc.nextLine();
    }
    
    public static String displaySearchResults(TaskList taskList, String keyword) {
        List<Task> allTasks = taskList.getTasks();
        if (allTasks.isEmpty()) {
            return (horizontalLine + "You have no tasks in your list.\n"
                    + horizontalLine);
        }

        TaskList filteredList = new TaskList();
        for (Task task : allTasks) {
            if (task.contains(keyword)) {
                filteredList.addTask(task);
            }
        }

        if (filteredList.getTasks().isEmpty()) {
            return (horizontalLine
                    + "You have no matching tasks in your list.\n"
                    + horizontalLine);
        }

//        System.out.println(horizontalLine + "Here are the matching items in your list: \n");
//        int count = 0;
//        for (Task t : filteredList.getTasks()) {
//            System.out.println(++count + ". " + t.toString());
//        }
//        System.out.println("\n" + horizontalLine);
        StringBuilder formattedItems = new StringBuilder();
        formattedItems.append(horizontalLine).append("Here are the matching items in your list: \n");

        int count = 0;
        for (Task t : filteredList.getTasks()) {
            formattedItems.append(++count).append(". ").append(t.toString()).append("\n");
        }

        formattedItems.append("\n").append(horizontalLine);
        return formattedItems.toString();
    }

}

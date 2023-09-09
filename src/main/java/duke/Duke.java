package duke;

import java.util.List;
import java.util.Scanner;

/**
 * The Duke class is the main class of the Duke chatbot application.
 * It initializes the application and interacts with the user
 * through the command-line interface.
 */
public class Duke {

    /**
     * The TaskList that stores the tasks in the application.
     */
    public static TaskList taskList = new TaskList();



    /**
     * The main method of the Duke chatbot application.
     *
     * @param args The command-line arguments (not used in this application).
     * @throws DukeException If there is an issue with Duke's operation.
     */
    public static void main(String[] args) {
        // Create the data location for storing task data
        Storage storage = new Storage();
        Storage.createDataLocation();
        // Load tasks from the data file into the TaskList
        storage.loadTasksFromFile(taskList);
        List<Task> allTasks = taskList.getTasks();
        // Create a scanner to read user input
        Scanner sc = new Scanner(System.in);
        // Create a parser to process user commands
        Parser parser = new Parser();
        // Create a user interface
        Ui ui = new Ui();
        if (allTasks.size() == 0) {
            parser.run = 1;
        }
        String task = "";
        ui.greet();
        System.out.flush();
        parser.parse(sc);
        ui.sayBye();
    }
}




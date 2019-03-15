package artykova.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.*;

public class Menu {

    Project pr;
    TaskList tasks = new TaskList();

    Scanner in =  new Scanner(System.in);



    public void setMenu() {
        System.out.println();
        load();
        int choice = 1;
        while (choice != 0) {
            System.out.println();
            System.out.println(">> Welcome to TO-DO List");
            System.out.println("==========================================");
            System.out.println(">> You have " + countedByStatus()[0] + " task TODO and " + countedByStatus()[1] + " task DONE!");
            System.out.println("==========================================");
            System.out.println(">>  Pick an option: ");
            System.out.println();
            System.out.println(">>  1 - Show Task List (by date, by project)"); // by date or project not done yet
            System.out.println(">>  2 - Add New Task");
            System.out.println(">>  3 - Edit Task (update, mark as done)"); // not done yet
            System.out.println(">>  4 - Remove Task");
            System.out.println(">>  0 - Save and Quit");
            System.out.println();
            System.out.println(">>  Enter your menu choice: ");

            try{
                String userInput = in.next();
                choice = Integer.parseInt(userInput);
            }catch( NumberFormatException nfe) {
                System.out.println(nfe.getMessage());
                System.out.println("user has inserted a non integer value") ;
            }

            try{
            switch (choice) {

                case 1: // Showing tasks
                    System.out.println();
                    System.out.println("You have " + tasks.getSize() + " tasks: ");
                    printList();
                    System.out.println();
                    System.out.println(">> 1. Show tasks ordered by project  >> 2. Show tasks ordered by date");
                    int show = in.nextInt();
                    if (show == 1) {
                        System.out.println("----------------------------------------------------------------");
                        printListOrderedByProject();
                    } else if (show == 2)
                        System.out.println("----------------------------------------------------------------");
                        printListOrderedByDate();
                    break;

                case 2: // Adding a task
                    try {
                    System.out.println("Enter date (YYYY-MM-DD) of the task: ");
                    LocalDate date = LocalDate.parse(in.next());

                    System.out.println("Enter project of the task: ");
                    Project project = new Project(in.next());

                    System.out.println("Enter title of the task: ");
                    String title = in.next();

                    Task n = new Task(date, false, project, title);

                    tasks.addTask(n);
                    System.out.println();
                    System.out.println("You have added a new task: " + n);
                    System.out.println("--------------------------------------------------------------------");
                    printList();
                    System.out.println();

                    } catch (Exception e){
                        System.out.println("Please, enter date in the correct format (YYYY-MM-DD)");
                    }
                    break;

                case 3: // Updating task or change status
                    printList();
                    System.out.println("Please, select your option: 1. Update task   2. Mark as done ");
                    int optionIs = in.nextInt();
                    System.out.println();
                    if (optionIs == 1) {
                        System.out.println("Select number of a task you want to update: ");
                        int index = in.nextInt();
                        updateTask(index);
                    } else if (optionIs == 2) {
                        System.out.println("Select number of a task you want to change: ");
                        int index = in.nextInt();
                        markAsDone(index);
                    } else {
                        System.out.println("You entered invalid option number ");
                    }
                    break;

                case 4: // Deleting task by a number
                    System.out.println();
                    System.out.println("--------------------------------------------------------------------");
                    printList();
                    System.out.println("Please, select number of the task you want to delete: ");
                    int taskIndex = in.nextInt();
                    removeTaskByIndex(taskIndex);
                    System.out.println("You have successfully deleted a task ");
                    printList();
                    break;

                case 0:
                    save(tasks);
                    System.out.println("Good bye!");
                    break;

                default:
                    System.out.println("Sorry, but " + choice + "is not one of " + "the menu choices. Please try again.");
                    break;
            }

            }catch(java.util.InputMismatchException ime){
                System.out.println("Sorry, but you must enter a number.");
                in.next();
            }
        }
    }

    private void updateTask(int index) {
        Task specTask = tasks.get(index-1);
        System.out.println(tasks.get(index-1));

        System.out.println("Enter the Date: ");
        String userInputDate = in.next();
        specTask.setDate(LocalDate.parse(userInputDate));

        System.out.println("Enter the Project:\n");
        String userInputProject = in.next();

        specTask.getProject().setName(userInputProject);

        System.out.println("Enter the Title:\n");
        String userInputTitle = in.next();
        specTask.setTitle(userInputTitle);
    }


    private void printListOrderedByDate() {
        Collections.sort(tasks);
        for (Task task: tasks) {
            System.out.println( task.getDate() + "\t " + task.getProject().getName() + "\t "
                    + task.getTitle() + "\t " + task.getStatus());
        }
    }

    private void printListOrderedByProject() {
        Collections.sort(tasks);
        for(Task task: tasks){
            System.out.println(task.getProject().getName() + "\t " + "\t "
                    + task.getDate() +"\t "+ task.getTitle() + "\t " + task.getStatus());
        }
    }

    private void markAsDone(int taskIndex) {
        tasks.get(taskIndex - 1).setStatus(true);
    }

    private void removeTaskByIndex(int taskIndex) {
        tasks.remove(taskIndex - 1);
    }

    private String constructTaskLine(Task menuTask) {
        String s = "Done";
        if(!menuTask.isStatus())
            s = "TODO";
        return ("\t " + menuTask.getDate() + "\t" + menuTask.getProject().getName() + "\t" + menuTask.getTitle() + "\t"  + s);
    }

    private void printList() { // List will starts from 1
        for (int index = 0; index < tasks.size(); index++) {
            System.out.println((index + 1) + constructTaskLine(tasks.get(index)));
        }
    }
    // Reporter that shows tasks counted by status in the menu title
    private int[] countedByStatus() {
        int[] counts = new int[2];
        int doneCount = 0;
        int toDoCount = 0;
        for (Task t : tasks) {
            if (t.isStatus()) {
                doneCount++;
            } else {
                toDoCount++;
            }
        }
        counts[0] = toDoCount;
        counts[1] = doneCount;
        return counts;
    }

    private void save(ArrayList<Task> list) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("taskList.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(list);
            objectOutputStream.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void load() {
        try {
            FileInputStream fileInputStream = new FileInputStream("taskList.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            tasks = (TaskList) objectInputStream.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
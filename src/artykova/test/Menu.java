package artykova.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    TaskList tasks = new TaskList();


    public void setMenu() {

        load();
        int choice = 1;
        while (choice != 0) {
            System.out.println();
            System.out.println(">> Welcome to TO-DO List");
            System.out.println("==========================================");
            System.out.println("You have X tasks todo and Y task are done!"); // stream filter not done yet
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

            Scanner in = new Scanner(System.in);
            choice = in.nextInt();
            in.nextLine();


            switch (choice) {

                case 1: // Showing a size of tasks NEED TO OPTIMIZE AND SIMPLIFY

                    System.out.println();
                    System.out.println("You have " + tasks.getSize() + " tasks: ");
                    System.out.println("Please, select your option: 1.Show tasks by date  2.Show tasks by project ");
                    int show = in.nextInt();
                    if(show == 1){
                        System.out.println("--------------------------------------------------------------------");
                        System.out.println("Num" + "\t" + "\t" + "Date" + "\t" + "\t" +  "Project"+ "\t" + "\t" + "Title"
                                                 + "\t" + "\t" +  "Status");
                        System.out.println();
                        printList();
                    } else if (show == 2){
                        System.out.println("--------------------------------------------------------------------");
                        System.out.println("Num" + "\t" + "\t" + "Project" + "\t" + "\t" + "Date" + "\t" + "\t" + "Title"
                                                 + "\t" + "\t" + "Status");
                    }

                    break;

                case 2: // Adding a task
                    System.out.println("Enter date (YYYY-MM-DD) of the task: ");
                    LocalDate date = LocalDate.parse(in.nextLine());

                    System.out.println("Enter project of the task: ");
                    Project project = new Project(in.nextLine());

                    System.out.println("Enter title of the task: ");
                    String title = in.nextLine();

                    Task n = new Task(date, false, project, title);

                    tasks.addTask(n);
                    System.out.println();
                    System.out.println("You have added a new task: " + n + "\t");
                    System.out.println("--------------------------------------------------------------------");
                    printList();
                    System.out.println();
                    break;

                case 3: //update task or change status
                    System.out.println("Please, select your option: 1.Update task  2.Mark as done ");
                    int optionIs = in.nextInt();
                    System.out.println("Please, select the number of the task: ");
                    int index = in.nextInt();

                    if(optionIs == 1){
                        updateTasks(index);
                    } else if (optionIs == 2){
                        markAsDone(index);
                    } else {
                        System.out.println("You entered invalid option number ");
                    }
                    break;

                case 4: // delete task by number
                    System.out.println();
                    System.out.println("-------------------------------------------------------");
                    printList();
                    System.out.println("Please, select number of the task you want to delete: ");
                    int taskIndex = in.nextInt();
                    removeTask(taskIndex);
                    System.out.println("You have successfully deleted a task ");
                    printList();
                    break;

                case 0:
                    save(tasks);
                    System.out.println("Good bye!");
                    break;

                default:
                    System.out.println("Sorry, but " + choice + " is not one of " +
                            "the menu choices. Please try again.");
                    break;
            }
        }
    }

    private void removeTask(int taskIndex) { //implementing numbering of tasks
        tasks.remove(taskIndex - 1);

    }

    private void markAsDone(int taskIndex) {
        tasks.get(taskIndex - 1).setStatus(true);
    }

    private void updateTasks(int taskIndex) { // option 3.1 = didn't finished yet
        tasks.get(taskIndex-1);
    }


    private String constructTaskLine(Task menuTask) {
        String s = "Done";
        if(!menuTask.isStatus())
            s = "TODO";
        return ("\t " + menuTask.getDate() + "\t" + menuTask.getProject().getName() + "\t" + menuTask.getTitle() +
                "\t"  + s);
    }


    private void printList() { // List will starts from 1
        for (int index = 0; index < tasks.size(); index++) {
            System.out.println((index + 1) + constructTaskLine(tasks.get(index)));
        }
    }


    private void save(ArrayList<Task> list) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("taskList");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(list);
            objectOutputStream.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void load() {
        try {
            FileInputStream fileInputStream = new FileInputStream("taskList");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            tasks = (TaskList) objectInputStream.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
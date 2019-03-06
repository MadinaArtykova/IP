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
                                                //print menu
        int m = 1;
        while (m != 0) {
            System.out.println();
            System.out.println(">> Welcome to TO-DO List");
            System.out.println("==========================================");
            System.out.println("You have X tasks todo and Y task are done!"); // stream filter
            System.out.println("==========================================");
            System.out.println();
            System.out.println(">>  Pick an option: ");
            System.out.println();
            System.out.println(">>  1 - Show Task List"); // by date or project (how?) filter
            System.out.println(">>  2 - Add New Task");
            System.out.println(">>  3 - Edit Task (update, mark as done)"); // how to do this?
            System.out.println(">>  4 - Remove Task");
            System.out.println(">>  0 - Save and Quit");
            System.out.println();
            System.out.println(">>  Enter your menu choice: ");

            Scanner in = new Scanner(System.in);
            int choice = in.nextInt();
            in.nextLine();


            switch (choice) {

                case 1: // Showing a size of tasks

                    System.out.println();
                    System.out.println("You have " + tasks.getSize() + " tasks. ");
                    System.out.println("---------------------------------------------");
                    System.out.println("Date \t Status \t Project \t Title");
                    System.out.println();
                    System.out.println("-------loading...----------------------------");
                        // print             date,  status,   project,  title      of all projects
                    System.out.println();

                    break;

                case 2: // Adding a task

                    System.out.println("Enter date (YYYY-MM-DD) of the task: ");
                    LocalDate date = LocalDate.parse(in.nextLine());

                    System.out.println("Enter project of the task: "); // Add task
                    Project project = new Project(in.nextLine());

                    System.out.println("Enter title of the task: ");
                    String title = in.nextLine();

                    Task n = new Task(date, false, project, title);

                    tasks.addTask(n);
                    System.out.println();
                    System.out.println("You have added a new task: " + n + "\t" );
                    System.out.println("---------------------------------------------------------------");
                    break;

                case 3:
                        // update task or change status
                    break;

                case 4: // delete last task or by index
                    System.out.println("Please, show the index of the task you want to delete: "); //please, add the list off tasks after deleting
                    in.nextLine();
                    tasks.remove();
                    System.out.println("You have successfully deleted a task ");
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

    public void save(ArrayList<Task> list){
        try{
            FileOutputStream fileOutputStream = new FileOutputStream("tasklist");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(list);
            objectOutputStream.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void load(){
        try{
            FileInputStream fileInputStream = new FileInputStream("tasklist");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            tasks = (TaskList) objectInputStream.readObject();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
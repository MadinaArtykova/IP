import java.time.LocalDate;
import java.util.Scanner;

public class Menu {


    public void setMenu() {

            //print menu
            int m = 1;
            while(m != 0) {
                System.out.println();
                System.out.println();
                System.out.println(">> Welcome to TO-DO List");
                System.out.println("==========================================");
                System.out.println("You have X tasks todo and Y task are done!"); // stream filter
                System.out.println("==========================================");
                System.out.println();
                System.out.println(">>  Pick an option: ");
                System.out.println();
                System.out.println(">>  1 - Show Task List"); //by date or project (how?) filter
                System.out.println(">>  2 - Add New Task");
                System.out.println(">>  3 - Edit Task (update, mark as done)");
                System.out.println(">>  4 - Remove Task");
                System.out.println(">>  0 - Save and Quit");

                Scanner in = new Scanner(System.in);
                System.out.println();
                System.out.println(">>  Enter your menu choice: ");
                String choice = in.nextLine();
                TaskList tasks = new TaskList();


                switch (choice) {

                    case "1":
                        if (choice.equals("1")) {
                            System.out.println(tasks.size()); //Show all tasks
                        }
                        break;

                    case "2":

                        if (choice.equals("2")) {

                            System.out.println("Enter date of the task: ");
                            LocalDate date = LocalDate.parse(in.nextLine());

                            System.out.println("Enter project of the task: "); // Add task
                            Project project = new Project(in.nextLine()) ;

                            System.out.println("Enter title of the task: ");
                            String title = in.nextLine();
                            //System.out.println("Set status for the task: ");

                            Task n = new Task(date, false, project, title);

                            tasks.addTask(n);
                            System.out.println();
                            System.out.println();
                            System.out.println("You have added a new task: " + n);
                            System.out.println("---------------------------------------------------------------");
                        }
                        break;

                    case "3":
                        // update task or change status
                        break;

                    case "4":
                        // delete task by index
                        break;

                    case "0":
                        // save(write list of tasks into a .txt file) and quit
                        break;

                    default:
                        // what is default?
                        break;

                 /*
                 WHY IS IT NOT WORKING?
                  */


                }
            }

     }
}
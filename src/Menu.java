//import java.util.ArrayList;
//import java.util.Random;
//import java.util.Scanner;
//
//public class ToDoList {
//    private static String[] menu; // this is a menu of tasks
//    private String answer;
//    private ArrayList<Task> tasks; // Task holder
//    private int count; // sum of added tasks
//
//
//    public ToDoList() {
//
//        // new empty Todo list
//
//        this.tasks = new ArrayList<>();
//        this.menu = new String[5];
//        this.count = 0;
//
//    }
//
//    public void addTask() {
//
//        Task task = new Task();
//
//        System.out.println(">Project");
//        Scanner scanner = new Scanner(System.in);
//        String project = scanner.nextLine();
//        task.setProject(project);
//
//        System.out.println(">Title");
//        String title = scanner.nextLine();
//        task.setTitle(title);
//
//        System.out.println(">Status");
//        String status = scanner.nextLine();
//        task.setStatus(status);
//
//        System.out.println(">Date");
//        String date = scanner.nextLine();
//        task.setDate(date);
//
//        if (tasks.size() == 0) {
//            task.setId(1);
//        } else {
//            task.setId(tasks.size() + 1);
//        }
//
//        tasks.add(task);
////        for (int i = 0; i < tasks.size(); i++) {
////            System.out.println(tasks.get(i).getTitle());
////        }
//
//    }
//
//    public static void setMenu() {
//
//        int choice = 1;
//        while (choice != 0) {
//            System.out.println();
//            System.out.println("Welcome to the TODO list");
//            System.out.println();
//            System.out.println("Please, select the option from the menu: ");
//            System.out.println();
//            System.out.println(">>>> 1 - Add new task");
//            System.out.println(">>>> 2 - Show task list");
//            System.out.println(">>>> 3 - Filter tasks");
//            System.out.println(">>>> 4 - Edit task");
//            System.out.println(">>>> 5 - Save and Quit");
//
//            Scanner scanner = new Scanner(System.in);
//            int answer = scanner.nextInt();
//
//            if (answer == 1) {
//
//
//
//            }
//
//            /*System.out.println("write name, date, time");
//            String fields = sc.nextLine();
//            "task1 january 23:00" --> ["task1", "januray", "23:00"]
//            array = ["task1", "januray", "23:00"]
//            tasks.add(new Task(array[0], array[1], getDate())); */
//            break;
//        }
//
//        //switch {}
//    /*
//
//        private String[] copyArray(String[] args, int from, int to) {
//        ArrayList<String> result = new ArrayList<String>();
//        for (int j = from; j != to; ++j) {
//        result.add(args[j]);
//        }
//        return result.toArray(new String[result.size()]);
//       }
//     */
//
//    }
//}

import java.time.LocalDate;

public class Main {


    public static void main(String[] args) {


        /*Task task = new Task("21.02.2019", "ToDo", 1, "Project 1", "hjkfdjksghjf" );
        System.out.println(task.getTitle());
        */


        TaskList a = new TaskList();


        a.addTask(new Task(LocalDate.parse("2010-12-12"), false, new Project("KTH"), "code"));
        a.addTask(new Task(LocalDate.parse("2010-12-12"), false, new Project("KTh"), "code"));

        System.out.println(a.size());
    }
}

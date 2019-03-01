import java.util.ArrayList;


public class TaskList extends ArrayList<Task> {

    public boolean addTask(Task newTask) {
        boolean successed = true;
        for (Task task : this) {
            if (task.equals(newTask)) {
                successed = false;
                System.out.println("Duplicate is not allowed.");
                return successed;
            }
        } this.add(newTask);
        return successed;
    }

    public int showTaskSize(){
        return showTaskSize();
    }
}

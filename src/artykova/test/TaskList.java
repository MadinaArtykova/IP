package artykova.test;
import java.io.Serializable;
import java.util.ArrayList;

public class TaskList extends ArrayList<Task> implements Serializable {

    public boolean status;

    @Override
    public Object clone() {
        return super.clone();
    }


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

    public int getSize(){

        return size();
    }

}

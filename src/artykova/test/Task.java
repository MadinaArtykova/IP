package artykova.test;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.function.IntFunction;

public class Task extends TaskList implements Serializable, Comparable<Task> {

    private LocalDate date;
    private boolean status;
    private Project project;
    private String title;


    public Task(LocalDate date, boolean status, Project project, String title) {

        this.date = date;
        this.status = status;
        this.project = project;
        this.title = title;
    }

    public LocalDate getDate() {

        return date;
    }

    public void setDate(LocalDate date) {

        this.date = date;
    }

    public boolean isStatus() {

        return status;
    }

    public void setStatus(boolean status) {

        this.status = status;
    }

    public Project getProject() {

        return project;
    }

    public void setProject(Project project) {

        this.project = project;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    @Override
    public String toString() {
        return this.title + " " + getStatus() + " " + this.project.getName() + " " + this.date;
    }

    @Override
    public <T> T[] toArray(IntFunction<T[]> generator) {
        return null;
    }

    @Override
    public boolean equals(Object obj){
        if (!(obj instanceof Task))
            return false;
        Task newTask = (Task) obj;
        return  newTask.title.equalsIgnoreCase(this.title) &&
                newTask.date.equals(this.date) &&
                newTask.project.equals(this.project) &&
                newTask.status == ((Task) obj).status;
    }

    @Override
    public int compareTo(Task otherTask) {
        return date.compareTo(otherTask.date);
    }

    public String getStatus() {
        if(status == true){
            return "Done";
        }
        else{
            return "TODO";
        }
    }
}




import java.io.Serializable;
import java.time.LocalDate;

public class Task implements Serializable {


    private LocalDate date;             // IF I put id number as a point to start writing tasks into a file
    private boolean status;             // I need new field named id or maybe date also be good for it..?
    private Project project;
    private String title;

    public Task(LocalDate date, boolean status, Project project, String title) {
        this.date = date;
        this.status = status;
        this.project = project;
        this.title = title;
    }

    public Task() {

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
        return this.title + " " + this.status + " " + this.project.getName() + " " + this.date;
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
}


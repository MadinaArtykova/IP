package artykova.test;

import java.io.Serializable;

public class Project implements Serializable {
    private String name;


    public Project(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object obj){
        if (obj instanceof Project){
            if (this.getName().equalsIgnoreCase(((Project) obj).getName())){
                return true;
            }
        }
        return false;
    }

}

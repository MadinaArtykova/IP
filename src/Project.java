public class Project {
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

    public void sameProject(){
        // here have to assign a same project if it is same as previous
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

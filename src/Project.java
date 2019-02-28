public class Project {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Project(String name) {
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

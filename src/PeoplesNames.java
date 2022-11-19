public class PeoplesNames {
    private String name;
    public PeoplesNames(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static PeoplesNames createNames(String name){
        return new PeoplesNames(name);
    }
}

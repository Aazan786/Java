
abstract public class Department {
    String Name;
    int id;

    public void setname(String name) {
        this.Name = name;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getname() {
        return getname();
    }

    public int getid() {
        return getid();
    }

    public Department() {
        System.out.println("Department default constructor");
    }

    public Department(String name, int id) {
        this.Name = name;
        this.id = id;
        System.out.println("Department parametrized constructor");
    }

    abstract public void show();

}

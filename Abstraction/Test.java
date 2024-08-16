import java.io.ObjectInputStream.GetField;

public class Test {
    public static void main(String[] args) {
        Teacher obj = new Teacher("Azan", 05);
        obj.setname("Azan khan");
        obj.setid(5);
        obj.show();

        Department ref = new Teacher();
        ref.setname("CS");
        ref.setid(8);
        System.out.println(ref.getname());
        System.out.println(ref.getid());
    }

}

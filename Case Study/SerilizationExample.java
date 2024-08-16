import java.io.*;

class users implements Serializable {
    public String Name;
    String Password;
    transient int Pin;

    public void Hello() {
        System.out.println("Name is " + Name);
    }
}

public class SerilizationExample {
    public static void main(String[] argv) {
        users obj = new users();
        obj.Name = "Azan Ali";
        obj.Password = "Abbottabad123";
        obj.Pin = 1234;

        try {
            FileOutputStream f = new FileOutputStream("Aazan.ser");
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(obj);

            o.close();
            f.close();

            System.out.println("Object Serilized");
        } catch (IOException e) {
            System.out.println(e);

        }

        try {
            FileInputStream in = new FileInputStream("Aazan.ser");
            ObjectInputStream on = new ObjectInputStream(in);
            obj = (users) on.readObject();
            in.close();
        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }

        System.out.println(obj.Name);
        System.out.println(obj.Password);
        System.out.println(obj.Pin);
    }
}

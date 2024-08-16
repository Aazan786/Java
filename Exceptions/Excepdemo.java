
import java.io.*;

class Base {
    public static void amethod() throws FileNotFoundException {
        System.out.println("amethod of the base class");
    }
}

public class Excepdemo extends Base {
    public static void main(String[] argv) {
        Excepdemo e = new Excepdemo();
    }

    public boolean amethod(int i) {
        try {
            System.out.println("Starting");
            System.out.println("Continuing");
            amethod(); // Removed "this." since amethod() is not an instance method
            return true;
        } catch (Exception e) {
            System.out.println("Exception");
        } finally {
            System.out.println("Doing finally");
        }
        return false;
    }

    Excepdemo() {
        amethod(99);
    }
}

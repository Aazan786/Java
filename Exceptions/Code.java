public class Code {
    public static void main(String[] argv) {
        try {
            System.out.println("A");
            System.out.println("Azan");
            int a = 10 / 0;

        }

        finally {
            System.out.println("B");
        }

        try {
            System.out.println("C");
        }

        finally {
            System.out.println("D");
        }

    }

}

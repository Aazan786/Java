class Cars {
    String name;
    int Model;
    static String company;

    public static void Hi() {
        System.out.println("Hi Azan");
    }

    public void show() {
        System.out.println(name + " " + Model + " " + company);
    }
}

public class Static {
    public static void main(String[] args) {
        Cars obj1 = new Cars();
        Cars obj2 = new Cars();
        obj1.name = "Honda";
        obj1.Model = 2023;

        obj2.name = "Vigo";
        obj2.Model = 2022;
        obj1.company = "Suzuki";

        Cars.Hi();
        obj1.show();
        obj2.show();
        obj1.Hi();
        obj2.Hi();

    }
}

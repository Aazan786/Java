class Parent {

    public Parent() {
        System.out.println("Parent Default constructor");
    }

    public Parent(int n) {
        System.out.println("Parent parametrixed constructor");
    }

}

class Child extends Parent {

    public Child() {
        System.out.println("child Default constructor");
    }

    public Child(int n) {
        super(4);
        System.out.println("Child parametrixed constructor");
    }

}

public class Super {
    public static void main(String[] args) {
        Child obj1 = new Child();
        Child obj = new Child(2);
    }
}

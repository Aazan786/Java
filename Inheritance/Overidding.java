import java.util.*;

class Circle {

    // declaring the instance variable
    protected double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

}

class Cylinder extends Circle {

    protected double length;

    public Cylinder(double radius, double length) {
        super(radius);
        this.length = length;
    }

    // method overriden here
    public double getArea() {
        return 2 * super.getArea() + 2 * Math.PI * radius * length;
    }

}

public class Overidding {
    public static void main(String[] args) {

        // Circle Class
        Circle myCircle = new Circle(1.20);
        System.out.println("Area of Circle is " + myCircle.getArea());

        // Cylinder Class
        Cylinder myCylinder = new Cylinder(1.20, 2.50);
        System.out.println("Area of Cylinder is " + myCylinder.getArea());

        // // UpCasting
        Circle myCircle1 = new Cylinder(1.20, 2.50);
        System.out.println("Upcasting.....");
        System.out.println("Area of Cylinder is " + myCircle1.getArea());

        // // DownCasting
        Circle myCircle2 = new Cylinder(1.20, 2.50);
        Cylinder myCylinder2;
        myCylinder2 = (Cylinder) myCircle2;

    }

}

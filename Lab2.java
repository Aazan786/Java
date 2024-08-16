
//import java.lang.*;
import java.util.*;

class shape {
	double radius, length, height;

	shape(double r, double a, double h) {
		this.radius = r;
		this.length = a;
		this.height = h;
	}

	double get_radius() {
		return radius;
	}

	double get_length() {
		return length;
	}

	double get_height() {
		return height;
	}

	double get_area() {
		return 0.0;
	}

	double get_volume() {
		return 0.0;
	}

}

class twoDimensionalShape extends shape {

	twoDimensionalShape(double r, double a, double h) {
		super(r, a, h);
	}

	double get_area() {
		return 0.0;
	}

	double get_volume() {
		return 0.0;
	}

}

class threeDimensionalShape extends shape {
	threeDimensionalShape(double r, double a, double h) {
		super(r, a, h);

	}

	double get_area() {
		return 0.0;
	}

	double get_volume() {
		return 0.0;
	}
}

class circle extends twoDimensionalShape // child class of twoDimensionalShape
{
	circle(double r, double a, double h) {
		super(r, a, h);
	}

	double get_area() {
		return (Math.PI * radius * radius);
	}
}

class Square extends twoDimensionalShape // child class of twoDimensionalShape
{
	Square(double r, double a, double h) {
		super(r, a, h);
	}

	double get_area() {
		return (length * length);
	}
}

class Triangle extends twoDimensionalShape // child class of twoDimensionalShape
{
	Triangle(double r, double a, double h) {
		super(r, a, h);
	}

	double get_area() {
		return radius * height / 2;
	}

}

class Sphere extends threeDimensionalShape // child class of threeDimensionalShape
{
	Sphere(double r, double a, double h) {
		super(r, a, h);
	}

	double get_area() {
		return 4 * Math.PI * radius * radius;
	}

	double get_volume() {
		return 4 / 3 * (Math.PI * radius * radius * radius);
	}
}

class Cube extends threeDimensionalShape // child class of threeDimensionalShape
{
	Cube(double r, double a, double h) {
		super(r, a, h);
	}

	double get_area() {
		return 6 * length * length;
	}

	double get_volume() {
		return length * length * length;
	}
}

class Tetrahedron extends threeDimensionalShape // child class of threeDimensionalShape
{
	Tetrahedron(double r, double a, double h) {
		super(r, a, h);
	}

	double get_area() {
		return Math.sqrt(3) * length * length;
	}

	double get_volume() {
		return length * length * length / (6 * Math.sqrt(2));
	}
}

public class Lab2 {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		System.out.print("Enter value of Radius: ");
		double r = in.nextDouble();

		System.out.print("Enter value of Length: ");
		double a = in.nextDouble();

		System.out.print("Enter value of Height: ");
		double h = in.nextDouble();

		circle c = new circle(r, a, h);
		shape s[] = new shape[6];

		/// s[0] = new circle(r, a, h);
		// s[0] = c;
		s[1] = new Square(r, a, h);
		s[2] = new Triangle(r, a, h);
		s[3] = new Sphere(r, a, h);
		s[4] = new Cube(r, a, h);
		s[5] = new Tetrahedron(r, a, h);

		for (int i = 0; i < 6; i++) {
			if (s[i] instanceof circle) {
				System.out.println("Area of circle = " + s[i].get_area());
			} else if (s[i] instanceof Square) {
				System.out.println("Area of Square = " + s[i].get_area());
			} else if (s[i] instanceof Triangle) {
				System.out.println("Area of Triangle = " + s[i].get_area());
			} else if (s[i] instanceof Sphere) {
				System.out.println("Area of Sphere = " + s[i].get_area());
				if (s[i] instanceof threeDimensionalShape) {
					System.out.println("Volume of Sphere = " + s[i].get_volume());
				}
			} else if (s[i] instanceof Cube) {
				System.out.println("Area of Cube = " + s[i].get_area());
				if (s[i] instanceof threeDimensionalShape) {
					System.out.println("Volume of Cube = " + s[i].get_volume());
				}
			} else if (s[i] instanceof Tetrahedron) {
				System.out.println("Area of Tetrahedron = " + s[i].get_area());
				if (s[i] instanceof threeDimensionalShape) {
					System.out.println("Volume of Tetrahedron = " + s[i].get_volume());
				}
			}

		}
	}
}
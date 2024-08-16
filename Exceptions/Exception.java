import java.util.Scanner;

class Main {
  public static void main(String[] args) {
    Scanner obj = new Scanner(System.in);
    System.out.println("Enter the age: ");
    String age = obj.nextLine();
    int a = Integer.parseInt(age);
    try {
      a = 2 / a;
      System.out.println(a);
    } catch (ArithmeticException e) {
      System.out.println(e.toString());
    }
  }
}
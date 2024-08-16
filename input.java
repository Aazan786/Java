 import java.util.Scanner;
 
 public class input
 {
    public static void main(String[] args)
    {
      String degree, batch, section, id;
      Scanner obj = new Scanner(System.in);
      
      System.out.println("What is your degree?");
      degree = obj.nextLine();
      
      System.out.println("What is your batch?");
      batch = obj.nextLine();
      
      System.out.println("What is your section?");
      section = obj.nextLine();
      
      System.out.println("What is your id?");
      id = obj.nextLine();

      System.out.println("Your Roll is " + degree+batch+section+id);
      
    }
 }
import javax.swing.*;
import java.io.*;
import java.util.*;

class PersonInfo implements Serializable {
    String name;
    String address;
    String phoneno;

    public PersonInfo(String n, String a, String p) {
        name = n;
        address = a;
        phoneno = p;
    }

    public void print() {
        JOptionPane.showMessageDialog(null, "name:" + name + "address:" + address + "phone Num:" + phoneno);
    }
}

class AddressBook {
    ArrayList persons;

    public AddressBook() {
        persons = new ArrayList();
        loadPersons();
    }

    public void loadPersons() {
        String tokens[] = null;
        String name, add, ph;
        try {
            FileReader fr = new FileReader("persons.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = br.readLine();
            while (line != null) {
                tokens = line.split(",");
                name = tokens[0];
                add = tokens[1];
                ph = tokens[2];

                PersonInfo p = new PersonInfo(name, add, ph);
                persons.add(p);
                line = br.readLine();
            }
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println(e);
        }

        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }

        try {
            FileInputStream fileIn = new FileInputStream("persons.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            // persons = (ArrayList<PersonInfo>) in.readObject();
            PersonInfo persons = (PersonInfo) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e);
        }
    }

    public void savePersons() {
        try {
            FileOutputStream fileOut = new FileOutputStream("persons.txt");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(persons);
            out.close();
            fileOut.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    // public void savePersons() {
    // try {
    // PersonInfo p;
    // String line;
    // FileWriter fw = new FileWriter("persons.txt");
    // PrintWriter pw = new PrintWriter(fw);
    // for (int i = 0; i < persons.size(); i++) {
    // p = (PersonInfo) persons.get(i);
    // line = p.name + "," + p.address + "," + p.phoneno;
    // pw.println(line);
    // }

    // pw.flush();
    // pw.close();
    // fw.close();
    // } catch (IOException e) {
    // System.out.println(e);
    // }
    // }

    // public void loadPersons() {
    // try {
    // FileInputStream fileIn = new FileInputStream("persons.txt");
    // ObjectInputStream in = new ObjectInputStream(fileIn);
    // // persons = (ArrayList<PersonInfo>) in.readObject();
    // PersonInfo persons = (PersonInfo) in.readObject();
    // in.close();
    // fileIn.close();
    // } catch (IOException | ClassNotFoundException e) {
    // System.out.println(e);
    // }
    // }

    public void addperson() {
        String name = JOptionPane.showInputDialog(null, "Enter name");
        String add = JOptionPane.showInputDialog("Enter address");
        String ph = JOptionPane.showInputDialog("Enter phonenum");

        PersonInfo p = new PersonInfo(name, add, ph);
        persons.add(p);
    }

    public void showAll() {
        if (persons.isEmpty()) {
            System.out.println("No data");
        } else {

            for (int i = 0; i < persons.size(); i++) {
                PersonInfo p = (PersonInfo) persons.get(i);
                p.print();
            }
        }
    }
    // }

    public void searchPerson(String n) {
        for (int i = 0; i < persons.size(); i++) {
            PersonInfo p = (PersonInfo) persons.get(i);
            if (n.equals(p.name)) {
                p.print();
            }
        }
    }

    public void deleteperson(String n) {
        for (int i = 0; i < persons.size(); i++) {
            PersonInfo p = (PersonInfo) persons.get(i);
            if (n.equals(p.name)) {
                persons.remove(i);
            }
        }
    }
}

public class Version1 {

    public static void main(String[] argv) {
        AddressBook ab = new AddressBook();
        String input, s;
        int ch;

        while (true) {
            input = JOptionPane.showInputDialog(
                    "Enter 1 to add " + "\n Enter 2 to Search \n Enter 3 to delete" + "\n Enter 4 to showall"
                            + "\n Enter 5 to exit");
            ch = Integer.parseInt(input);

            switch (ch) {
                case 1:
                    ab.addperson();
                    break;

                case 2:
                    s = JOptionPane.showInputDialog("Enter name you want to search ");
                    ab.searchPerson(s);
                    break;

                case 3:
                    s = JOptionPane.showInputDialog("Enter name you want to delete ");
                    ab.deleteperson(s);
                    break;

                case 4:
                    ab.showAll();
                    break;

                case 5:
                    ab.savePersons();
                    System.exit(0);
            }
        }
    }
}
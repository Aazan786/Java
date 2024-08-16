import java.util.*;

import javax.lang.model.element.Element;

public class ArrayListExample {
    public static void main(String[] argv) {
        // without safe mode arraylist
        ArrayList mylist = new ArrayList();

        mylist.add("Azan");
        mylist.add("Ab");
        mylist.add("ahgd");
        mylist.add("agsf");
        mylist.add(1, "Programming");
        String element1 = (String) mylist.get(2);
        System.out.println(element1.getClass());

        System.out.println(element1);
    }

}

// //import java.util.ArrayList;

// //public class ArrayListWithoutTypeExample {
// public static void main(String[] args) {
// ArrayList list = new ArrayList();

// list.add("Hello");
// list.add(123);
// list.add(true);

// Object element1 = list.get(0);
// String stringElement = (String) element1;
// System.out.println(stringElement); // Output: Hello
// Object element2 = list.get(1);
// int intElement = (int) element2;
// System.out.println(intElement); // Output: 123

// Object element3 = list.get(2);
// boolean booleanElement = (boolean) element3;
// System.out.println(booleanElement); // Output: true
// }
// }

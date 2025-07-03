import java.util.TreeSet;

public class TreeSet {
    public static void main(String[] args) {
        TreeSet<String> ts = new TreeSet<>();

        ts.add("Banana");
        ts.add("Apple");
        ts.add("Orange");
        ts.add("Mango");

        System.out.println("Sorted TreeSet: " + ts);

        ts.add("Apple");  // Duplicate, will be ignored

        System.out.println("After adding duplicate: " + ts);

        System.out.println("Does TreeSet contain 'Mango'? " + ts.contains("Mango"));
        System.out.println("First element: " + ts.first());
        System.out.println("Last element: " + ts.last());
    }
}

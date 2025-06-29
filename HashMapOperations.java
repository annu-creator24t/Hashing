import java.util.HashMap;

public class HashMapOperations {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Mango", 30);
        map.put("Orange", 40);

        System.out.println("Initial Map: " + map);
        System.out.println("Value for key 'Mango': " + map.get("Mango"));

        if (map.containsKey("Banana")) {
            System.out.println("'Banana' is present in the map.");
        } else {
            System.out.println("'Banana' is not present in the map.");
        }

        map.remove("Apple");
        System.out.println("Map after removing 'Apple': " + map);
    }
}

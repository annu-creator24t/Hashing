import java.util.LinkedHashMap;
import java.util.Map;

public class Linkedhashmap {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        map.put("Apple", 3);
        map.put("Banana", 2);
        map.put("Orange", 5);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}

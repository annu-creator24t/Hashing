import java.util.HashMap;
import java.util.HashSet;

public class FindItineraryFromTickets {

    public static void printItinerary(HashMap<String, String> tickets) {
        HashSet<String> destinations = new HashSet<>(tickets.values());
        String start = null;

        for (String source : tickets.keySet()) {
            if (!destinations.contains(source)) {
                start = source;
                break;
            }
        }

        if (start == null) {
            System.out.println("Invalid input: no unique starting point.");
            return;
        }

        String current = start;
        while (tickets.containsKey(current)) {
            String next = tickets.get(current);
            System.out.print(current + " -> ");
            current = next;
        }
        System.out.println(current);
    }

    public static void main(String[] args) {
        HashMap<String, String> tickets = new HashMap<>();
        tickets.put("Chennai", "Bangalore");
        tickets.put("Bombay", "Delhi");
        tickets.put("Goa", "Chennai");
        tickets.put("Delhi", "Goa");

        System.out.println("Itinerary:");
        printItinerary(tickets);
    }
}

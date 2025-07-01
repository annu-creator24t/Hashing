import java.util.LinkedList;

public class ImplementationHasmap<K, V> {

    private static final double LOAD_FACTOR = 0.75;
    private int capacity = 16;
    private LinkedList<Entry<K, V>>[] buckets;
    private int size = 0;

    public ImplementationHasmap() {
        buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int getIndex(K key) {
        return Math.abs(key.hashCode() % capacity);
    }

    public void put(K key, V value) {
        if ((double) size / capacity >= LOAD_FACTOR) {
            rehash();
        }
        int index = getIndex(key);
        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        buckets[index].add(new Entry<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = getIndex(key);
        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    public boolean containsKey(K key) {
        int index = getIndex(key);
        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    public void remove(K key) {
        int index = getIndex(key);
        for (Entry<K, V> entry : buckets[index]) {
            if (entry.key.equals(key)) {
                buckets[index].remove(entry);
                size--;
                return;
            }
        }
    }

    public int size() {
        return size;
    }

    private void rehash() {
        LinkedList<Entry<K, V>>[] oldBuckets = buckets;
        capacity *= 2;
        buckets = new LinkedList[capacity];
        size = 0;
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
        for (LinkedList<Entry<K, V>> bucket : oldBuckets) {
            for (Entry<K, V> entry : bucket) {
                put(entry.key, entry.value);
            }
        }
    }

    public static void main(String[] args) {
        ImplementationHasmap<String, Integer> map = new ImplementationHasmap<>();
        map.put("apple", 100);
        map.put("banana", 200);
        map.put("grape", 300);
        map.put("orange", 400);
        map.put("melon", 500);
        map.put("lemon", 600);
        map.put("peach", 700);

        System.out.println("apple -> " + map.get("apple"));
        System.out.println("Contains 'banana'? " + map.containsKey("banana"));
        System.out.println("Size: " + map.size());

        map.remove("banana");
        System.out.println("Contains 'banana'? " + map.containsKey("banana"));
        System.out.println("Size: " + map.size());
    }
}

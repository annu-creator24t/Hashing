import java.util.HashSet;
import java.util.Set;

public class UnionAndIntersection {

    public static Set<Integer> getUnion(int[] arr1, int[] arr2) {
        Set<Integer> union = new HashSet<>();
        for (int num : arr1) {
            union.add(num);
        }
        for (int num : arr2) {
            union.add(num);
        }
        return union;
    }
    public static Set<Integer> getIntersection(int[] arr1, int[] arr2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> intersection = new HashSet<>();

        for (int num : arr1) {
            set1.add(num);
        }

        for (int num : arr2) {
            if (set1.contains(num)) {
                intersection.add(num);
            }
        }

        return intersection;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 4, 5, 6};
        int[] arr2 = {2, 3, 5, 7};

        Set<Integer> union = getUnion(arr1, arr2);
        Set<Integer> intersection = getIntersection(arr1, arr2);

        System.out.println("Union: " + union);
        System.out.println("Intersection: " + intersection);
    }
}

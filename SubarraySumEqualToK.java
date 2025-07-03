import java.util.HashMap;

public class SubarraySumEqualToK {

    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);  // Base case: one way to have sum = 0 before starting

        int count = 0;
        int sum = 0;

        for (int num : nums) {
            sum += num;

            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        int k = 2;

        int result = subarraySum(nums, k);
        System.out.println("Number of subarrays with sum = " + k + ": " + result);
    }
}

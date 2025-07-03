import java.util.HashMap;

public class LargestSubarrayWithZeroSum {

    public static int maxLen(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == 0) {
                maxLength = i + 1;
            } else if (map.containsKey(sum)) {
                int prevIndex = map.get(sum);
                maxLength = Math.max(maxLength, i - prevIndex);
            } else {
                map.put(sum, i);
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] arr = {15, -2, 2, -8, 1, 7, 10, 23};

        int result = maxLen(arr);
        System.out.println("Length of the largest subarray with zero sum: " + result);
    }
}

import java.util.*;

public class ShortestLongestSubArraySumK {
    public static void main(String[] args) {
        // int[] nums = {1,0,1,2,8}; int k=2;
        // brute(nums, k);
        // optimal(nums, k);

        int[] nums1 = {1, 2, 1, 1, 1}; int k1=3;
        optimal2(nums1, k1);

    }

    public static void brute(int[] nums, int k){
        int maxLength=Integer.MIN_VALUE, minLength=Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            int sum=0;
            for(int j=i; j<nums.length; j++){
                sum += nums[j];
                if(sum==k){
                    maxLength= Math.max(maxLength, j-i+1);
                    minLength= Math.min(minLength, j-i+1);
                }
            }
        }
        System.out.println(maxLength+"  "+minLength);
    }

    public static void optimal(int[] nums, int k){
        int maxLength=Integer.MIN_VALUE, minLength=Integer.MAX_VALUE;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum=0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum-k)){
                int st = map.get(sum-k);
                maxLength = Math.max(maxLength, i - st);
                minLength = Math.min(minLength, i - st);
            }
            map.putIfAbsent(sum, i);
        }

        System.out.println(maxLength+"  "+minLength);
    }

    public static void optimal(int[] nums, int k) {
    int maxLength = 0;
    int minLength = Integer.MAX_VALUE;

    Map<Integer, Integer> firstMap = new HashMap<>(); // for longest
    Map<Integer, Integer> lastMap = new HashMap<>();  // for smallest

    firstMap.put(0, -1);
    lastMap.put(0, -1);

    int sum = 0;
    boolean found = false;

    for (int i = 0; i < nums.length; i++) {
        sum += nums[i];

        // ✅ LONGEST (use first occurrence)
        if (firstMap.containsKey(sum - k)) {
            int len = i - firstMap.get(sum - k);
            maxLength = Math.max(maxLength, len);
            found = true;
        }

        // ✅ SMALLEST (use latest occurrence)
        if (lastMap.containsKey(sum - k)) {
            int len = i - lastMap.get(sum - k);
            minLength = Math.min(minLength, len);
            found = true;
        }

        // store first occurrence (only once)
        firstMap.putIfAbsent(sum, i);

        // always update latest occurrence
        lastMap.put(sum, i);
    }

    if (!found) {
        System.out.println("No subarray found");
    } else {
        System.out.println(maxLength + "  " + minLength);
    }
}

    public static int countSubarraysWithLength(int n, int k, int[] arr, int targetLength) {
    if (targetLength == 0 || targetLength > n) return 0;

    int count = 0;
    int windowSum = 0;

    // first window
    for (int j = 0; j < targetLength; j++) {
        windowSum += arr[j];
    }

    if (windowSum == k) count++;

    // slide window
    for (int j = targetLength; j < n; j++) {
        windowSum += arr[j] - arr[j - targetLength];
        if (windowSum == k) count++;
    }

    return count;
}
}

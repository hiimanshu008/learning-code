import java.util.Arrays;

public class MaxHappiness {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int k = 2;
        System.out.println(maximizeHappiness(arr, k));
    }

    public static long maximizeHappiness(int[] nums, int k) {
        Arrays.sort(nums);
        long sum=0;
        for (int i=nums.length-1; i>= nums.length-k; i--) {
            sum += nums[i];
        }
        return sum;
    }

    // for minimum happiness --> take starting element till k 
}

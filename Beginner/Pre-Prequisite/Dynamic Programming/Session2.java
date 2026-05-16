public class Session2 {
    public static void main(String[] args) {
        int n = 5;
        int[] nums= {2,-3,5,8,7};

        int[] dp = new int[n];
        dp[0] = Math.max(nums[0], 0);
        dp[1] = Math.max(nums[0], Math.max(nums[1], 0));

        int i=1;
        while (i<n) {
            dp[i] = Math.max(nums[i]+dp[i-2],dp[i-1]);
            i++;
        }

        System.out.println(dp[n-1]);
    }
}

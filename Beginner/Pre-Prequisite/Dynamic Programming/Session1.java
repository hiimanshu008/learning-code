public class Session1 {
    public static void main(String[] args) {
        int n=5;

        int[] nums = {6,7,3,2,2};
        int[] dp =new int[n];

        dp[0] = nums[0];
        for(int i=1; i<n; i++) {
            dp[i] = nums[i] + dp[i-1];
        }

        int q=4;
        int[] queries = {0,3,4,2};
        for(int i=0; i<q; i++){
            int idx = queries[i];
            System.out.println(dp[idx]);
        }
    }
}

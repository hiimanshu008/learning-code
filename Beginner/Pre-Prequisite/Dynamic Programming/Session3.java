public class Session3 {
    public static void main(String[] args) {
        int[] a = {2,4,5,-8,2};
        int[] b = {-5,8,3,1,4};

        int n = 5;

        int[] dp = new int[n];
        dp[0] = Math.max(a[0], b[0]);
        dp[1] = Math.max(a[1], b[1]);

        int i=2;
        while (i<n) {
            int x = dp[i-1]; int y = a[i]+dp[i-1];
            int z = b[i]+dp[i-1];
            dp[i] = Math.max(x,Math.max(y, z));
        }

        System.out.println(dp[n-1]);
    }
}

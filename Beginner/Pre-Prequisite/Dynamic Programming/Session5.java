import java.util.Scanner;

public class Session5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        String s = sc.nextLine();

        int[] dp = new int[n];
        dp[0]=1;

        int maxLen=1; int maxIndex=0;

        for(int i=1; i<n; i++){

            if(Math.abs(s.charAt(i)-s.charAt(i-1))<=k){
                dp[i] = dp[i-1] + 1;
            }else dp[i]=1;


            if(dp[i]>maxLen) {
                maxLen = dp[i];
                maxIndex = i;
            }
        }
        int startIndex = maxIndex - maxLen + 1;
        System.out.println(s.substring(startIndex,startIndex+maxLen));
        sc.close();
    }
}

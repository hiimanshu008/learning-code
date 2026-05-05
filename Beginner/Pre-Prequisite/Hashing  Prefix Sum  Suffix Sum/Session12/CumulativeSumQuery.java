package Session12;
import java.util.Scanner;

public class CumulativeSumQuery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Build prefix sum array
        int[] prefix = new int[n];
        prefix[0] = arr[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        int q = sc.nextInt();

        while (q-- > 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();

            // Range sum
            int result = (l == 0) ? prefix[r] : prefix[r] - prefix[l - 1];
            System.out.println(result);
        }

        sc.close();
    }
}

import java.util.*;


public class IBMOA {
    public static void main(String[] args) {

        long[] a = {1,2,3,4,5};
        int n = a.length;

        Arrays.sort(a);
        long[] prefix = new long[n];

        prefix[0] = a[0];

        for (int i=1; i<n; i++) {
            prefix[i] = prefix[i-1] + a[i];
        }
        long total = prefix[n-1];
        long[] target = {3,2};

        for (long x : target) {

            int g = upperBound(a, x, n);
            long left=0;

            if (g>0) left = x*g -prefix[g-1];

            long right = (total -(g>0? prefix[g-1] : 0))- x*(n-g);
            System.out.println(left + right);
        }
    }

    public static int upperBound(long[] a, long x, int n) {
        int low = 0;
        int high = n - 1;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (a[mid] <= x) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans + 1;
    }
}

import java.util.HashMap;
import java.util.Map;

public interface FindValidPairs {

    /*
    Given two arrays A and B -> find the number of valid pairs 
    (A[i],B[j]) such that B[j] is multiple of A[i]  
    */
    public static void main(String[] args) {
        
    }

    public static long countPairs(int n, long[] a, long[] b) {

        Map<Long,Long> mapA = new HashMap<>();
        Map<Long,Long> mapB = new HashMap<>();

        long maxB = 0;
        for (long val : a) {
            mapA.put(val,mapA.getOrDefault(val,0L)+1);
        }

        for (long val : b) {
            maxB = Math.max(maxB,val);
            mapB.put(val,mapB.getOrDefault(val,0L)+1);
        }

        long ans =0;
        for (Map.Entry<Long,Long> entry : mapA.entrySet()) {
            long curr = entry.getKey();
            long d=0;
            long j=curr;

            while (j<= 1_000_000) {
                d+=mapB.getOrDefault(j,0L);
                j+=curr;
            }
            d*=mapA.get(curr);
            ans+=d;
        }
        return ans;
    }
}

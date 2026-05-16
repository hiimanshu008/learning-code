public class FindQuadRuplets {
    public static void main(String[] args) {
        
    }

    public static long sol(int[] nums, int k1, int k2){
        long count=0;
        for(int j=1; j<nums.length-2; j++){
            int i=j-1; long count1 = 0;
            while (i>=0) {
                if(nums[i]+nums[j] > k1) count1++;
                i--;
            }

            long count2=0; int k = j+1, l=nums.length-1;
            while (k<l) {
                if(nums[k]+nums[l]>k2){
                    count2 += k-1;
                    l--;
                } else k++;
            }
            count = count1*count2;
        }
        return count;
    }

    /*
        use binary search --> O(N log N)
        left count -> binary search (log n)
        right count -> pre calculate ( O(1))
     */
    
}

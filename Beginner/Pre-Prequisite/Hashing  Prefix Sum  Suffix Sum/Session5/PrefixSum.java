
public class PrefixSum {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};

        System.out.println(optimal(nums,1,4));
        System.out.println(check(nums, 1, 4));

    }

    public static int[] brute(int[] nums){
        int[] ans = new int[nums.length];
        for(int i=0; i<nums.length; i++){
            for(int j=i; j>=0; j--){
                ans[i]+=nums[j];
            }
        }
        return ans;
    }

    public static int check(int[] nums, int l, int r) {
        int sum=0;
         for(int i=l; i<=r; i++){
            sum+=nums[i];
         }
         return sum;
    }

    public static int optimal(int[] nums, int l, int r){
        int[] prefixSum = new int[nums.length];
        prefixSum[0]=nums[0];
        for(int i=1; i<nums.length; i++){
            prefixSum[i] = nums[i] + prefixSum[i-1];
        }
        return prefixSum[r]-prefixSum[l-1];
    }
}

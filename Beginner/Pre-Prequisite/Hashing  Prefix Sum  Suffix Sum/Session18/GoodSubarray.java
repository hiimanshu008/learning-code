import java.util.HashMap;

public class GoodSubarray {

    // good subarray ---> if subarray sum % k === subarray length
    public static void main(String[] args) {
        int[] nums = {1,3,2,4};
        int k = 4;
        System.out.println(brute(nums, k));
    }

    public static int brute(int[] nums, int k){
        if(k==0) return 0;
        int count=0;
        for(int i=0; i<nums.length; i++){
            int sum=0;
            for(int j=i; j<nums.length; j++){
                sum+=nums[j];
                int len = j-i+1;
                if( sum % k == len) count++;
            }
        }
        return count;
    }

    public static int goodSubarray(int[] nums, int k){
        int count=0; int presum =0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);  // to check subarray starting from i=0;

        for(int i=0; i<nums.length; i++){
            presum += nums[i];
            int value = (presum%k - (i+1)%k + k ) %k;
            count += map.getOrDefault(value,0);
            map.put(value, map.getOrDefault(value,0)+1);
        }
        return count;
    }
}

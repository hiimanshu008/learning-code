import java.util.HashMap;

public class SubArraySumK {
    public static void main(String[] args) {
        int[] nums = {1,0,1,2,8};
        System.out.println(optimal(nums, 2));
    }

    public static int brute(int[] nums, int k){
        int count=0;
        for(int i=1; i<nums.length; i++){
            int sum=0;
            for(int j=i; j>=0; j--){
                sum += nums[j];
                if(sum==k) count++;
            }
        }
        return count;
    }

    public static int optimal(int[] nums,int k){
        int count=0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);  // why ? --> for sum==k (sum-k ==0)
        int sum=0;
        for(int i : nums){
            sum ^=i;
            if(hm.containsKey(sum^k)) count += hm.get(sum^k);
            hm.put(sum,hm.getOrDefault(sum, 0)+1);
        }
        return count;
    }

    
}

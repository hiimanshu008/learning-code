import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Handler;

public class Introduction {
    public static void main(String[] args) {
        // int[] nums = {2,1,1,5,8}; int k=4;
        // System.out.println(subarraySum(nums, k));

        int[] nums = {1, 2, 1, 2, 3}; int k=2;
        System.out.println(distinctSubarray(nums, k));


    }


    //Number of subarrays whose sum <= K 
    public static int subarraySum(int[] nums, int k){
        int count = 0;
        int sum=0;
        for(int i=0,j=0; j<nums.length; j++){
            sum+=nums[j];
            while(sum>k) sum-=nums[i++];
            count += (j-i+1);
        }
        return count;
    }

    //Number of subarrays whose count of distinct number <= K 
    public static int distinctSubarray(int[] nums, int k){
        Map<Integer,Integer> map = new HashMap<>();
        int count = 0;
        for(int i=0,j=0; j<nums.length; j++){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            while (map.size()>k) {
                map.put(nums[i],map.get(nums[i])-1); // shrinking subarray 0-->1-->2;
                if(map.get(nums[i])==0) map.remove(nums[i]);
                i++;
            }
            count += (j-i+1);
        }
        return count;
    }

    //Number of pairs whose absolute diff <=K 
    public static int subarrayAbsDiff(int[] nums, int k){
        Arrays.sort(nums);
        int count = 0;
        for(int i=0,j=0; j<nums.length; j++){
            int diff = nums[j]-nums[i];
            while(diff>k) {
                i++;
                diff = nums[j]-nums[i];
            }
            count += (j-i+1);
        }
        return count;
    }
}

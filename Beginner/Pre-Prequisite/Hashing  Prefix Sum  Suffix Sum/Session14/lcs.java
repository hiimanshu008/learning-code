import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class lcs {
    public static void main(String[] args) {
        //int[] nums = [100,4,200,1,3,2];
        int[] nums = {5, -2, 2, -8, 1, 7, 10};
        System.out.println(longest(nums));
    }
    
    public static int optimal(int[] nums){
        Set<Integer> hs = new HashSet<>();

        for(int i : nums) hs.add(i);
        int maxCount = 0;
        for(int i : nums){
            if(hs.contains(i-1)) continue;
            else{
                int current =i;
                int count=1;
                while (hs.contains(current+1)) {
                    count++;
                }
                maxCount = Math.max(maxCount, count);
            }
        }

        return maxCount;
    }

    //Longest Subarray with 0 Sum
    public static int longest(int[] nums){
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,-1);  //keep base case all the time 
        int sum=0; int maxLen = 0;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum)){
                maxLen = Math.max(maxLen, i-map.get(sum));
            }
                
            map.putIfAbsent(sum,i);
        }
        return maxLen;
    }
}

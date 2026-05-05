import java.util.HashMap;
public class AbsCountAllPairs {
    public static void main(String[] args) {
        
    }

    public static int brute(int[] nums, int k) {
        int count=0;

        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j<nums.length; j++){
                if (Math.abs(nums[i]-nums[j])==k) count++;
            }
        }
        return count;
    }

    public static int optimal(int[] nums, int k){
        HashMap<Integer,Integer> hm = new HashMap<>();

        int count=0;
        for(int i : nums){
            if(k == 0){
                if(hm.containsKey(i)) count += hm.get(i);
            } 
            else {
                if(hm.containsKey(i-k)) count += hm.get(i-k);
                if(hm.containsKey(i+k)) count += hm.get(i+k);
            }

            hm.put(i, hm.getOrDefault(i, 0)+1);
        }
        return count;
    }
}

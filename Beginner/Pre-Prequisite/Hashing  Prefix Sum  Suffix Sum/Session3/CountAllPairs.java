import java.util.HashMap;

public class CountAllPairs {
    //Count All ((i,j) pairs such that b[i] - b[j] == k (count of such pairs.) [i<j] 
    public static void main(String[] args) {
        
    }

    public static int brute(int[] nums, int k) {
        int count=0;

        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j<nums.length; j++){
                if (nums[i]-nums[j]==k) count++;
            }
        }
        return count;
    }

    public static int optimal(int[] nums, int k){
        HashMap<Integer,Integer> hm = new HashMap<>();

        int count=0;
        for(int i : nums){
            if(hm.containsKey(i-k)) count+=hm.get(i-k);
            hm.put(i, hm.getOrDefault(i, 0)+1);
        }
        return count;
    }
}

import java.util.HashMap;

public class TwoEqualNumberInArrayDistanceK {
    public static void main(String[] args) {
        int[] nums = {3,2,4,3,1};
        int k = 3;
        int k2 = 1;
        System.out.println(optimal(nums, k));
        System.out.println(optimal(nums, k2));

    }

    public static boolean brute(int[] nums, int k){
        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j<nums.length; j++){
                if (nums[j]==nums[i]){
                    if(j-i<=k) return true;
                }
            }
        }
        return false;
    }

    public static boolean optimal(int[] nums, int k){
        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(hm.containsKey(nums[i]) &&  k-hm.get(nums[i])>=i) return true;
            hm.put(nums[i], i);
        }
        return false;
    }
}

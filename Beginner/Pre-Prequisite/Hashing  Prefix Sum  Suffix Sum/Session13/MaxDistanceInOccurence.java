import java.util.HashMap;
import java.util.Map;

public class MaxDistanceInOccurence {
    public static void main(String[] args) {
        String s1 = "leetcode";
        System.out.println(firstSingleOccurene(s1));
    }

    // public static int brute(int[] nums){
    //     for (int i=0; i<nums.length; i++){
    //         for (int j=0; j<nums.length; j++){

    //         }
    //     }
    // }

    public static int optimal(int[] nums){
        int maxLen = -1;
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])) maxLen = Math.max(maxLen, i-map.get(nums[i]));
            map.putIfAbsent(nums[i], i);
        }
        return maxLen;
    }

    public static int firstSingleOccurene(String s1){
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(int i=0 ; i<s1.length(); i++){
            map.put(s1.charAt(i),map.getOrDefault(s1.charAt(i),0)+1);
        }

        for(int i=0 ; i<s1.length(); i++){
            if (map.get(s1.charAt(i))==1) return i;
        }
        return -1;
    }
}

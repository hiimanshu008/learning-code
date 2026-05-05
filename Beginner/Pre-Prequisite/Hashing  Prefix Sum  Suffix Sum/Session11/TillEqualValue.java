import java.util.Arrays;
import java.util.Collections;
import java.util.TreeMap;
import java.util.Map;

public class TillEqualValue {
    public static void main(String[] args) {
        int[] nums = {5,5,5,3,3,3,1};
        System.out.println(optimal2(nums));
    }

    public static int optimal(int[] nums){
        Map<Integer,Integer> map = new TreeMap<>(Collections.reverseOrder());

        for( int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int steps = 0, temp =0;

        for(int i : map.values()){
            steps+=temp;
            temp+=i;
        }
        return steps;
    }

    public static int optimal2(int[] nums){
        Arrays.sort(nums);
        int steps = 0;
        for( int i=nums.length-1; i>0; i--){
            if(nums[i]!=nums[i-1]) steps+=nums.length-i;
        }
        return steps;
    }
}

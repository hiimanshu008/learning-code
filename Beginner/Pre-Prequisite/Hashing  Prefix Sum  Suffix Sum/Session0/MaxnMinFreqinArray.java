import java.util.HashMap;
import java.util.Map;

public class MaxnMinFreqinArray {
    public static void main(String[] args) {
        int[] arr = {3,2,4,3,2,3};
        optimal(arr);
    }

    public static void brute(int[] arr){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int maxValue = -1, minValue = -1;

        for(int i=0; i<arr.length; i++){
            int count=1;
            for(int j=i+1; j<arr.length; j++){
                if(arr[j]==arr[i]) count++;
            }
            if(count>max){ 
                max=count; maxValue=arr[i];
            }
            if(count<min){
                min=count; minValue=arr[i]; 
            }
        }

        System.out.println(maxValue+" : "+max);
        System.out.println(minValue+" : "+min);
    }

    public static void optimal(int[] arr){
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i : arr){
            hm.put(i, hm.getOrDefault(i, 0)+1);
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int maxValue = -1, minValue = -1;

        for(Map.Entry<Integer,Integer> entry : hm.entrySet()){
            if(entry.getValue()>max){
                max = entry.getValue();
                maxValue = entry.getKey();
            }
            if(entry.getValue() < min){
                min = entry.getValue();
                minValue = entry.getKey();
            }
        }
        System.out.println(maxValue+" : "+max);
        System.out.println(minValue+" : "+min);
    }
}

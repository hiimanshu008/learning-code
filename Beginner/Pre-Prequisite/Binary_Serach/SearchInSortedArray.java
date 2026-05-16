package Binary_Serach;
public class SearchInSortedArray {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int k = 1;
        System.out.println(search(nums, k));
    }

    public static int search(int[] nums, int k){
        int low=0, high = nums.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;

            if(nums[mid]==k) return mid;
            if(nums[mid]>nums[high]) low =mid+1;
            else high = mid-1;
        }
        return -1;
    }
}

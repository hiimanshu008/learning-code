public class KadaneAmazonOA {
    public static void main(String[] args) {
        // int[] nums = {5,8,10,2,5,5};
        int[] nums = {-10,-5,2,4,-15,-20,1,2};
        System.out.println(twoSubarraySum(nums));;

    }

    public static int kadane(int[] nums){
        int maxSub = nums[0]; int prevSum=nums[0];
        for(int i=1; i<nums.length;i++){
            int current = Math.max(prevSum+nums[i],nums[i]);
            prevSum = current;
            maxSub = Math.max(maxSub, current);
        }
        return maxSub;
    }


    // this is wrong ??? its still in O(n) and Kadanes only work in a single pass so make function for calculating
    // prefixMaxSum and suffixMaxSum

    // public static void twoSubarray(int[] nums){
    //     int leftCount=0; int rightCount=nums.length-1;
    //     int maxSubLeft = nums[0]; int preSum=nums[0];
    //     int maxSubRight = nums[0]; int suffSum=nums[nums.length-1];
    //     int max = 0;

    //     for(int i=1; i<nums.length-1; i++){
    //         while (leftCount<=i) {
    //             preSum = Math.max(preSum+nums[i], nums[i]);
    //             maxSubLeft = Math.max(maxSubLeft, preSum);
    //             leftCount++;
    //         }

    //         while (rightCount>i) {
    //             suffSum = Math.max(suffSum+nums[rightCount], nums[rightCount]);
    //             maxSubRight = Math.max(suffSum, maxSubRight);
    //             rightCount--;
    //         }

    //         max = Math.max(max, maxSubRight+maxSubLeft);
    //     }

    //     System.out.println(max);
    // }


    //O(n)

    public static int twoSubarraySum(int[] nums){

        int[] preSum = prefixMaxSum(nums);
        int[] sufSum = suffixMaxSum(nums);
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length-1; i++){
            max = Math.max(max, preSum[i]+sufSum[i+1]);
        }
        return max;
    }

    public static int[] prefixMaxSum(int[] nums){
        int[] pSum = new int[nums.length];
        pSum[0] = nums[0];
        int prevSum = nums[0];
        int maxSum = nums[0];

        for(int i=1; i<nums.length; i++){
            prevSum = Math.max(prevSum+nums[i], nums[i]);
            maxSum = Math.max(maxSum, prevSum);
            pSum[i] = maxSum;
        }
        return pSum;
    }

    public static int[] suffixMaxSum(int[] nums){
        int[] sSum = new int[nums.length];
        sSum[nums.length-1] = nums[nums.length-1];
        int prevSum = nums[nums.length-1];
        int maxSum = nums[nums.length-1];

        for(int i=nums.length-2; i>=0; i--){
            prevSum = Math.max(prevSum+nums[i], nums[i]);
            maxSum = Math.max(maxSum, prevSum);
            sSum[i] = maxSum;
        }
        return sSum;
    }


}

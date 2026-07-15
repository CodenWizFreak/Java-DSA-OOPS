import java.util.*;

public class Main {

    static class Result {
        int maxSum;
        int[] subarray;

        Result(int maxSum, int[] subarray) {
            this.maxSum = maxSum;
            this.subarray = subarray;
        }
    }

    public static Result maxSubarraySum(int[] arr) { // O(N) TC and O(K)+O(1) SC where K is size of subarray and O(1) is auxilliary space for the other variables

        int maxSum = arr[0];
        int currentSum = arr[0];
    
        int start = 0;
        int end = 0;
        int tempStart = 0;
    
        for (int i = 1; i < arr.length; i++) {
    
            if (currentSum + arr[i] < arr[i]) {
                currentSum = arr[i];
                tempStart = i;
            } else {
                currentSum += arr[i];
            }
    
            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
        }
    
        int[] subarray = Arrays.copyOfRange(arr, start, end + 1);
    
        return new Result(maxSum, subarray);
    }
   /*
    public static int maxSubArray(int[] nums) {
        // Initialize with the first element
        // This is minimal Kadane Algorithm where we're just returning the maxSum
        int currentSum = nums[0];
        int maxSum = nums[0];
    
        // Loop starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // Decide whether to add to the existing subarray or start fresh
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            
            // Update the global maximum if the current subarray sum is larger
            maxSum = Math.max(maxSum, currentSum);
        }
    
        return maxSum;
    }
    */
    /*
    public static int maxSubArray(int[] nums) {
        // 1. Initialize with the first element to handle all-negative arrays perfectly
        int currentSum = nums[0];
        int maxSum = nums[0];
    
        // 2. Loop safely starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // If currentSum is negative, throw it away and start fresh at nums[i]
            if (currentSum < 0) {
                currentSum = 0;
            }
            
            currentSum += nums[i]; 
    
            // Update global max if we found a better sum
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }
    
        return maxSum;
    }
    */
    
    
    public static int[] maxSubArrayIndices(int[] nums) { //this is the perfect one, where maxSum is the maximum subarray sum, and the indices of the subarray are being returned to the main function so we can print the subarray from there
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1}; 
        }
    
        int currentSum = nums[0];
        int maxSum = nums[0];
    
        int start = 0;
        int end = 0;
        int tempStart = 0; 
    
        for (int i = 1; i < nums.length; i++) {
            // Drop past sequence if rolling sum is negative
            if (currentSum < 0) {
                currentSum = 0;
                tempStart = i; 
            }
            
            currentSum += nums[i]; 
    
            // Update bounds when a strictly better window sum is found
            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
        }
    
        return new int[]{start, end};
    }
    


    public static int[][] findAllMaxSubArrayIndices(int[] nums) { //This is to print all maximum sum subarrays if there are multiple ones
        if (nums == null || nums.length == 0) {
            return new int[0][0];
        }

        int currentSum = nums[0];
        int maxSum = nums[0];

        int tempStart = 0;

        // Use a dynamic list to hold pairs of [start, end]
        List<int[]> allIndices = new ArrayList<>();
        allIndices.add(new int[]{0, 0});

        for (int i = 1; i < nums.length; i++) {
            if (currentSum < 0) {
                currentSum = 0;
                tempStart = i;
            }
            
            currentSum += nums[i]; 

            if (currentSum > maxSum) {
                // Found a strictly better max: discard all previous ties
                maxSum = currentSum;
                allIndices.clear();
                allIndices.add(new int[]{tempStart, i});
            } else if (currentSum == maxSum) {
                // Found a tie: add these indices to our tracking list
                allIndices.add(new int[]{tempStart, i});
            }
        }

        // Convert the List<int[]> back to a primitive 2D array
        return allIndices.toArray(new int[allIndices.size()][]);
    }



    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Result result = maxSubarraySum(arr);

        System.out.println(result.maxSum);
        System.out.println(Arrays.toString(result.subarray));

        sc.close();
    }
}

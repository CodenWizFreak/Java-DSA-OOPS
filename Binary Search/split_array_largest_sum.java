// Leetcode problem 410

class Solution {
    public int splitArray(int[] nums, int k) {
        // 'low' is the smallest possible answer (at least the max element)
        // 'high' is the largest possible answer (sum of all elements if we don't split)
        int low = 0, high = 0;
        for (int num : nums) {
            low = Math.max(low, num); // no subarray can have sum less than the largest single element
            high += num;              // no subarray can have sum more than total sum
        }
        
        // Binary search between [low, high]
        while (low < high) {
            // Mid is our "guess" for the maximum subarray sum
            int mid = low + (high - low) / 2;
            
            // If we can split nums into at most k subarrays with each sum <= mid
            if (canSplit(nums, k, mid)) {
                // mid is a valid candidate, try to minimize further
                high = mid;
            } else {
                // mid is too small, we need a bigger maximum sum
                low = mid + 1;
            }
        }
        
        // When low == high, we've found the minimized largest sum
        return low;
    }
    
    // Helper function: checks if we can split nums into <= k subarrays
    // such that no subarray sum exceeds maxSum
    private boolean canSplit(int[] nums, int k, int maxSum) {
        int count = 1;     // we always have at least one subarray
        int currSum = 0;   // running sum of the current subarray
        
        for (int num : nums) {
            // If adding this number exceeds maxSum,
            // we must start a new subarray
            if (currSum + num > maxSum) {
                count++;         // one more subarray needed
                currSum = num;   // reset currSum with current element
                
                // If we already need more than k subarrays, it's not possible
                if (count > k) return false;
            } else {
                // Otherwise, keep adding to current subarray
                currSum += num;
            }
        }
        
        // If we finished and used <= k subarrays, it's possible
        return true;
    }
}

// Leetcode problem 410

class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0, high = 0;
        for (int num : nums) {
            low = Math.max(low, num); // max element
            high += num; // total sum
        }
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (canSplit(nums, k, mid)) {
                high = mid; // try smaller
            } else {
                low = mid + 1; // need bigger
            }
        }
        return low;
    }
    private boolean canSplit(int[] nums, int k, int maxSum) {
        int count = 1, currSum = 0;
        for (int num : nums) {
            if (currSum + num > maxSum) {
                count++;
                currSum = num;
                if (count > k) return false;
            } else {
                currSum += num;
            }
        }
        return true;
    }
}

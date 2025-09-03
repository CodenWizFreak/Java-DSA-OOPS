// Leetcode Problem 287
// Floyd's Tortoise and Hare Cycle Finding Algorithm

class Solution {
    public int findDuplicate(int[] nums) {
        // Phase 1: Detect cycle
        int slow = nums[0];
        int fast = nums[0];
        
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        
        // Phase 2: Find entry point of the cycle
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        
        return slow; // or fast, both are at duplicate
    }
}

// OR Cyclic Sort

/*

class Solution {
    public int findDuplicate(int[] arr) {
        int i = 0;
        while (i < arr.length) {

            if (arr[i] != i + 1) {
                int correct = arr[i] - 1;
                if (arr[i] != arr[correct]) {
                    swap(arr, i , correct);
                } else {
                    return arr[i];
                }
            } else {
                i++;
            }
        }
        return -1;
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}

*/




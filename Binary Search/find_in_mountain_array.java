// Leetcode problem 1095

/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        // Step 1: Find the index of the peak element (maximum in the mountain)
        int maxIndex = getMaxValueIndex(mountainArr);

        // Step 2: Try to find target in the "left increasing part"
        int res = find(target, mountainArr, 0, maxIndex + 1, true);

        // Step 3: If not found on the left, search in the "right decreasing part"
        if (res == -1) {
            res = find(target, mountainArr, maxIndex, mountainArr.length(), false);
        }

        return res;
    }

    /**
     * Find the index of the peak element in the mountain array.
     * Uses binary search to locate the maximum.
     */
    int getMaxValueIndex(MountainArray mountainArr) {
        int n = mountainArr.length();
        int l = 0, r = n;

        while (l < r) {
            int mid = (l + r) >>> 1;  // same as (l + r) / 2 but avoids overflow
            int m = mountainArr.get(mid);

            // Get neighbors (left, right), if they exist
            int left = mid > 0 ? mountainArr.get(mid - 1) : -1;
            int right = mid + 1 < n ? mountainArr.get(mid + 1) : -1;

            // Case 1: We're at index 0, compare with only right
            if (left == -1) {
                return m > right ? 0 : 1;
            }
            // Case 2: We're at last index, compare with only left
            else if (right == -1) {
                return m > left ? n - 1 : n - 2;
            }
            // Case 3: We are in the increasing slope (m < right)
            else if (m > left && m < right) {
                l = mid + 1;
            }
            // Case 4: We are in the decreasing slope (m < left)
            else if (m < left && m > right) {
                r = mid;
            }
            // Case 5: Found the peak (m is bigger than both sides)
            else if (m > left && m > right) {
                return mid;
            }
        }

        return 0; // fallback (should not happen)
    }

    /**
     * Standard binary search.
     *
     * @param target   value we want to find
     * @param mountainArr  the API array
     * @param l  left boundary (inclusive)
     * @param r  right boundary (exclusive)
     * @param left  true = ascending order search, false = descending order search
     */
    int find(int target, MountainArray mountainArr, int l, int r, boolean left) {
        while (l < r) {
            int mid = (l + r) >>> 1;
            int m = mountainArr.get(mid);

            if (m > target) {
                // In ascending part, we must go left
                // In descending part, we must go right
                if (left) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            } else if (m < target) {
                // In ascending part, we must go right
                // In descending part, we must go left
                if (left) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            } else {
                // Found target
                return mid;
            }
        }
        return -1; // Not found
    }
}

public class LinearSearch1D {
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i; // Found target at index i
            }
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 9, 1, 7};
        int target = 1;
        int index = linearSearch(nums, target);
        System.out.println("Target found at index: " + index);
    }
}

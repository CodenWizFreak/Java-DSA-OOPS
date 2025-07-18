import java.util.Arrays;

public class FlattenedMatrixSearch {

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5},
            {7, 9, 11},
            {13, 15, 17}
        };

        int target = 9;

        int[] result = searchFlattenedMatrix(matrix, target);
        System.out.println("Target found at: " + Arrays.toString(result));
    }

    static int[] searchFlattenedMatrix(int[][] matrix, int target) {
        // Edge case: empty matrix or no columns
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[]{-1, -1};
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        int low = 0, high = rows * cols - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int row = mid / cols;
            int col = mid % cols;

            int val = matrix[row][col];

            if (val == target) {
                return new int[]{row, col};
            } else if (val < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return new int[]{-1, -1}; // Target not found
    }
}

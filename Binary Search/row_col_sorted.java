import java.util.Arrays;

public class Main {
    static int[] staircaseSearch(int[][] matrix, int target) {
        int row = 0;
        int col = matrix.length - 1; // Start from top-right

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target)
                return new int[]{row, col};
            else if (matrix[row][col] > target)
                col--; // Move left
            else
                row++; // Move down
        }

        return new int[]{-1, -1}; // Not found
    }

    public static void main(String[] args) {
        int[][] matrix = {
            { 1,  4,  7, 11},
            { 2,  5,  8, 12},
            { 3,  6,  9, 16},
            {10, 13, 14, 17}
        };

        int target = 10;
        int[] result = staircaseSearch(matrix, target);

        System.out.println("Target position: " + Arrays.toString(result));
    }
}

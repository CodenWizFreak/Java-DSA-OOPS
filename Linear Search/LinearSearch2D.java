public class LinearSearch2D {
    public static int[] linearSearch(int[][] matrix, int target) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == target) {
                    return new int[]{row, col}; // Return the position
                }
            }
        }
        return new int[]{-1, -1}; // Target not found
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5},
            {7, 9, 11},
            {13, 15, 17}
        };
        int target = 11;
        int[] position = linearSearch(matrix, target);
        System.out.println("Target found at row " + position[0] + ", column " + position[1]);
    }
}

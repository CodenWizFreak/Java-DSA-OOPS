import java.util.*;

public class Main {

    public static int[][] addMatrices(int[][] A, int[][] B) {
        // Write your code here
        int row = A.length;
        int col = A[0].length;
        int [][]C = new int[row][col];
        for(int i=0;i<row;i++)
            for(int j=0;j<col;j++)
                C[i][j]=A[i][j]+B[i][j];
        return C;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] A = new int[rows][cols];
        int[][] B = new int[rows][cols];

        // Input Matrix A
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        // Input Matrix B
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                B[i][j] = sc.nextInt();
            }
        }

        int[][] C = addMatrices(A, B);

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(C[i][j] + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}

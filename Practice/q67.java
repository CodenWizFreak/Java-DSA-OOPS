import java.util.*;

public class Main {

    public static int countGreaterThanPrevious(int[] arr) {
        // Write your code here
        int c=1;
        int max = arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
                c++;
            }    
        }
        return c;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(countGreaterThanPrevious(arr));

        sc.close();
    }
}

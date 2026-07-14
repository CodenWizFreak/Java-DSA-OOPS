
import java.util.*;

public class Main {

    public static void printDistinctElements(int[] arr) {
        // Write your code here.
        if (arr.length == 0) 
            return;
        // Sort in-place: takes O(N log N) time and O(1) space
        Arrays.sort(arr); 
        System.out.print(arr[0] + " ");
        for (int i = 1; i < arr.length; i++) 
            if (arr[i] != arr[i - 1]) 
                System.out.print(arr[i] + " ");
            
    }
    public static void printDistinctElements(int[] arr){ // Both TC and SC O(N)
        Set<Integer> seen = new HashSet<>();
        for(int num: arr)
            if(seen.add(num))
                System.out.print(num+" ");
        
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        printDistinctElements(arr);

        sc.close();
    }
}

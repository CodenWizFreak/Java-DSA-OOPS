import java.util.*;

public class Main {

    public static int secondLargest(int[] arr) {
        // Write your code here
        int max = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++)
            if(arr[i]>max)
                max = arr[i];
        for(int i=0;i<arr.length;i++)
            if(arr[i]>max2&&arr[i]!=max)
                max2 = arr[i];     
        return max2;
    }
    
    public static int secondLargest(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
    
        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } 
            else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }
    
        return secondLargest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(secondLargest(arr));

        sc.close();
    }
}

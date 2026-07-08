// 1 1 2 3 3 4 4
// 1 1 2 2 3 3 4
// 1 2 2 3 3 4 4 

import java.util.*;

public class Main {

    public static int findOddOccurringElement(int[] arr) { // Write your code here
       // Arrays.sort(arr); // Don't sort as it brings the complexity up to Average: O(n log n)
        int low,mid,hi;
        low=0;
        hi=arr.length-1;
        while(low<hi){
            mid=low+(hi-low)/2;
            if(mid%2==1)
                mid--;
            if(arr[mid]==arr[mid+1])
                low=mid+2;
            else
                hi=mid;
        }
        return arr[low];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(findOddOccurringElement(arr));

        sc.close();
    }
}

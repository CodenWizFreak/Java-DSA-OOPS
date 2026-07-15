import java.util.*;

public class Main {

    public static void sort012(int[] arr) {
        // Write your code here.
        
        /*
        [0, 1, 2, 1, 0, 2]  initial state: low=0, mid=0, high=5
        [0, 1, 2, 1, 0, 2]  iter 1: low=1, mid=1, high=5
        [0, 1, 2, 1, 0, 2]  iter 2: low=1, mid=2, high=5
        [0, 1, 2, 1, 0, 2]  iter 3: low=1, mid=2, high=4
        [0, 1, 0, 1, 2, 2]  iter 4: low=1, mid=2, high=3
        [0, 0, 1, 1, 2, 2]  iter 5: low=2, mid=3, high=3
        [0, 0, 1, 1, 2, 2]  iter 6: low=2, mid=4, high=3
        */
        
        int low = 0;
        int mid = 0;
        int high = arr.length - 1;
        while(mid<=high){
            if(arr[mid]==0){
                int temp = arr[low];
                arr[low] = arr[mid];
                arr[mid] = temp;
    
                low++;
                mid++;
            }
            else if (arr[mid]==1)
                mid++;
            else{
                int temp = arr[mid];
                arr[mid] = arr[high];
                arr[high] = temp;
                
                high--;
            }    
        }

    }
    
    public static void sort012(int[] arr) { //If it is not mentioned to solve in a single pass

        int zero = 0;
        int one = 0;
        int two = 0;
    
        for (int num : arr) {
            if (num == 0)
                zero++;
            else if (num == 1)
                one++;
            else
                two++;
        }
    
        int index = 0;
    
        while (zero-- > 0)
            arr[index++] = 0;
    
        while (one-- > 0)
            arr[index++] = 1;
    
        while (two-- > 0)
            arr[index++] = 2;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        sort012(arr);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if (i != n - 1) {
                System.out.print(" ");
            }
        }

        sc.close();
    }
}

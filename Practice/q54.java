import java.util.*;

public class Main {

    public static boolean canSplitWithEqualAverage(int[] arr) { //O(N) TC and O(1) SC
        // Write your code here.
        int totalSum = 0;
        for(int ele:arr)
            totalSum+=ele;
        int leftSum = 0;
        for(int i=1;i<arr.length;i++){
            leftSum+=arr[i-1];
            int rightSum = totalSum - leftSum;
            if((leftSum*(arr.length-i))==(rightSum*i))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(canSplitWithEqualAverage(arr));

        sc.close();
    }
}

import java.util.*;

public class Main {

    public static void removeDuplicates(int[] arr) { //O(n^2)
        // Write your code here
        for(int i=0;i<arr.length;i++)
        {
            boolean num = false;
            for(int j=0;j<i;j++){
                if(arr[i]==arr[j]){
                    num = true;
                    break;
                }
            }    
            if(!num)
                System.out.print(arr[i]+" ");
        }
    }
    public static void removeDuplicates(int[] arr) { //O(n)
        HashSet<Integer> set = new HashSet<>();
        for(int num:arr){
            if(set.add(num)) //set.add returns true if number is added to hashset, which means it doesn't exist in the hashset already
                System.out.print(num+" ");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        removeDuplicates(arr);

        sc.close();
    }
}

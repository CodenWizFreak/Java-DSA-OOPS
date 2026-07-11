import java.util.*;

public class Main {

    public static String reverseString(String str) { //Both TC and SC O(N)
        // Write your code here
        StringBuilder rev = new StringBuilder(); // We could also have used String here but since String is immutable, it creates objects for each update in the loop, so SC becomes O(N^2)
        for(int i=str.length()-1;i>=0;i--)
            rev.append(str.charAt(i));
        return rev.toString();    
    }
    public static String reverseString(String str) { //O(N) TC and O(1) SC
        // Write your code here //In-place swap using two pointers
        char arr[] = str.toCharArray();
        int left=0;
        int right=arr.length-1;
        while(left<right){
            char temp = arr[left];
            arr[left]=arr[right];
            arr[right]=temp;
            left++;
            right--;
        }
       return new String(arr);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        System.out.println(reverseString(str));

        sc.close();
    }
}

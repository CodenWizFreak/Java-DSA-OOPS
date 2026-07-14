import java.util.*;

public class Main {

    public static void moveZeroesToEnd(int[] packets) { // Both TC and SC O(N)
        // Write your code here.
        int[] arr = new int[packets.length];
        int j=0;
        for(int i=0;i<packets.length;i++){
            if(packets[i]!=0){
                arr[j]=packets[i];
                j++;
            }    
        }
        return arr;
    }
    
    public static void moveZeroesToEnd(int[] packets) { //TC O(N) and SC O(1)
        // Write your code here.
        // Two pointer approach with appending 0's at last
        int j=0;
        for(int i=0;i<packets.length;i++){
            if(packets[i]!=0){
                packets[j]=packets[i];
                j++;
            }    
        }
        while(j<packets.length){
            packets[j]=0;
            j++;
        }
            
        return packets;
    }
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] packets = new int[n];

        for (int i = 0; i < n; i++) {
            packets[i] = sc.nextInt();
        }

        moveZeroesToEnd(packets);

        for (int i = 0; i < n; i++) {
            System.out.print(packets[i]);
            if (i != n - 1) {
                System.out.print(" ");
            }
        }

        sc.close();
    }
}

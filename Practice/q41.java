
import java.util.*;
class Main {
    public static void main(String[] args) { //O(N^2)
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String parts[] = str.split(",");
        String values[] = parts[0].trim().split("\\s+");
        int k = Integer.parseInt(parts[1].trim());
        int[] arr = new int[values.length];
        for(int i=0;i<arr.length;i++)
            arr[i]=Integer.parseInt(values[i]);
        int n = arr.length;
        
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum+=arr[j];
                if(sum==k)
                {
                    for(int z=i;z<=j;z++)
                        System.out.print(arr[z]+" ");
                    System.out.println();    
                }
            }
        }
        sc.close();
        
    }
}

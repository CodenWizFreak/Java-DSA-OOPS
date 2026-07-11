import java.util.*;

public class Main {

    public static void printFrequency(int[] arr) {
        // Write your code here
        Map<Integer, Integer> freqmap = new LinkedHashMap<>();
        for(int num:arr)
            freqmap.put(num,freqmap.getOrDefault(num,0)+1);
        for(Map.Entry<Integer, Integer> entry: freqmap.entrySet())    
            System.out.println(entry.getKey()+" occurs "+entry.getValue()+" times");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        printFrequency(arr);

        sc.close();
    }
}

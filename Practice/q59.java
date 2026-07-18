import java.util.*;

public class Main {

    public static int countSubarraysBruteForce(int[] nums, int k) { //O(N^2) TC and O(1) SC
        // Write your code here.
        int c=0;
        for(int i=0;i<nums.length;i++){
            int sum=0;
            for(int j=i;j<nums.length;j++){
                sum+=nums[j];
                if(sum==k)
                    c++;
            }    
        }
        return c;
    }

    public static int countSubarraysOptimal(int[] nums, int k) { //Both TC and SC O(N)
        // Write your code here.
        Map<Integer,Integer> subarray = new HashMap<>();
        subarray.put(0,1);
        int prefixSum = 0;
        int count = 0;
        for(int num: nums){
            prefixSum+=num;
            if(subarray.containsKey(prefixSum-k))
                count+=subarray.get(prefixSum-k);
            subarray.put(prefixSum,subarray.getOrDefault(prefixSum,0)+1);    
        }
        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        String[] parts = input.split(",");

        String[] values = parts[0].trim().split("\\s+");

        int[] nums = new int[values.length];

        for (int i = 0; i < values.length; i++) {
            nums[i] = Integer.parseInt(values[i]);
        }

        int k = Integer.parseInt(parts[1].trim());

        System.out.println(countSubarraysBruteForce(nums, k));
        System.out.println(countSubarraysOptimal(nums, k));

        sc.close();
    }
}

import java.util.*;


class Main {
    
    static boolean checkpass(int start, int[] arr){ //O(2^N) TC and O(N) SC
        if(start>=arr.length-1) //base case: if we've reached the last index or crossed it, true
            return true;
        int maxjump=arr[start];
        for(int next=1;next<=maxjump;next++) //try every possible jump length from 1 to max no. of jumps
            if(checkpass(start+next,arr)) //recursively check if taking this jump leads to the end
                return true;
        return false;    
    }
    
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String values[] = str.trim().split(",");
        int[] arr = new int[values.length];
        for(int i=0;i<arr.length;i++)
            arr[i]=Integer.parseInt(values[i]);
        int n = arr.length;
        
        boolean result = checkpass(0,arr); //start recursion from the first index i
        System.out.println(result);
        sc.close();
    }
}



class Main {
    
    static boolean checkpass(int start, int[] arr, int[] dp){ //O(N^2) TC and O(N) SC
        if(start>=arr.length-1) //base case: if we've reached the last index or crossed it, true
            return true;
        if(dp[start]!=-1) //check if we already calculated this index before, and return it
            return dp[start]==1; //returns true if 1, else 0
        int maxjump=arr[start];
        for(int next=1;next<=maxjump;next++){ //try every possible jump length from 1 to max no. of jumps
            if(checkpass(start+next,arr,dp)){ //recursively check if taking this jump leads to the end
                dp[start]=1; //remember that this position can reach the end
                return true;
            }
        }
        dp[start]==0; //remember that this position can't reach the end
        return false;    
    }
    
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String values[] = str.trim().split(",");
        int[] arr = new int[values.length];
        for(int i=0;i<arr.length;i++)
            arr[i]=Integer.parseInt(values[i]);
        int n = arr.length;
        int dp[] = new int[n];
        Arrays.fill(dp,-1);
        boolean result = checkpass(0,arr,dp); //start recursion from the first index i
        System.out.println(result);
        sc.close();
    }
}



class Main {
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String values[] = str.trim().split(",");
        int[] arr = new int[values.length];
        for(int i=0;i<arr.length;i++)
            arr[i]=Integer.parseInt(values[i]);
        int n = arr.length;
        
        int maxReachable = 0;
        boolean possible = true;
        for(int i=0;i<n;i++){ //O(N) TC and O(1) SC
            if(i>maxReachable){ //If current index is past max reach then we're stuck
                possible = false;
                break;
            }
            maxReachable = Math.max(maxReachable,i+arr[i]); //Furthest index we can reach from the current index
            if(maxReachable>=n-1)
                break;
        }
        
        System.out.println(possible);
        sc.close();
    }

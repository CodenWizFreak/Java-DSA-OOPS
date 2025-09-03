// Leetcode Problem 268

class Solution {
    public static int missingNumber(int[] arr) {
        int n =arr.length;
        int total = n*(n+1)/2; // sum of n consecutive integers
        int sum=0;
        for (int i :arr){
            sum+=i;
        }
        return total-sum;
    }
}

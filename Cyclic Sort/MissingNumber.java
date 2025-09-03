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


// Now this one uses proper cyclic sorting logic

/*

class Solution {
     public static void main(String[] args) {
        int[] arr = {4, 0, 2, 1};
        System.out.println(missingNumber(arr));
    }

    public static int missingNumber(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i];
            if (arr[i] < arr.length && arr[i] != arr[correct]) {
                swap(arr, i , correct);
            } else {
                i++;
            }
        }

        // search for first missing number
        for (int index = 0; index < arr.length; index++) {
            if (arr[index] != index) {
                return index;
            }
        }

        // case 2
        return arr.length;
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}

*/

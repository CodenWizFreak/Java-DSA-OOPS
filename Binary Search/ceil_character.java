// Leetcode Problem 744

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        char minceil = 'z';
        int start = 0, end = letters.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (letters[mid] > target) {
                if (letters[mid] < minceil)
                    minceil = letters[mid];
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if(target==letters[letters.length-1]||target=='z'|| new String(letters).indexOf(minceil) == -1)
            return letters[0];
        return minceil;
    }
}

// Time complexity is same for both but by space complexity, more Optimized Solution is the below one (not much optimized). 

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0, end = letters.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (letters[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return letters[start%letters.length];
    }
}

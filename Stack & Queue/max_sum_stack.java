import java.util.*;

public class Solution {

    public static int twoStacks(int maxSum, int[] a, int[] b) {
        long currentSum = 0;              // Track the total sum of removed integers
        int countA = 0;                   // Pointer for stack A (how many we take)
        int countB = 0;                   // Pointer for stack B (how many we take)
        int maxScore = 0;                 // Store the best result found

        // PHASE 1: Fill using only Stack A
        while (countA < a.length && currentSum + a[countA] <= maxSum) {
            currentSum += a[countA];      // Add the top element of A to sum
            countA++;                     // Move to next element in A
        }
        maxScore = countA;                // Initial score is just the number of A elements

        // PHASE 2: Try replacing elements of A with elements of B
        while (countB < b.length) {       // Keep going until we check all of stack B
            currentSum += b[countB];      // Take the next available element from B
            countB++;                     // Increment count for stack B

            // If the sum exceeds maxSum, remove elements we took from stack A
            while (currentSum > maxSum && countA > 0) {
                countA--;                 // Decrease the count of A elements
                currentSum -= a[countA];  // Subtract the value of the removed A element
            }

            // If currentSum is valid, update maxScore if we found a better count
            if (currentSum <= maxSum) {
                maxScore = Math.max(maxScore, countA + countB); // Compare current total with max
            } else {
                break;                    // If sum > maxSum and countA is 0, we can't add more B
            }
        }

        return maxScore;                  // Return the maximum total elements removed
    }

    public static void main(String[] args) {
        // Standard input reading or sample test
        int maxSum = 10;
        int[] stackA = {4, 2, 4, 6};
        int[] stackB = {2, 1, 8, 5};
        System.out.println(twoStacks(maxSum, stackA, stackB)); // Should output 4
    }
}

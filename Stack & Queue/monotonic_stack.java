// Leetcode problem 901 Online Stock Span
class StockSpanner {
    // Stack to store pairs of [price, span count]
    // Each element represents a price and the number of consecutive days
    // (including itself) for which it was the maximum
    private Deque<int[]> stack = new ArrayDeque<>();

    /**
     * Constructor to initialize the StockSpanner
     */
    public StockSpanner() {
    }

    /**
     * Calculates the span of the stock's price for the current day
     * The span is defined as the maximum number of consecutive days
     * (starting from today and going backwards) for which the price
     * of the stock was less than or equal to today's price
     * 
     * @param price The stock price for the current day
     * @return The span of the stock's price for the current day
     */
    public int next(int price) {
        // Initialize count to 1 (current day always counts in its own span)
        int count = 1;
      
        // Pop all elements from stack that have price less than or equal to current price
        // and accumulate their spans
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            // Add the span of the popped element to current count
            count += stack.pop()[1];
        }
      
        // Push current price and its accumulated span to the stack
        stack.push(new int[] {price, count});
      
        // Return the calculated span for the current price
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */

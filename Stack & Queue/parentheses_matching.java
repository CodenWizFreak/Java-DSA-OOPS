// Leetcode problem 20

import java.util.Stack; // Must import this!

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            // If it's an opening bracket, push to stack
            if(ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } 
            else {
                // If stack is empty when we see a closing bracket, it's invalid
                if(stack.isEmpty()) return false;
                
                char top = stack.pop(); // Get the top element once
                
                // Match the specific closing bracket to its opening pair
                if(ch == ')') {
                    if(top != '(') return false;
                } else if(ch == ']') {
                    if(top != '[') return false; // Fixed: was ch == ']'
                } else if(ch == '}') {
                    if(top != '{') return false; // Fixed: was top != '('
                }
            }    
        }   
        return stack.isEmpty(); // If stack is empty, all brackets were matched     
    }
}

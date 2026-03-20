//Leetcode problem 1791

class Solution {
    public int findCenter(int[][] edges) { //O(1) time complexity
        int[] pair1=edges[0];
        int[] pair2=edges[1];
        if(pair1[0]==pair2[0]||pair1[0]==pair2[1]) //no need to check all since by definition star graph has only 1 central node where all other nodes are connected to
            return pair1[0];
        return pair1[1];    
        
    }
} 

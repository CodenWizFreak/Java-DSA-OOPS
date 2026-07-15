import java.util.*;

public class Main {

    public static int lengthOfLongestSubstring(String str) { //O(N) TC and O(min(N,K)) SC
        // Write your code here.
        //Sliding Window + HashMap
        Map<Character,Integer> lastseen = new HashMap<>();
        int left = 0;
        int maxLength = 0;
        for(int right=0;right<str.length();right++){
            char ch = str.charAt(right);
            if(lastseen.containsKey(ch) && lastseen.get(ch)>=left)
                left = lastseen.get(ch)+1;
            lastseen.put(ch,right);
            maxLength = Math.max(maxLength,right-left+1);
        }
        return maxLength;

    }
    
    public static int lengthofLongestSubstring(String str){ //O(N) TC and O(K) SC
        //Sliding Window + HashSet
        left = 0
        right = 0
        
        while (right < n) {
        
            if (s[right] not in set) {
                set.add(s[right])
                answer = max(answer, right-left+1)
                right++
            }
            else {
                set.remove(s[left])
                left++
            }
        }
        
        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        System.out.println(lengthOfLongestSubstring(str));

        sc.close();
    }
}

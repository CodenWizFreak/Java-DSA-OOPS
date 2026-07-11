import java.util.*;

public class Main {

    public static char firstNonRepeatingCharacter(String str) {
        // Write your code here
        Map<Character,Integer> map = new LinkedHashMap<>();
        for(char ch : str.toCharArray())
            map.put(ch,map.getOrDefault(ch,0)+1);
        for(Map.Entry<Character,Integer> entry : map.entrySet()){ //looping through the linked hashmap
            char ch = entry.getKey();
            int freq = entry.getValue();
            if(freq==1)
                return ch;
        }    
        return '\0';
    }
    public static char firstNonRepeatingCharacter(String str) {
        // Write your code here
        Map<Character,Integer> map = new HashMap<>();
        for(char ch : str.toCharArray())
            map.put(ch,map.getOrDefault(ch,0)+1);
        for(char ch : str.toCharArray()){ //looping through the char array
            if(map.get(ch)==1)
                return ch;
        }    
        return '\0';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        char ans = firstNonRepeatingCharacter(str);

        if (ans == '\0')
            System.out.println(-1);
        else
            System.out.println(ans);

        sc.close();
    }
}

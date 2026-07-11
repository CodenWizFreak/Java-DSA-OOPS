import java.util.*;

public class Main {

    public static char mostFrequentCharacter(String str) {
        // Write your code here
        Map<Character,Integer> map = new HashMap<>();
        for(char ch : str.toCharArray())
            map.put(ch,map.getOrDefault(ch,0)+1);
        char ans = '\0';
        int maxFreq = 0;
        for (Map.Entry<Character,Integer> entry: map.entrySet()){
            char ch = entry.getKey();
            int freq = entry.getValue();
            
            if(freq>maxFreq || (freq==maxFreq && ch<ans)){
                maxFreq = freq;
                ans = ch;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        System.out.println(mostFrequentCharacter(str));

        sc.close();
    }
}

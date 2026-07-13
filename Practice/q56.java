import java.util.*;

public class Main {

    public static void countItems(String inventory) {
        // Write your code here.
        for(char ch: inventory.toCharArray()){
            if(Character.isDigit(ch)){
                System.out.println("Invalid");
                return;
            }
        }
        String[] words = inventory.trim().split("\\s+"");
        Map<String, Integer> map = new LinkedHashMap<>();
        for(String word: words)
            map.put(word,map.getOrDefault(word,0)+1);
        for(Map.Entry<String, Integer> entry: map.entrySet())    
            System.out.println(entry.getKey()+" "+entry.getValue());
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String inventory = sc.nextLine();

        countItems(inventory);

        sc.close();
    }
}

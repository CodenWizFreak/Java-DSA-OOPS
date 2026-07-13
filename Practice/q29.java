import java.util.*;

public class Main {

    public static String areAnagrams(String str1, String str2) {
        // Write your code here.
        if(str1.length()!=str2.length())
            return "Not Anagram";
        int []freq = new int[256]; //O(1) SC
        for(int i=0;i<str1.length();i++){ //O(N) TC
            freq[str1.charAt(i)]++;
            freq[str2.charAt(i)]--;
        }
        for(int k:freq)
            if(k!=0)
                return "Not Anagram";
                
        return "Anagram!";

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str1 = sc.nextLine();
        String str2 = sc.nextLine();

        System.out.println(areAnagrams(str1, str2));

        sc.close();
    }
}

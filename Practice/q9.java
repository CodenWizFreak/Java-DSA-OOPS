import java.util.*;

public class Main {

    public static void countCharacters(String str) {
        // Write your code here
        int vowels = 0;
        int consonants = 0;
        int spaces = 0;
        int special = 0;
        str = str.toLowerCase();
    
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
    
            if (ch >= 'a' && ch <= 'z') {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
                    vowels++;
                else
                    consonants++;
            }
            else if (ch == ' ') {
                spaces++;
            }
            else {
                special++;
            }
        }
    
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
        System.out.println("Spaces: " + spaces);
        System.out.println("Special: " + special);
    }
 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        countCharacters(str);

        sc.close();
    }
}

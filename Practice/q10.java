import java.util.*;

public class Main {

    public static boolean isPalindrome(String str) { //Can be done using two-pointer method too
        // Write your code here
        StringBuilder reversed = new StringBuilder();

        for (int i = str.length() - 1; i >= 0; i--) {
            reversed.append(str.charAt(i));
        }
    
        return str.equalsIgnoreCase(reversed.toString());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        System.out.println(isPalindrome(str) ? "YES" : "NO");

        sc.close();
    }
}

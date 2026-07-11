import java.util.*;

public class Main {

    public static String reverseWords(String sentence) { //O(n) both TC and SC
        // Write your code here
        String words[] = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String word:words){
            StringBuilder rev = new StringBuilder(word);
            sb.append(rev.reverse().append(" "));
        }
        return sb.toString().trim();
    }
    public static String reverseWords(String sentence){ //O(n) both TC and SC
        StringTokenizer st = new StringTokenizer(sentence);
        StringBuilder sb = new StringBuilder();
        while(st.hasMoreToken()){
            String word = st.nextToken();
            for(int i = word.length()-1;i>=0;i--) 
                sb.append(word.charAt(i));
            if(st.hasMoreTokens())
                sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String sentence = sc.nextLine();

        System.out.println(reverseWords(sentence));

        sc.close();
    }
}

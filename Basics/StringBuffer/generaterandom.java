import java.util.*;
class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size of string:");
        int n=sc.nextInt();
        System.out.println(getstring(n));
    }
    static String getstring(int n)
    {
        StringBuffer sb=new StringBuffer(n);
        Random rand=new Random();
        for(int i=1;i<=n;i++)
        {
            sb.append((char)(97+(int)(rand.nextFloat()*26)));
        }
        return sb.toString();    
    }
}

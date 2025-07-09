public class Main {
    static void func(int n) // this is a bonus one. finds the distance from the walls 
    {
        n=n*2;
        int i,j;
        for(i=0;i<=n;i++)
        {
            for(j=0;j<=n;j++)
            {
                int min=Math.min(Math.min(i,j),Math.min((n-i),(n-j)));
                System.out.print(min+" ");
            }
            System.out.println();
        }
    }
    static void func2(int n) // this is the main one to find distance from the centre.
    {   
        int org_n=n;
        n=n*2;
        int i,j;
        for(i=0;i<=n;i++)
        {
            for(j=0;j<=n;j++)
            {
                int min=org_n - Math.min(Math.min(i,j),Math.min((n-i),(n-j)));
                System.out.print((min+1)+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int n = 4;
        func(n);
        System.out.println();
        func2(n);
    }
}

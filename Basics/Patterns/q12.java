    static void func1(int n)
    {
        for(int i=1;i<=n;i++)
        {   
            for(int j=2;j<=i;j++)
                System.out.print(" ");
            for(int j=1;j<=(n-i+1);j++)
                System.out.print("* ");
            System.out.println();    
        }
    }
    static void func2(int n)
    {
        for(int i=1;i<=n;i++)
        {   
            for(int j=1;j<=(n-i);j++)
                System.out.print(" ");
            for(int j=1;j<=i;j++)
                System.out.print("* ");
            System.out.println();    
        }
    }
    
    public static void main(String[] args) {
        func1(5);
        func2(5);
    }

class SoE {
    public static void main(String[] args) {
        int n=40;
        boolean arr[]=new boolean[n+1]; //the last number is inclusive in checking, hence n+1
        sieve(n,arr);
    }
    static void sieve(int n, boolean primes[])
    {
        for(int i=2;i*i<=n;i++) //check till sqrt n for better complexity
        {
            //initally the whole array is initialized false
            if(!primes[i]) //then we do it to prevent checking the already non-prime numbers set to true, again.
            {
                for(int j=2*i;j<=n;j+=i)
                {
                    primes[j]=true; //removing multiples of prime numbers. example: 3x2=6. so set 6's index as true to avoid checking it anymore later on, since 6 is already non-prime.
                }
            }    
        }
        
        for(int i=2;i<primes.length;i++)
            if(!primes[i])
                System.out.println(i);
    }
}

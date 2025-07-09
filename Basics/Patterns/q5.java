for(int i=1; i<n*2; i++)
        {
            int col= i>n ? 2*n-i : i;
            for(j=1; j<=col; j++)
                System.out.print("*");
            System.out.println();
        }

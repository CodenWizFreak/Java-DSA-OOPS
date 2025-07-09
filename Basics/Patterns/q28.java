for (int i = 1; i < n * 2; i++) 
        {
            int col = i > n ? 2 * n - i : i;
            for (int s = 0; s < n - col; s++) 
                System.out.print(" ");
            for (int j = 0; j < col; j++) 
                System.out.print("* ");
            System.out.println();
        }


// If I remove the space from after *, the pattern will be the mirror image of q5.java

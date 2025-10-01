// Counting Sort is mainly used when the number of array elements or the highest number in the element is small

class CountSort {
    
    static int findlarge(int arr[])
    {
        int largest=arr[0];
        for(int i=1;i<arr.length;i++)
            if(arr[i]>largest)
                largest=arr[i];
        return largest;
    }
    
    static void newarr(int l,int arr[]) //arr is the old array
    {
        int newArray[]=new int[l+1]; //newArray is the new array
        for(int i=0;i<arr.length;i++) //traversing the old array 
            newArray[arr[i]]++;
        
        System.out.println("\nFrequency Array:");
        for(int i=0;i<newArray.length;i++)
            System.out.print(newArray[i]+" ");
            
        int index=0;
        for(int i=0;i<newArray.length;i++)//traversing the new array
        {
            while(newArray[i]>0)
            {
                arr[index++]=i;
                newArray[i]--;
            }
        }
        
        System.out.println("\nSorted Array:");
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
            
    }
    public static void main(String[] args) {
        int arr[]={3,4,1,2,3,5,2,8};
        System.out.println("Original Array:");
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" ");
        newarr(findlarge(arr),arr);
    }
}

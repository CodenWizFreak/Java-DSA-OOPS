// Works for both ascending and descending sorted arrays
class BinaryAgnostic 
{
    static int binary(int[] arr, int target) 
    {
        if (arr == null || arr.length == 0)
            return -1;
        int start = 0;
        int end = arr.length - 1;
        boolean asc = arr[start] < arr[end];
        while (start <= end) 
        {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target)
                return mid;
            if (asc) 
            {
                if (target < arr[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            } 
            else 
            {
                if (target > arr[mid])
                    end = mid - 1;
                else
                    start = mid + 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) 
    {
        int[] arr = {59, 43, 39, 30, 28, 28, 14, 8, 4, 1}; // You can take user input for array too
        int target = 14; // You can take user input too
        int index = binary(arr, target);
        if (index != -1)
            System.out.println("Target found at " + index + "th index");
        else
            System.out.println("Target not found");
    }
}

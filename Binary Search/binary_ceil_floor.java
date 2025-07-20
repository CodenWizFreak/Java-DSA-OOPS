import java.util.Scanner;

class Main {
    static int ceil(int arr[], int x) {
        int minceil = Integer.MAX_VALUE;
        int start = 0, end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] >= x) {
                if (arr[mid] <= minceil)
                    minceil = arr[mid];
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return minceil;
    }

    static int floor(int arr[], int x) {
        int maxfloor = Integer.MIN_VALUE;
        int start = 0, end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] <= x) {
                if (arr[mid] >= maxfloor)
                    maxfloor = arr[mid];
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return maxfloor;
    }

    public static void main(String[] args) {
        int arr[] = {4, 5, 7, 9, 11, 15, 16, 18, 24, 30};
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter target number: ");
        int x = sc.nextInt();

        int floor = floor(arr, x);
        int ceil = ceil(arr, x);

        System.out.println("For x = " + x);
        System.out.println("Floor: " + (floor != Integer.MIN_VALUE ? floor : "Not found"));
        System.out.println("Ceil: " + (ceil != Integer.MAX_VALUE ? ceil : "Not found"));

        sc.close();
    }
}


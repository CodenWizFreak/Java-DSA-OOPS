// Enter a target number and find the possible throws required to achieve that number with a single dice

class Main {
    public static void main(String[] args) {
        dice("",3);
    }
    static void dice(String p,int target)
    {
        if(target==0)
        {
            System.out.println(p);
            return;
        }
        for(int i=1; i<=6 && i<=target; i++)
            dice(p+i,target-i);
    }
}

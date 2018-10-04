public class Calculate
{
    public int arr[];

    // public int result(){
    //     return arr[];
    // }
    public static int result(int x)
    {
        int arr[] = new int[x];
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = 2*x;
            System.out.println(arr[i]);
        }
        return arr[x-1];
    }
}
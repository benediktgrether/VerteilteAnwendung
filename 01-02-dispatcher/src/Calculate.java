public class Calculate extends Thread
{
    public int value = 0;
    public F f;
    public Result results;
    public int arr[];

    public Calculate(F f, int value, Result results)
    {
        this.f = f;
        this.value = value;
        this.results = results;
    }
    public void run()
    {
        int newValue = f.f(value);
        results.insert(newValue);
    }

    // public int result(){
    //     return arr[];
    // }
    // public static int result(int x)
    // {
    //     int arr[] = new int[x];
    //     for (int i = 0; i < arr.length; i++)
    //     {
    //         arr[i] = 2*x;
    //         System.out.println(arr[i]);
    //     }
    //     return arr[x-1];
    // }
}
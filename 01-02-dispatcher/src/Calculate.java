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
}
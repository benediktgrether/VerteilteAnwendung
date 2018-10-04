public class Result
{
    private static int values[];
    private static int x = 0;

    public Result(int lenght)
    {
        values = new int[lenght];
    }
    
    public synchronized void insert (int value)
    {
        values[x] = value;
        x++;

        if (x == values.length)
        {
            notifyAll();
        }
    }

    public synchronized int[] get()
    {
        try
        {
            wait();
        }
        catch(InterruptedException t)
        {
            System.out.println("ERROR");
        }
        return values;
    }
}
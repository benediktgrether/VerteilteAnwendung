
public class Dispatcher 
{

	public static void main(String[] args) 
	{
		int[] results = execute(new Function(), 10);
		System.out.print("Results: ");
		for (int i : results)
		{
			System.out.print(i + ", ");
		}
	}

	public static int[] execute(F f, int n)
	{
		Result result = new Result(n);
		for(int i = 0; i < n; i++)
		{
			Calculate c = new Calculate(f, i, result);
			c.start();
		}
		return result.get();
	}
}

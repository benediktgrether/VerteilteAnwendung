public class EggThread extends Thread 
{

	public int ms;
	public String output;

	public void start() {
		schlafen(ms);
		System.out.println(output);
	}
	
	public static void schlafen(int m) {
		try {
			Thread.sleep(1000 * m);
		} catch (InterruptedException t) {
			System.out.println("Error");
		}
	}
}


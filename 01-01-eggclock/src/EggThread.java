public class EggThread extends Thread 
{

	public int ms;
	public String output;

	public void start() {
		sleep(ms);
		System.out.println(ms + " " + output);
	}
	
	public static void sleep(int m) {
		try {
			Thread.sleep(1000 * m);
		} catch (InterruptedException t) {
			System.out.println("Error");
		}
	}
}


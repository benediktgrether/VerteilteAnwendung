public class EggClock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		eggclock(4, "running");
		eggclock(3, "running");
		eggclock(2, "running");
		eggclock(1, "running");
		eggclock(0, "finished");
	}
	
	public static void eggclock(int ms, String output)
	{
		EggThread t = new EggThread();
		t.ms = ms;
		t.output = output;
		t.start();
	}
}
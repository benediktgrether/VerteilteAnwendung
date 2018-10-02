public class EggClock {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		eieruhr(4, "Test1");
		eieruhr(2, "Test2");
		eieruhr(1, "Test3");
	}
	
	public static void eieruhr(int ms, String output)
	{
		EggThread t = new EggThread();
		t.ms = ms;
		t.output = output;
		t.start();
	}

	
}
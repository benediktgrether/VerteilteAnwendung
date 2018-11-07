import java.util.Vector;
import java.util.Scanner;


/*public class TicketsSale<Ticket> {

	Vector<Ticket> ticketsList = new Vector<Ticket>();
	*/

public class TicketsSale {

	private Ticket ticket;
	private Ticket []ticketarray = new Ticket[100];
	private static boolean runTime = true;

	public TicketsSale()
	{
		for (int i = 0; i < ticketarray.length; i++) {
			ticketarray[i] = new Ticket(i + 1 );
		}
	}
	
	public static void main(String[] args) {
		TicketsSale tickets = new TicketsSale();
		tickets.runTimeTicket(tickets);
	}
	
	public void runTimeTicket(TicketsSale tickets)
	{
		while(runTime = true)
		{
			//consoleInput();

			switch(consoleInput())
			{
				case "overview": case "o":
					System.out.println("Test");
					tickets.overviewTickets();
					break;
			}

			//System.out.println(tickets.overviewTickets(1));
		}
	}
	
	private String consoleInput()
	{
		System.out.println("Overview O,");
		System.out.print("Your input >");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		return input.toLowerCase();
	}


	public void overviewTickets()
	{
		int counter = 0;
		for (int i = 0; i < ticketarray.length; i++) {
			Ticket tickets = ticketarray[i];
			System.out.print(tickets.nummer + " " + tickets.status + " | " );					
			counter ++;
			if(counter == 10)
			{
				System.out.println();
				counter = 0;
			}
		}		
	}
	
	public void sellFreeTickets()
	{
		
	}
	
	
	public void reservationTickets()
	{
		
	}
	
	public void sellReservationTickets()
	{
		
	}
	
	public void cancellationTickets()
	{
		
	}
	
	public void clearReservation()
	{
		
	}
	

}

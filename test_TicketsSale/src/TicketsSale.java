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
			System.out.println("Overview O,");
			System.out.print("Your input >");
			Scanner sc = new Scanner(System.in);
			String input = sc.nextLine();
			sc.close();

			switch(input.toLowerCase())
			{
				case "overview": case "o":
					System.out.println("Test");
					//System.out.print(tickets.overviewTickets());
					break;
			}

			//System.out.println(tickets.overviewTickets(1));
		}
	}


	public TicketStatus overviewTickets()
	{
		for (int i = 0; i < ticketarray.length; i++) {
			return ticket.status;	
		}
		return ticket.status;
		
		
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

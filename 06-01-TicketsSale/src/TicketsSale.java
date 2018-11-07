import java.util.Vector;


/*public class TicketsSale<Ticket> {

	Vector<Ticket> ticketsList = new Vector<Ticket>();
	*/

public class TicketsSale {
	
	public static Ticket ticket;
	public static Ticket []ticketarray = new Ticket[100];
	
	public static void main(String[] args) {
		TicketsSale tickets = new TicketsSale();
		System.out.println(tickets.overviewTickets(1));
	}
	
	public Ticket overviewTickets(int number)
	{
		Ticket tickets = ticketarray[number];
		if(tickets.status.equals(tickets.status.FREE))
		{
			System.out.println(tickets.status);
		}
		else
		{
			System.out.println(tickets.status);
		}
		return tickets;
		
	}
	/*public Ticket overviewTickets()
	{	
		for (int i = 0; i < ticketarray.length; i++) {
			ticketarray[i].nummer = 1;
			//ticketarray[i].status = TicketStatus.FREE;
			//ticketarray[i].status = F;
			//System.out.println(ticketarray[i].status);
			
		}
		System.out.println(ticketarray[2].status);
		return ticket;
		
	}
	*/
	
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

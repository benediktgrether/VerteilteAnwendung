
public class Ticket {

	int nummer;
	TicketStatus status;
	
	public Ticket(int nummer) {
		
		this.nummer = nummer;
		this.status = TicketStatus.FREE;
		
	}
	
}

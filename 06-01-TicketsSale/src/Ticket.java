
public class Ticket {

	int nummer;
	String lastName;
	TicketStatus status;
	
	public Ticket(int nummer, String lastName) {
		
		this.nummer = nummer;
		this.lastName = lastName;
		this.status = TicketStatus.FREE;
		
	}
	
}


public class Ticket {

	int nummer;
	String lastName;
	TicketStatus status;
	
	
	public Ticket(int nummer, String lastName, TicketStatus status) {
		
		this.nummer = nummer;
		this.lastName = lastName;
		this.status = status;
		
	}

	public Object toHTML() {
		
		StringBuffer sb = new StringBuffer();
		sb.append("<div");
		sb.append(" class='seat "  );
		sb.append(status.getCssClass());
		sb.append(" popover' >");
		sb.append(nummer);
		sb.append("</div>");
		return sb.toString();
	}
	
}

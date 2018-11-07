
public enum TicketStatus {
	
	FREE('F'), RESERVED('R'), SOLD('S');
	
	private char status;
	
	private TicketStatus(char status) {
		
		this.status = status;
		
	}
	public char getStatus() {
		
		return this.status;
		
	}
	
}

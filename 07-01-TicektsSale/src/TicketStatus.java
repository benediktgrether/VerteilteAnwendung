
public enum TicketStatus {
	
	FREE('F',"free"), RESERVED('R',"reserved"), SOLD('S',"sold");
	
	private char status;
	private String cssClass;
	
	private TicketStatus(char status, String css) {
		
		this.status = status;
		this.cssClass = css;
		
	}
	
	public String getCssClass() {
		
		return this.cssClass;
		
	}
	public char getStatus() {
		
		return this.status;
		
	}
	
	public static TicketStatus getByLetter(char id) {
		for(TicketStatus status : values()) {
			if(status.status == id)
				return status;
		}
		return null;
	}
	
}

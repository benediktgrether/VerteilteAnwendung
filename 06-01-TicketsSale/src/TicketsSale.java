//import java.util.Vector;
import java.util.Scanner;


/*public class TicketsSale<Ticket> {

	Vector<Ticket> ticketsList = new Vector<Ticket>();
	*/

public class TicketsSale {

	private Ticket []ticketarray = new Ticket[10];
	private static boolean runTime = true;
	private boolean open = true;

	public TicketsSale()
	{
		for (int i = 0; i < ticketarray.length; i++) {
			ticketarray[i] = new Ticket(i + 1, null );
		}
	}
	
	public static void main(String[] args) {
		TicketsSale tickets = new TicketsSale();
		tickets.runTimeTicket(tickets);
	}
	
	public void runTimeTicket(TicketsSale tickets)
	{
		while(runTime == true)
		{
			//consoleInput();
			System.out.println("Overview O, Sell s, Reservation r, Buyreservation br, Cancle c, DebugClear clear ");
			switch(consoleInput().toLowerCase())
			{
				case "overview": case "o":
					tickets.overviewTickets();
					break;
				
				case "sell": case "s":
					tickets.buyFreeTickets(consoleInput());
						break;
				
				case "reservation": case "r":
					tickets.reservTickets(consoleInput());
					break;
					
				case "sellreservation": case "sr":
					tickets.buyReservTickets(consoleInput());
					break;
					
				case "cancel": case "c":
					tickets.cancelTickets(consoleInput());
					break;
					
				case "clear":
					tickets.clearReservation();
					break;
					
				case "quit": case "q":
					runTime = false;
					break;
			}

			//System.out.println(tickets.overviewTickets(1));
		}
	}
	
	private String consoleInput()
	{
		System.out.print("Your input > ");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		return input;
	}

	private int inputValue(String seatNumber) {
		try {
			int value = Integer.parseInt(seatNumber);
			return value;
		}
		catch(Exception E)
		{
			System.out.println("Wrong Input");
			System.out.println();
		}
		
		return -1;
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
	
	public TicketStatus buyFreeTickets(String seatNumber)
	{
			int value = inputValue(seatNumber);
			try {
				if(ticketarray[value - 1].status.equals(TicketStatus.FREE) && open == true)
				{
					System.out.println("Your Seat is booked");
					System.out.println();
					return ticketarray[value - 1].status = TicketStatus.SOLD;
				}
				else if(open == false)
				{
					System.out.println("Reservation closed");
				}else {
					System.out.println("Seat not free");
					System.out.println();
				}
			}
			catch(Exception E)
			{
				System.out.println("Array out of index");
				System.out.println();
			}
		return null;
	}
	
	
	public TicketStatus reservTickets(String seatNumber)
	{
		int value = inputValue(seatNumber);
		System.out.print("Your Name: ");
		String lastName = consoleInput();
		try 
		{
			if(ticketarray[value-1].status.equals(TicketStatus.FREE) && open == true)
			{
				System.out.println("Your Seat is reserved");
				ticketarray[value - 1].status = TicketStatus.RESERVED;
				ticketarray[value - 1].lastName = lastName;
				return ticketarray[value - 1].status;
			}
			else if(ticketarray[value-1].status.equals(TicketStatus.SOLD))
			{
				System.out.println("Seat already sold");
			}
			else if(open == false)
			{
				System.out.println("Reservation closed");
			}
			else
			{
				System.out.println("Seat already reserved");
			}
		}
		catch(Exception E)
		{
			System.out.println("Array out of index");
			System.out.println();
		}
		return null;
	}
	
	public TicketStatus buyReservTickets(String seatNumber)
	{
		int value = inputValue(seatNumber);
		System.out.print("Your Name: ");
		String lastName = consoleInput();
		try 
		{
			if((ticketarray[value-1].status.equals(TicketStatus.RESERVED) 
					&& open == true) && (ticketarray[value-1].lastName.equals(lastName)))
			{
				System.out.println("You bought your Seat");
				return ticketarray[value - 1].status = TicketStatus.SOLD;
			}
			else if(ticketarray[value-1].status.equals(TicketStatus.FREE))
			{
				System.out.println("Seat is Free");
			}
			else
			{
				System.out.println("Seat already sold");
			}
		}
		catch(Exception E)
		{
			System.out.println("Array out of index");
			System.out.println();
		}
		return null;
	}
	
	public TicketStatus cancelTickets(String seatNumber)
	{
		int value = inputValue(seatNumber);
		try 
		{
			if(ticketarray[value-1].status.equals(TicketStatus.SOLD) || ticketarray[value-1].status.equals(TicketStatus.RESERVED))
			{
				System.out.println("You canceld your Seat");
				ticketarray[value - 1 ].lastName = null;
				return ticketarray[value - 1].status = TicketStatus.FREE;
			}
			else
			{
				System.out.println("Seat is already free");
			}
		}
		catch(Exception E)
		{
			System.out.println("Array out of index");
			System.out.println();
		}
		return null;
	}
	
	public boolean clearReservation()
	{
		for(int i = 0; i < ticketarray.length; i++)
		{
		try 
			{
				if(ticketarray[i].status.equals(TicketStatus.RESERVED))
				{
					//open = false;
					ticketarray[i].status = TicketStatus.FREE;
				}
			}
			catch(Exception E)
			{
				System.out.println("Array out of index");
				System.out.println();
			}
		}
		return open = false;
	}
	

}

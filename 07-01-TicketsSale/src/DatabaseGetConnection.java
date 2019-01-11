import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DatabaseGetConnection {
	
	public DataSource datasource;
	public TicketsSale ticketSale = null;
	
	public DatabaseGetConnection(DataSource datasource, TicketsSale ticketSale) {
		Connection connection = null;
		this.ticketSale = ticketSale; 
		
		try 
		{
			
			this.datasource = datasource;
			connection = this.datasource.getConnection();
			Statement s = connection.createStatement();
			ResultSet rs = s.executeQuery("Select * from tickets");
			if(rs.next()) {
				System.out.println(rs.getInt("id"));
			}
			
			System.out.println("Datenbank erfolgreich getestet");
			
		}
		catch(Exception e)
		{
			System.out.println("Datenbank Test nicht erfolgreich");
		}
		finally 
		{
			try { connection.close(); } catch (SQLException el) { }
		}
	}
	
	public void fetchTicketsSale() {
		Connection connection = null;
		try {
			connection = this.datasource.getConnection();	
			Statement s = connection.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM ticketSales WHERE id = '1'");
			if(rs.next())
			{
				boolean acceptReservation = rs.getBoolean("accept_reservation");
			}
			
			
			s = connection.createStatement();
			rs = s.executeQuery("SELECT * FROM tickets");
			
			while(rs.next()) {
				this.ticketSale.ticketarray[rs.getInt("seat_number")] = new Ticket(rs.getInt("seat_number") + 1, rs.getString("reservation_name"), TicketStatus.getByLetter(rs.getString("status").charAt(0)) );
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void updateTickets(Ticket[] tickets) {
		Connection connection = null;
		try {
			connection = this.datasource.getConnection();
			PreparedStatement psUpdateTicket = connection.prepareStatement("UPDATE tickets SET status = ?, reservation_name = ? WHERE seat_number = ?");
			for(Ticket ticket : tickets) {
				psUpdateTicket.setString(1, ticket.status.getStatus() + "");
				psUpdateTicket.setString(2, ticket.lastName);
				psUpdateTicket.setInt(3, ticket.nummer);
				psUpdateTicket.execute();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally { try { connection.close(); } catch (SQLException e) { e.printStackTrace(); } }
	}
	
	public TicketsSale updateTicketSale(TicketsSale ticketSale) {
		Connection connection = null;
		
		try {
			connection = this.datasource.getConnection();
			Statement s = connection.createStatement();
			s.executeUpdate("UPDATE TicketSales SET accept_reservations = b'" + (ticketSale.acceptReservations ? 1 : 0) + "' WHERE seat_number = '" + ticketSale.ticketarray + "'");
		} catch (Exception e) {
			e.printStackTrace();
		} finally { try { connection.close(); } catch (SQLException e) { e.printStackTrace(); } }
		
		return ticketSale;
	}
}

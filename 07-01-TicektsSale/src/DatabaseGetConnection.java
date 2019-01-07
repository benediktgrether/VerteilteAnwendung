import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DatabaseGetConnection {
	
	private DataSource datasource;
	
	public DatabaseGetConnection() {
		Connection connection = null;
		
		try 
		{
			Context ic = new InitialContext();
			this.datasource = (DataSource) ic.lookup("java:/comp/env/jdbc/KartenverkaufDB");
			connection = this.datasource.getConnection();
			Statement s = connection.createStatement();
			ResultSet rs = s.executeQuery("Select * from TicketsSales");
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

}

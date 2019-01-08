import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DatabaseGetConnection {
	
	private DataSource datasource;
	
	public DatabaseGetConnection(DataSource datasource) {
		Connection connection = null;
		
		try 
		{
			
			this.datasource = datasource;
			connection = this.datasource.getConnection();
			Statement s = connection.createStatement();
			ResultSet rs = s.executeQuery("Select * from kartenverkauf");
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

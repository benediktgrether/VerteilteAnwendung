

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

/**
 * Application Lifecycle Listener implementation class TicketSaleListener
 *
 */
@WebListener
public class TicketSaleListener implements ServletContextListener {


	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    	System.out.println("Server stopped");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
		System.out.println("Server started");
		TicketsSale ts = new TicketsSale();
		try {
		Context ic = new InitialContext();
		DataSource datasource;
		
			datasource = (DataSource) ic.lookup("java:/comp/env/jdbc/KartenverkaufDB");
			DatabaseGetConnection db = new DatabaseGetConnection(datasource);
			sce.getServletContext().setAttribute("ts", ts);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
    }
	
}

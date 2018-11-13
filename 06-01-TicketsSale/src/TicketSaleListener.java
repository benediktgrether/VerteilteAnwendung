

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

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
		sce.getServletContext().setAttribute("ts", ts);
		
    }
	
}

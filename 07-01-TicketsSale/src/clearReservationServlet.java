

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exception.TicketSaleException;

/**
 * Servlet implementation class HtmlTicketsSale
 */
@WebServlet("/clearReservation")
public class clearReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void service (HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		
		try {
			
			TicketsSale ts = (TicketsSale) getServletContext().getAttribute("ts");
			
		    ts.clearReservation();
			
            request.getRequestDispatcher("/Operation_erfolgreich_ausgefuehrt.html").forward(request, response);
            
		}catch(TicketSaleException e){
			request.setAttribute("error", e);
			request.getRequestDispatcher("/Fehler.html").forward(request, response);
		}
	}
}

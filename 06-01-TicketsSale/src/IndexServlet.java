import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		TicketsSale ts = (TicketsSale) getServletContext().getAttribute("ts");
		String tsString = ts.toHTML();
		
		String b = "<p> <a href='./Verkauf_eines_freien_Tickets.html's>Verkauf eines freien Tickets</a> </p>"+
	    "<p> <a href=''>Reservierung eines Tickets</a> </p>"+
	    "<p> <a href=''>Verkauf eines reservierten Tickets</a> </p>"+
	    "<p> <a href=''>Stornierung eines Tickets</a> </p>"+
	    "<p> <a href=''>Reservierungen aufheben</a> </p>";

		response.getWriter().write(tsString+"<br>"+b);
		
	}
	
	

}

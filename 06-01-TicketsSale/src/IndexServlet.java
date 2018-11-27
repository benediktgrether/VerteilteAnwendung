import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		TicketsSale ts = (TicketsSale) getServletContext().getAttribute("ts");
		String tsHead = ("<!DOCTYPE html><html><head><meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\">\r\n" + 
                "<link rel=\"stylesheet\" href=\"/TicketsSale/main.css\" type=\"text/css\" /></head><body><ul>");
		String tsString = ts.toHTML();
		
		String b = "<p> <a href='./Verkauf_eines_freien_Tickets.html's>Verkauf eines freien Tickets</a> </p>"+
	    "<p> <a href='./Reservierung_eines_Tickets.html'>Reservierung eines Tickets</a> </p>"+
	    "<p> <a href='./Verkauf_eines_reservierten_Tickets.html'>Verkauf eines reservierten Tickets</a> </p>"+
	    "<p> <a href='./Stornierung_eines_Tickets.html'>Stornierung eines Tickets</a> </p>"+
	    "<p> <a href='./Reservierungen_aufheben.html'>Reservierungen aufheben</a> </p>";

		response.getWriter().write(tsHead + tsString+"<br>"+b);
		
	}
	
	

}

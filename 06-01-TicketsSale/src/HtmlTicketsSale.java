

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HtmlTicketsSale
 */
@WebServlet("/HtmlTicketsSale")
public class HtmlTicketsSale extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void service (HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		try {
			TicketSaleListener model = new TicketSaleListener();


		}catch(Exception e){
			request.getRequestDispatcher("/Fehler.html").forward(request, response);
		}
	}
}

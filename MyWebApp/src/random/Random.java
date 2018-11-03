package random;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Random")
public class Random extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void service (HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		try {
			int a = Integer.parseInt(request.getParameter("a"));
			int b =Integer.parseInt(request.getParameter("b"));
			int rndNmbrA = RandomNumberA(a, b);
			int rndNmbrB = RandomNumberB(b, a);
			if(rndNmbrA < rndNmbrB)
				{
					response.setContentType("text/html");
					response.getWriter().println(a + "*" + b + " = " + (a*b));
				}else{
					request.getRequestDispatcher("/invalidvalues.html").forward(request, response);
				}
			}catch(Exception e){
			request.getRequestDispatcher("/invalidvalues.html").forward(request, response);
		}
		
	}
	public int RandomNumberA(int numberA, int numberB)
	{
		int randomNumber = getRandomNumber(numberA, numberB);
		if(numberA <= randomNumber)
		{
			return randomNumber;
		}else {
		
			return numberA;
		}
		
	}
	public int RandomNumberB(int numberB, int numberA)
	{
		int randomNumber = getRandomNumber(numberA, numberB);
		if(numberB >= randomNumber)
		{
			return randomNumber;
		}else {
		
			return numberB;
		}
		
	}
	
	private int getRandomNumber(int numberA, int numberB)
	{
		int randomNumber = (int )(Math.random() *(numberB - numberA) + numberA);
		return randomNumber;
	}
}

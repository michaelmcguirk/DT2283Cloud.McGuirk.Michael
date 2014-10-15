package ie.mydit.mcguirk.michael;

import java.io.IOException;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class MultiplicationServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		resp.setContentType("text/plain");
		
		String AString, BString;
		int a, b, total;
		a=b=0;
		
		AString = req.getParameter("A");
		BString = req.getParameter("B");
		if(AString != null && BString != null)
		{
			if(tryParse(AString))
			{
				a = Integer.parseInt(AString);
			}
			else
			{
				resp.getWriter().println("A is not an integer");
			}
			if(tryParse(BString))
			{
				b = Integer.parseInt(BString);
			}
			else
			{
				resp.getWriter().println("B is not an integer");
			}
			total = a * b;
			resp.getWriter().println(a + " * " + b + " = " + total);
			
		}
		else
		{
			AString = getServletConfig().getInitParameter("A");
			BString = getServletConfig().getInitParameter("B");
			a = Integer.parseInt(AString);
			b = Integer.parseInt(BString);
			total = a * b;
			resp.getWriter().println(a + " * " + b + " = " + total);
		}
	}
	
	public boolean tryParse(String s)
	{
		try
		{
			int i = Integer.parseInt(s);
		}
		catch(NumberFormatException e)
		{
			return false;
		}
		return true;
	}
}

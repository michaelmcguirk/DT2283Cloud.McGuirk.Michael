/*
 * Michael McGuirk, D13123389 - DT228/3
 * Cloud Computing. Lab 5. 15/10/2014
 * Multiplication servlet to take multiply 2 values supplied by the user or default values in XML file.
 */
package ie.mydit.mcguirk.michael;

import java.io.IOException;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class MultiplicationServlet extends HttpServlet
{
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException
	{
		resp.setContentType("text/plain");

		String AString, BString;
		int a, b, total;
		a = b = 0;

		AString = req.getParameter("A");
		BString = req.getParameter("B");	//take parameters from user.
		if (AString != null && BString != null)	
		{
			if (tryParse(AString))
			{
				a = Integer.parseInt(AString);
			} else
			{
				resp.getWriter().println("A is not an integer");
			}
			if (tryParse(BString))
			{
				b = Integer.parseInt(BString);
			} else
			{
				resp.getWriter().println("B is not an integer");
			}
			total = a * b;
			resp.getWriter().println(a + " * " + b + " = " + total);

		} else	//if either of the users input is null, revert to values in XML file.
		{
			AString = getServletConfig().getInitParameter("A");
			BString = getServletConfig().getInitParameter("B");
			a = Integer.parseInt(AString);
			b = Integer.parseInt(BString);
			total = a * b;
			resp.getWriter().println(a + " * " + b + " = " + total);
		}
	}

	//tryParse method tries to parse string, if exception is thrown, it returns false. Otherwise True.
	public boolean tryParse(String s)
	{
		try
		{
			int i = Integer.parseInt(s);
		} catch (NumberFormatException e)
		{
			return false;
		}
		return true;
	}
}

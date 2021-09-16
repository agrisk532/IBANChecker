import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class IBANListChecker.
 * Checks list of IBANs stored in file. Displays results in JSP.
 * Returns a list with results. It contains one element for each IBAN.
 */
@WebServlet("/IBANListChecker")
public class IBANListChecker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IBANListChecker() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		List<String> results = new ArrayList<String>();		// data to send in response
		String fName = request.getParameter("filename");
		Path p = Paths.get(fName);	// file with list of IBANs
		String file = p.getFileName().toString();
		ServletContext context = getServletContext();
		String contextPath = context.getRealPath(File.separator);
		try
		{
			InputStream istream = context.getResourceAsStream(file);
			if(istream == null)
			{
				throw new IOException("InputStream is null");
			}

			List<String> list = Util.readFromInputStream(istream);
			for(String str : list)
			{
				String s = Util.isIBANCorrect(str);		// check IBAN
				results.add(s);
			}
		}
		catch (IOException ex)
		{
			String s = String.format("Please store your file with IBAN numbers in %s and try again.", contextPath);
			results.add(s);
		}
		
		request.setAttribute("results", results);
		String destination = "result.jsp";	// View for displaying results
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);
		requestDispatcher.forward(request, response);
		
	}
}

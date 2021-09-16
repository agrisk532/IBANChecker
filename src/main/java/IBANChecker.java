import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IBANChecker.
 * Checks single IBAN. Displays results in JSP.
 * Returns a list with results. It contains one element.
 */
@WebServlet("/IBANChecker")
public class IBANChecker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IBANChecker() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		List<String> results = new ArrayList<String>();		// data to send in response
		String iban = request.getParameter("iban");
		String s = Util.isIBANCorrect(iban);	// check IBAN
		results.add(s);
		String destination = "result.jsp";	// View for displaying results
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(destination);
		request.setAttribute("results", results);
		requestDispatcher.forward(request, response);
	}

}

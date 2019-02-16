package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Vet;

/**
 * Servlet implementation class navigationVetServlet
 */
@WebServlet("/navigationVetServlet")
public class navigationVetServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public navigationVetServlet() 
    {
        super();
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// Create a VetHelper.
		VetHelper vh = new VetHelper();
		// Get user's response parameter and set it to a string.
		String act = request.getParameter("doThisToItem");
		
		// If no button has been selected do this.
		if (act == null) 
		{
			// Return to the viewAllVetsServlet to redisplay the page.
			getServletContext().getRequestDispatcher("/viewAllVetsServlet").forward(request, response);
		} 
		
		// If a button is checked see if it's delete if it is, do this.
		else if (act.equals("delete")) 
		{
			// Try and catch statement to avoid errors.
			try 
			{
				// Get the id, pass it to the search function, then send the results to the delete function.
				Integer tempID = Integer.parseInt(request.getParameter("id"));
				Vet itemToDelete = vh.searchForItemByID(tempID);
				vh.deleteVet(itemToDelete);
			}
			catch (NumberFormatException exception)
			{
				// If the user didn't select anything print this to console.
				System.out.println("Forgot to click a radio button.");
			}
			finally
			{
				// After the try-catch pass back the request and response to the servlet.
				getServletContext().getRequestDispatcher("/viewAllVetsServlet").forward(request, response);
			}
		}
		else if (act.equals("edit")) 
		{
			try 
			{
				// Get the id, pass it to the search function, then send the results to edit-vet.jsp in the form of a attribute.
				Integer tempID = Integer.parseInt(request.getParameter("id"));
				Vet itemToEdit = vh.searchForItemByID(tempID);
				request.setAttribute("itemToEdit", itemToEdit);
				getServletContext().getRequestDispatcher("/edit-vet.jsp").forward(request, response);
			} 
			catch (NumberFormatException e) 
			{
				// If the user didn't select anything return to the servlet.
				getServletContext().getRequestDispatcher("/viewAllVetsServlet").forward(request, response);
			}
		}
	}
}

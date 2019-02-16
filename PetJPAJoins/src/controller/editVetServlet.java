package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Vet;

/**
 * Servlet implementation class editVetServlet
 */
@WebServlet("/editVetServlet")
public class editVetServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editVetServlet() 
    {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// Create a VetHelper object.
		VetHelper vh = new VetHelper();
				
		// Request the parameter and set it to a string.
		String vetName = request.getParameter("vetName");
				
		// Create a integer to hold the id.
		Integer tempID = Integer.parseInt(request.getParameter("id"));
		// Get the vet object from the id.
		Vet itemToUpdate = vh.searchForItemByID(tempID);
		// Pass the string from earlier to the Vet Item.
		itemToUpdate.setVetName(vetName);
		// Update the item.
		vh.updateItem(itemToUpdate);
		// Return to the servlet.
		getServletContext().getRequestDispatcher("/viewAllVetsServlet").forward(request, response);
	}

}

package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class addVetServlet
 */
@WebServlet("/addVetServlet")
public class addVetServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addVetServlet() 
    {
        super();
    }
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// Create a vet helper.
		VetHelper vh = new VetHelper();
		
		// Get all the current vets.
		request.setAttribute("allVets", vh.showAllVets());
			
		// If it is empty set the attribute to blank to avoid errors.
		if (vh.showAllVets().isEmpty())
		{
			request.setAttribute("allVets", " ");
		}
		
		// Create a PetLishHelper to get all the pet items.	
		PetListHelper plh = new PetListHelper();
			
		// Get the Attribute from the previous servlet.
		request.setAttribute("allItems", plh.showAllItems());
			
		// If the attribute is empty then set a blank attribute to avoid errors.
		if(plh.showAllItems().isEmpty())
		{
			request.setAttribute("allItems", " ");
		}
		
		// Send the requests and responses to the new-vet.jsp.
		getServletContext().getRequestDispatcher("/new-vet.jsp").forward(request, response);
	}
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}
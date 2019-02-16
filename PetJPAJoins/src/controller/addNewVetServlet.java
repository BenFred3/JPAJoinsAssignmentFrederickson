package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Vet;

/**
 * Servlet implementation class addNewVetServlet
 */
@WebServlet("/addNewVetServlet")
public class addNewVetServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addNewVetServlet() 
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
		// Create strings to hold variables from the requests.
		String vetName = request.getParameter("vetName");
		String petID = request.getParameter("petID");
		// Change the petID from a string to a int.
		int petIDInt = Integer.parseInt(petID);
		
		// Create a PetListHelper to be able to search for a PetList object.
		PetListHelper plh = new PetListHelper();
		
		// Create a new vet with the given parameters.
		Vet v = new Vet(vetName, plh.searchForItemByPetID(petIDInt));
		
		// Insert the new vet into the database.
		vh.insertNewVet(v);
		
		// Go the list of vets.
		getServletContext().getRequestDispatcher("/viewAllVetsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}

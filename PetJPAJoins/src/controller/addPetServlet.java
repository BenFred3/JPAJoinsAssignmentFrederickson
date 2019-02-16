package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PetList;
import model.Vet;

/**
 * Servlet implementation class addPetServlet
 */
@WebServlet("/addPetServlet")
public class addPetServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addPetServlet() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// Create three strings to pass to the PetList file.
		String type = request.getParameter("type");
		String owner = request.getParameter("owner");
		String name = request.getParameter("name");
		
		// Create a PetList object and pass the three strings.
		PetList pl = new PetList(type, owner, name);
		// Create a PetListHelper object.
		PetListHelper plh = new PetListHelper();
		// Pass the PetList object to the PetListHelper to add it to the pet database.
		plh.insertItem(pl);
		
		// Create a string to hold the vet name.
		String vetName = request.getParameter("vetName");
		
		if (vetName.equals(""))
		{
			// Do nothing.
		}
		else
		{
			// Create a Vet object.
			Vet v = new Vet(vetName, pl);
			// Create a VetHelper object.
			VetHelper vh = new VetHelper();
			// Pass the Vet object to the VetHelper to add it to the vet database.
			vh.insertNewVet(v);
		}
		// Forward the requests and response to the index.html file.
		getServletContext().getRequestDispatcher("/index.html").forward(request, response);
	}

}

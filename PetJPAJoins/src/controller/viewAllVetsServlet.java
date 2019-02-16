package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Vet;

/**
 * Servlet implementation class viewAllVetsServlet
 */
@WebServlet("/viewAllVetsServlet")
public class viewAllVetsServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewAllVetsServlet() 
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// Create a VetHelper, and a list of vets.
		VetHelper vh = new VetHelper();
		List<Vet> v = vh.showAllVets();
		// Set the attribute from the VetHelper.
		request.setAttribute("allVets", v);
		
		// If the VetHelper is empty then set a blank attribute to avoid errors.
		if (v.isEmpty())
		{
			request.setAttribute("allVets", " ");
		}
		
		// Pass the requests and responses to the pets-vet.jsp.
		getServletContext().getRequestDispatcher("/pets-vet.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}

}

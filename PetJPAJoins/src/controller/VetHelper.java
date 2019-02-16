package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import model.Vet;

public class VetHelper 
{
	// Relate this class to the persistence.xml file.
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Pets");
	
	// This method inserts a item into the database.
	public void insertNewVet(Vet v) 
	{
		// Create a EntityManager, start a transaction, send the new vet information, commit it to the database, close the transaction.
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(v);
		em.getTransaction().commit();
		em.close();
	}
	
	// This method shows all the items from the vet database.
	public List<Vet> showAllVets() 
	{
		// Create a EntityManager, pass a SQL command and get the results, return the results.
		EntityManager em = emfactory.createEntityManager();
		@SuppressWarnings("unchecked") // Make the warning disappear from the line below.
		List<Vet> allShoppers = em.createQuery("SELECT v FROM Vet v").getResultList();
		return allShoppers;
	}
	
	// This method deletes an item from the vet database.
	public void deleteVet(Vet toDelete) 
	{
		// Create a EntityManager, start a transaction, pass a SQL command.
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Vet> typedQuery = em.createQuery("select li from Vet li where li.id = :selectedID and li.vetName = :selectedVetName", Vet.class);
			
		// Substitute parameter with actual data from the toDelete item.
		typedQuery.setParameter("selectedID", toDelete.getId());
		typedQuery.setParameter("selectedVetName", toDelete.getVetName());

		// Make sure there is only one result.
		typedQuery.setMaxResults(1);

		// This try-catch statement is to avoid a exception caused by me trying to fix the delete function.
		try 
		{
			// Get the result and save it into a new list item.
			Vet result = typedQuery.getSingleResult();
			// Remove it, commit it, and close the transaction.
			em.remove(result);
			em.getTransaction().commit();
			em.close();
		}
		catch (Exception e)
		{
			// If there is an exeception do nothing.
		}
	}

	// This method searches the vet database using a id.
	public Vet searchForItemByID(int IDToEdit) 
	{
		// Create a EntityManager, start a transaction, find a ID from the int given, close the transaction, return the found information.
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Vet found = em.find(Vet.class, IDToEdit);
		em.close();
		return found;
	}
	
	// This method searches the vet database using a PetID.
	public Vet searchForItemByPetId(int PetIDToEdit) 
	{
		// Create a EntityManager, start a transaction, find a ID from the int given, close the transaction, return the found information.
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		// This if-else statement was an attempt to make the delete work as I wanted it to.
		if (em.find(Vet.class, PetIDToEdit) != null)
		{
			Vet found = em.find(Vet.class, PetIDToEdit);
			em.close();
			return found;
		}
		else
		{
			Vet v = new Vet();
			return(v);
		}
	}
	
	// This method updates an item in the vet database.
	public void updateItem(Vet toEdit) 
	{
		// Create a EntityManager, start a transaction, merge the existing information with the new pet information given, commit it, and close the transaction.
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}

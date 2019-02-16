// This program is a class to create a vet with the values id, vetName, and a value that is associated with the pet's table. 
// These values are used to create a vet database that is connected to the pet database.
// Benjamin Frederickson
// bfrederickson@dmacc.edu
// 2-15-2019

package model;

//Imports used with @Entity.
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="vet")
public class Vet 
{
	// Instance variables.
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="VETID")
	private int id;
	@Column(name="VETNAME")
	private String vetName;
	@ManyToOne (cascade= CascadeType.MERGE)
	@JoinColumn(name="PETID")
	private PetList pet;
	
	// Default constructor.
	public Vet()
	{
		super();
	}
	
	// Constructor.
	public Vet(String vetName, PetList pet)
	{
		super();
		this.vetName = vetName;
		this.pet = pet;
	}
	
	// Getters and setters.
	public int getId() 
	{
		return id;
	}
	public void setId(int id) 
	{
		this.id = id;
	}
	
	public String getVetName() 
	{
		return vetName;
	}
	public void setVetName(String vetName) 
	{
		this.vetName = vetName;
	}
	
	public PetList getPet() 
	{
		return pet;
	}
	public void setPet(PetList pet) 
	{
		this.pet = pet;
	}

	// Helper method.
	@Override
	public String toString() 
	{
		return "Vet: id-" + id + " | vetName-" + vetName + " | pet-" + pet;
	}
}
package travel;

import exceptions.InvalidTransportDataException;

//Assignment 1
//Written by: Jamal Shaheen 40327844

public abstract class Transportation {
	
	//Static counter for the transportation ID
	private static int nextID = 3001;
	
	//ID for transportation object that's not changed after the creation
	private final String tpID;
	
	//Attributes
	//Protected because subclasses can access directly if needed
	protected String companyName;
	protected String departureCity;
	protected String arrivalCity;
	
	//Default constructor (generate new ID and initializes default values)
	public Transportation() {
		this.tpID = "TR" + nextID++;
		this.companyName = "";
		this.departureCity = "";
		this.arrivalCity = "";
	}
	
	//Parameterized constructor
	public Transportation(String companyName, String departureCity, String arrivalCity) 
		throws InvalidTransportDataException {
			validateString(companyName, "Company name");
			validateString(departureCity, "Departure city");
			validateString(arrivalCity, "Arrival city");
			this.tpID = "TR" + nextID++;
			this.companyName = companyName;
			this.departureCity = departureCity;
			this.arrivalCity = arrivalCity;
		}
		
	
	
	//copy constructor
	public Transportation(Transportation other) {
		this.tpID = "TR" + nextID++;
		this.companyName = other.companyName;
		this.departureCity = other.departureCity;
		this.arrivalCity = other.arrivalCity;
	}
	private void validateString(String value, String fieldName)
			throws InvalidTransportDataException {
		if (value == null || value.trim().isEmpty()) {
			throw new InvalidTransportDataException(fieldName + " cannot be empty.");
		}
		if (value.length() > 50) {
			throw new InvalidTransportDataException(fieldName + " cannpt exceed 50 characters.");
		}
	}
	
	//Accessor and mutator methods
	public String gettpID() {
		return tpID;
	}
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) 
			throws InvalidTransportDataException {
		validateString(companyName, "Company name");
		this.companyName = companyName;
	}
	
	public String getDepartureCity() {
		return departureCity;
	}
	public void setDepartureCity(String departureCity) 
			throws InvalidTransportDataException {
		validateString(departureCity, "Departure city");
		this.departureCity = departureCity;
	}
	
	public String getArrivalCity() {
		return arrivalCity;
	}
	public void setArrivalCity(String arrivalCity) 
			throws InvalidTransportDataException {
		validateString(arrivalCity, "Arrival city");
		this.arrivalCity = arrivalCity;
	}
	
	//toString method
	@Override
	public String toString() {
		return "Transportation: " +
	"Transportation ID: " + tpID + 
	"company name: " + companyName +
	"departure city: " + departureCity +
	"arrival city: " + arrivalCity;
	
	}
	
	//equals method
	@Override
	public boolean equals(Object trp) {
		if (trp == null) return false;
		if(this.getClass() != trp.getClass()) return false;
		
		Transportation other = (Transportation) trp;
		return companyName.equals(other.companyName)
				&& departureCity.equals(other.departureCity)
				&& arrivalCity.equals(other.arrivalCity);
	}
	
	//Abstract methods (Polymorphism)
	public abstract double calculateCost(int durationInDays);
	public abstract String getTransportType();

}

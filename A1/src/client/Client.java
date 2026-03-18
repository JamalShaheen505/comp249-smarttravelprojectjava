package client;
//Assignment 1
//Written by: Jamal Shaheen 40327844
import exceptions.InvalidClientDataException;
public class Client {
	private static int nextID = 1001; // should start at C1001
	private final String clientID;
	private String firstName;
	private String lastName;
	private String emailAddress;
	private double amountSpent;
	
	//default constructor: initializes fields to default values
	public Client() {
		this.clientID = "C" + nextID++;
		this.firstName = "";
		this.lastName = "";
		this.emailAddress = "";
		this.amountSpent = 0.0;
	}
	
	//parameterized constructor: initializes all attributes
	public Client(String firstName, String lastName, String email)
            throws InvalidClientDataException {
        this.clientID = "C" + nextID++;
        setFirstName(firstName);
        setLastName(lastName);
        setEmailAddress(email);
        this.amountSpent = 0.0;
    }
	
	//copy constructor
	public Client(Client other) {
		this.clientID = "C" + nextID++;
		this.firstName = other.firstName;
		this.lastName = other.lastName;
		this.emailAddress = other.emailAddress;
		this.amountSpent = other.amountSpent;
	}
	
	//getter and setter methods
	public String getClientID() {
		return clientID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) throws InvalidClientDataException {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new InvalidClientDataException("First name cannot be empty.");
        }
        if (firstName.length() > 50) {
            throw new InvalidClientDataException("First name cannot exceed 50 characters.");
        }
        this.firstName = firstName.trim();
    }
	
	public String getLastName() {
		return lastName;
	}
	 public void setLastName(String lastName) throws InvalidClientDataException {
	        if (lastName == null || lastName.trim().isEmpty()) {
	            throw new InvalidClientDataException("Last name cannot be empty.");
	        }
	        if (lastName.length() > 50) {
	            throw new InvalidClientDataException("Last name cannot exceed 50 characters.");
	        }
	        this.lastName = lastName.trim();
	    }

	
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) throws InvalidClientDataException {
        if (emailAddress == null || emailAddress.trim().isEmpty()) {
            throw new InvalidClientDataException("Email cannot be empty.");
        }
        if (emailAddress.length() > 100) {
            throw new InvalidClientDataException("Email cannot exceed 100 characters.");
        }
        if (emailAddress.contains(" ")) {
            throw new InvalidClientDataException("Email cannot contain spaces.");
        }
        if (!emailAddress.contains("@") || !emailAddress.contains(".")) {
            throw new InvalidClientDataException("Email format is invalid.");
        }
        this.emailAddress = emailAddress.trim();
    }

	
	public double getAmountSpent() {
		return amountSpent;
	}
	
	 public void setAmountSpent(double amountSpent) throws InvalidClientDataException {
	        if (amountSpent < 0) {
	            throw new InvalidClientDataException("Amount spent cannot be negative.");
	        }
	        this.amountSpent = amountSpent;
	    }
	 
	
	
	
	//toString: assignment needs a readable well formated description. Overridden to show fields in proper format
	@Override
	public String toString() {
		return "Client: " +
	"clientID: " + clientID + 
	"first name: " + firstName +
	"last name: " + lastName +
	"email address: " + emailAddress;
	
	}
	
	//equals method
	@Override
	public boolean equals(Object cli) {
		if (cli == null) return false;
		if(this.getClass() != cli.getClass()) return false;
		
		Client other = (Client) cli;
		return firstName.equals(other.firstName) && lastName.equals(other.lastName) && emailAddress.equals(other.emailAddress);
	}
	
	
	

}

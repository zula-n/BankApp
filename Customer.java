/**
 * Concrete class: Customer
 * Every account has a customer attached to it, there can be two customers maximum per account
 * @03/23/2020
 */
public class Customer extends Bank{
	
	final int ID; //corresponding to the total customers in the Bank class
	String name; //customer name
	int account; // number of accounts opened by the customer
	
	public Customer() {
		ID = Bank.numcustomer++; //total customers from Bank class, increment the total customer value
		name = "Customer" + ID;
		account = 0;
	}
	
	public Customer(String customername) {
		ID = Bank.numcustomer++;
		name = customername;
		account = 0;
	}
	
	public int getCustomerID() { //getter for customer ID
		return ID;
	}
	
	public String getCustomerName() { //getter for customer name
		return name; 
	}
	
	public void setCustomerName(String name) { //setter for customer name
		this.name = name;
	}
	
	public int getCustomerAccounts() { //getter for account
		return account;
	}
	
	public void setCustomerAccounts(int account) { //setter for account
		this.account = account;
	}
	
	public String toString() { //print statement 
		String string;
		string = "Customer: " + name + " | Customer ID: " + ID;
		return string;
	}
}
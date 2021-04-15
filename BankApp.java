/**
 * BankApp Class (Main File)
 * Driver for the program, calls relevant methods as per the menu options
 * @03/23/2020
 */

import java.util.ArrayList;
import java.util.Scanner;

public class BankApp {

	public static Scanner scan = new Scanner(System.in);
	public static Bank bank;
	public static ArrayList<Deposit> depositList;
	public static ArrayList<Customer> customerList;
	int option;

	public BankApp() {
		// default constructor
		bank = new Bank();
		depositList = new ArrayList<Deposit>();
		customerList = new ArrayList<Customer>();
		System.out.println("The Local Union");
		option = -1;
		while (option != 0) {
			printMenu();
			System.out.println("\nEnter a relevant option: ");
			System.out.println();
			option = Integer.parseInt(scan.nextLine());
			while (option < 0 || option > 9) {
				System.out.println("\nEnter a relevant option: ");
				option = Integer.parseInt(scan.nextLine());
			}
			relevantMethod();
		}
	}

	static void printMenu() {
		System.out.println();
		System.out.println("1. Open a new account.");
		System.out.println("2. Add a second holder to an existing account.");
		System.out.println("3. Deposit/Withdraw");
		System.out.println("4. Delete a current account.");
		System.out.println("5. Print details about a account.");
		System.out.println("6. Print details about a customer.");
		System.out.println("7. Update to end month [reset withdrawals & add interest].");
		System.out.println("8. Update to next month.");
		System.out.println("9. Print details about month.");
		System.out.println("0. Exit");
		System.out.println();
	}

	public static void main(String[] args) {
		new BankApp();
	}
	//finds matching ID
	public static Deposit findDeposit(int accID) {
		for (Deposit dep : depositList) {
			if (accID == dep.getAccountID()) {
				return dep;
			}
		}
		return null;
	}
	//finds matchings customer ID
	public static Customer findCustomer(int customerID) {
		for (Customer customer : customerList) {
			if (customerID == customer.getCustomerID()) {
				return customer;
			}
		}
		return null;
	}

	public void relevantMethod() {

		switch (option) {
		case 0: //exits the application
			System.out.println("Thanks for using the bank application");
			break;
		case 1: //prompts user what type of account to open
			System.out.println("1. Deposit Account: Checking");
			System.out.println("2. Deposit Account: Savings");
			System.out.println("0. Return to the main menu");
			System.out.println("Enter the type of account you wish to open: ");
			option = Integer.parseInt(scan.nextLine());
			//make new account and add to depositList
			if (option == 1) {
				depositList.add(new Checking());
			} else if (option == 2) {
				depositList.add(new Savings());
			} else {
				option = -1;
			}
			break;
		case 2: //ask for account ID
			System.out.println("Enter your account ID: ");
			int id = Integer.parseInt(scan.nextLine()); 
			for (int i = 0; i < depositList.size(); i++) {	
				if (id == depositList.get(i).getAccountID()) {
					//add to second holder
				depositList.get(i).addAccountHolder();
			}
		}
			break;
		case 3: //prompt for account ID
			System.out.println("Enter your account ID: ");
			id = Integer.parseInt(scan.nextLine());
			Deposit d = findDeposit(id);
			int amount;
			// if correct ID
			System.out.println("1. Deposit");
			System.out.println("2. Withdraw");
			System.out.println("0. Return to Main Menu");
			int input = Integer.parseInt(scan.nextLine());
			// Based on user input print
			if (input == 1) {
				System.out.println("Enter the amount you wish to deposit: "); 
				amount = Integer.parseInt(scan.nextLine());
				d.depositMoney(amount);
			} else if (input == 2) {
				System.out.println("Enter the amount you wish to withdraw: "); 
				amount = Integer.parseInt(scan.nextLine());
				d.withdrawMoney(amount);
			} else {
				System.out.println("Exiting to main menu");
			}

			break;
		case 4: //prompt for account ID
			System.out.println("Enter your account ID: ");
			id = Integer.parseInt(scan.nextLine()); 
			//find account
			Deposit e = findDeposit(id);
			//delete account
			e.deleteAccount();

			break;
		case 5: //prompt for account ID
			System.out.println("Enter your account ID: "); 
			id = Integer.parseInt(scan.nextLine()); 
			//find account
			Deposit f = findDeposit(id); 
			//print account information
			System.out.println(f);
			break;
		case 6: //prompt for account ID
			System.out.println("Enter your customer ID: "); 
			int customerid = Integer.parseInt(scan.nextLine());
			//find customer
			Customer a = findCustomer(customerid);
			//print customer information
			System.out.println(a.toString());
			break;
		case 7: 
			bank.endOfMonth(); 
			for (int i = 0; i < depositList.size(); i++) {
				//add interest
				depositList.get(i).addInterest();
				//reset withdrawals
				depositList.get(i).resetWithdrawals();
			}
			break;
		case 8: //update next month
			bank.nextMonth();
			break;

		case 9: 
			System.out.println(
					"Current Month: " + Integer.toString(bank.getMonth()) + "\nMonth End Flag: " + Bank.endMonth);
			break;

		default:
			System.out.print("Enter a relevant option:");

		}

	}
}

/**
 * Abstract Class: Deposit
 * Implements the Account interface
 * @03/23/2020
 */
public abstract class Deposit implements Account {
	private int accID; // hold account ID
	private Customer firstholder;; // first holder
	private Customer secondholder;; // second holder
	private int balance; // account balance
	private int withdraw; // number of withdrawal made by an account

	public Deposit() { // Default constructor
		accID = Bank.numaccount++;
		firstholder = checkCustomer();
		balance = 0;
		withdraw = 0;
		System.out.println("A new account was created with account ID: " + accID);
		System.out.println("The first holder is: "
				+ firstholder.toString());

	}

	public int getAccountID() { // getter for ID
		return accID;
	}

	public void setAccountID(int accID) { // setter for ID
		this.accID = accID;
	}

	public int getBalance() { // getter for balance
		return balance;
	}

	public void setBalance(int balance) { // setter for balance
		this.balance = balance;
	}

	public int getWithdrawals() { // getter for withdrawals
		return withdraw;
	}

	public void setWithDrawals(int withdraw) { // setter for withdrawals
		this.withdraw = withdraw;
	}

	public Customer getFirstHolder() { // getter first holder
		return firstholder;
	}

	public void setFirstHolder(Customer firstholder) { // setter first holder
		this.firstholder = firstholder;
	}

	public Customer getSecondHolder() { // getter second holder
		return secondholder;
	}

	public void setSecondHolder(Customer secondholder) { // setter second holder
		this.secondholder = secondholder;
	}

	public boolean depositMoney(int deposit) { // accepts deposit and updates balance
		if (deposit < 0) {
			return false;
		} else {
			balance += deposit;
			System.out.println("Updated Balance: " + balance);
			return true;
		}
	}

	public Customer checkCustomer() {
		System.out.println("Are you an existing customer? [Y: Yes; N: No]");
		String answer = BankApp.scan.nextLine();
		char a = answer.charAt(0);

		if (a == 'Y' || a == 'y') {
			System.out.print("Enter Customer ID:");
			int id = Integer.parseInt(BankApp.scan.nextLine());
			// loop through Customer ArrayList
			for (int i = 0; i < BankApp.customerList.size(); i++) {
				// return customer object that matches id
				if (id == BankApp.customerList.get(i).getCustomerID()) {
					return BankApp.customerList.get(i);
				}
			}
			System.out.println("There was no record of the ID. A new ID will be created");
		}

		else if (a == 'N' || a == 'n') { // if option is N
			System.out.println("Enter your name: ");
			String name = BankApp.scan.nextLine();

			// create Customer object using default constructor
			if (name.length() == 0) {
				Customer customerA = new Customer();
				BankApp.customerList.add(customerA);
				return customerA;
			}
			// create new Customer object using parameterized constructor
			else {
				Customer customerB = new Customer(name);
				BankApp.customerList.add(customerB);
				return customerB;
			}
		}
		return null;
	}

	public boolean addAccountHolder() {
		
			secondholder = checkCustomer();
			System.out.println("For Account ID: " + accID);
			System.out.println("First Holder: "
					+ firstholder.toString());
			System.out.println("Second Holder: "
					+ secondholder.toString());

			return true;
	}

	public boolean updateAccount(Customer customer) {
		firstholder = customer;
		return true;
	}

	public boolean updateAccount(Customer customer, int i) {
		if (i == 1) {
			firstholder = customer;
			return true;
		} else if (i == 2) {
			secondholder = customer;
			return true;
		} else {
			return false;
		}
	}

	public Deposit deleteAccount() {
		System.out.println("Are you sure you want to delete your account?");
		BankApp.scan.hasNextLine();
		String answer = BankApp.scan.nextLine();
		char a = answer.charAt(0);

		if (a == 'Y' || a == 'y') {
			System.out.println("Enter your Customer ID: ");
			int id = Integer.parseInt(BankApp.scan.nextLine());

			// loop through Deposit ArrayList
			for (int i = 0; i < BankApp.depositList.size(); i++) {
				// check if first holder matches customer id
				if (id == BankApp.depositList.get(i).getFirstHolder().getCustomerID()) {
					String type = (BankApp.depositList.get(i) instanceof Checking) ? "checking" : "savings";
					System.out.print("Do you want to delete your" + type + " account with AccID: " + id + "?");

					String x = BankApp.scan.nextLine();
					char y = x.charAt(0);
					if (y == 'Y' || y == 'y') { // if two accounts have the same id, ask to delete the earlier one
						return BankApp.depositList.remove(i);
					} else {
						System.out.println("Customer ID Invalid");
					}

				}
			}

		}
		if (a == 'N' || a == 'n') {
			System.out.println("No accounts were deleted");
		}
		return null;
	}

	public void resetWithdrawals() {
		withdraw = 0;
	}

	public abstract boolean withdrawMoney(int k);

	public abstract int calcInterest();

	public abstract boolean addInterest();

}

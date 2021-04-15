/**
 * Concrete Class: Checking
 * A type of Deposit account: allows unlimited withdrawal transactions, generates 1% interest per year calculated every month
 * @03/23/2020
 */
public class Checking extends Deposit {
	final int intrate = 1;
	
	public Checking() {
		super(); //in the constructor, call the constructor of the Deposit class
	}
	
	public boolean withdrawMoney(int withdraw) { //balance money is less than withdrawal 
		if(super.getBalance() < withdraw) {
			System.out.print("Not Enough Balance");
			return false;
		}
		else if(withdraw < 0) { //withdrawal money is less than 0 
			System.out.print("Invalid Amount");
			return false;
		}
		else { //updates the balance
			super.setBalance(super.getBalance() - withdraw);
			System.out.print("Updated Balance: " + super.getBalance());
			return true;
		}
	}
	public int calcInterest() {
		int intPerYear = (super.getBalance() * intrate) / 100;
		int monthlyInterest = intPerYear / 12;
		return monthlyInterest;
	}
	
	public boolean addInterest() {
		if (Bank.endMonth == true) {
			super.setBalance(super.getBalance() + calcInterest());
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		String string = ("Checking | Balance: " + super.getBalance() + " | Withdrawals: " + super.getWithdrawals() + " | Potential Interest: " + calcInterest());
		return string;
		
	}
}




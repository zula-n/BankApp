/**
 * Concrete Class: Savings
 * A type of Deposit account: allows only three withdrawal transaction per month, generates 4% interest per year calculated every month
 * @03/23/2020
 */
public class Savings extends Deposit{
	final int interestRate = 4;
	
	public Savings() {
		super();
	}
	public boolean withdrawMoney(int i) {
		if(super.getBalance() < super.getWithdrawals()) {
			System.out.print("Not Enough Balance");
			return false;
		}
		else if(super.getWithdrawals() < 0) { //withdrawal money is less than 0 
			System.out.print("Invalid Amount");
			return false;
		}
		else if(super.getWithdrawals() == 3) {
			System.out.print("Withdrawals Limit Exceeded");
			return false;
		}
		else {
			super.setBalance(getBalance() - i);
			System.out.print("Updated Balance: " + super.getBalance());
			setWithDrawals(getWithdrawals() + 1);
            System.out.println(" Remaining Withdrawals: " + (3 - getWithdrawals()));
            return true;
		}
	}
	public int calcInterest() {
		int intPerYear = (super.getBalance() * interestRate) / 100;
		int monthlyInterest = intPerYear / 12;
		return monthlyInterest;
	}
	
	public boolean addInterest() {
		if (Bank.endMonth == true) {
			super.setBalance(getBalance() + calcInterest());
			return true;
		}
		else {
			return false;
		}
	}
	
	public String toString() {
		String string = ("Savings | Balance: " + super.getBalance() + " | Withdrawals: " + super.getWithdrawals() + " | Potential Interest: " + calcInterest());
		return string;
		
	}

}



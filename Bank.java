/**
 * Concrete Class: Bank
 * Keeps track of the total number of customers, total number of accounts opened, months, and end of the month
 * @ 03/23/2020
 */

public class Bank {
	
	static int numaccount; //total number of accounts created
	static int numcustomer; //total number of customers
	int month; //range is 0-11, 0 for January and 11 for December
	static boolean endMonth; //check if it is the end of the month
	
	public Bank(){
		month = 0;
		endMonth = false;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int nextMonth() {
		if(endMonth == false) { //if end of month is false 
			System.out.println("It is not the end of month!");
			return -1;
		}
		else { //if end of month is true
			month++;
			if(month == 12) { //range is 0-11
				month = 0;
				endMonth = false;
				return month;
			}
			endMonth = false; //set back to false
			return month; 
		}
	}
	public int endOfMonth() {
		if (endMonth == true) {
		System.out.println("It is already end of month!");
		return -1;
	}
		else { 
			System.out.println("It is now end of month!");
			endMonth = true;
			return month;
		}
	}
}

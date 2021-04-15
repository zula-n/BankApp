/**
 * Interface Account
 * Consists of the methods that will be common to all accounts
 * @03/23/2020
 */
interface Account {
	public boolean addAccountHolder();
	public boolean updateAccount(Customer c);
	public boolean updateAccount(Customer c, int i);
	public Account deleteAccount();
	public int getAccountID();
	
}


/*
addAccountHolder(): returns boolean
updateAccount(Customer): returns boolean
updateAccount(Customer, int ): return boolean
deleteAccount(): returns Account
getAccountID(): returns int
*/
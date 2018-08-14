//this account extends the BankAccount .
//It has the specific instances Specific to the Saving account and their setters and getters.

package in.co.cg.mmbank.pojo;

/**
 * @author rohit naik
 *
 */
public class SavingsAccount extends BankAccount {
	private boolean salary;
	private String odLimit = "NA";
	double uBalance = super.getAccountBalance();

	// Constructor for Zero balance Account.

	/**
	 * @param accountHolder
	 * @param salary
	 * @param accountType
	 */
	public SavingsAccount(Customer accountHolder, boolean salary, String accountType) {
		super(accountHolder, accountType);
		this.salary = salary;
	}
	// Constructor For Non-Zero balance.

	/**
	 * @param accountHolder
	 * @param accountBalance
	 * @param accountType
	 * @param salary
	 */
	public SavingsAccount(Customer accountHolder, double accountBalance, String accountType, boolean salary) {
		super(accountHolder, accountBalance, accountType);
		this.salary = salary;
	}

	/*
	 * (non-Javadoc) Withdraw for Savings Account
	 * 
	 * @returns yes on success withdraw
	 * 
	 * @see in.co.cg.mmbank.pojo.BankAccount#withdraw(double)
	 */
	@Override
	public String withdraw(double amountToBeWithDrawn) {
		String flag = "";
		if (getAccountBalance() >= amountToBeWithDrawn) {
			
			setAccountBalance(((getAccountBalance() - amountToBeWithDrawn)));
			flag = "yes";
		} else {
			flag = "no";
		}
		return flag;
	}

	// getters and setters
	public boolean isSalary() {
		return salary;
	}

	public void setSalary(boolean salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "SavingsAccount [salary=" + salary + ", toString()=" + super.toString() + "]";
	}

	public String getOdLimit() {
		return odLimit;
	}

	public void setOdLimit(String odLimit) {
		this.odLimit = odLimit;
	}
}

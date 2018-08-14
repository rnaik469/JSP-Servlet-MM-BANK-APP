//This abstract class will be implemented by various types of BankAccount.

package in.co.cg.mmbank.pojo;

import java.time.LocalDate;

public abstract class BankAccount {
	private final int accountNumber;
	private Customer accountHolder;
	private double accountBalance;
	private String accountType;
	//maintains the next accountNumber
	private static int accountId;
	
	//gets invoked whenever a class is loaded
	static {
		accountId = 100;
	}

	//gets invoked whenever a new object is created
	{
		this.accountNumber = ++accountId;
	}
	
	//For Non-Zero Balance Account.
	public BankAccount(Customer accountHolder, double accountBalance, String accountType) {
		this.accountHolder = accountHolder;
		this.accountBalance = accountBalance;
		this.accountType=accountType;
	}
	
	//For Zero Balance account holders
	public BankAccount(Customer accountHolder,String accountType) {
		this.accountHolder = accountHolder;
		this.accountType=accountType;
	}
	
	//getters and setters
	public int getAccountNumber() {
		return accountNumber;
	}
	public Customer getAccountHolder() {
		return accountHolder;
	}
	public void setAccountHolder(Customer accountHolder) {
		this.accountHolder = accountHolder;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	
	
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	//Method to deposit the amount.
	public void deposit(double amountToBeDeposited) {
		if(amountToBeDeposited>0) {
			this.accountBalance+=amountToBeDeposited;
		}
	}
	
	public abstract String withdraw(double amountToBeWithDrawn);
	
	//It will give the next account number that will assigned to next account object
	public static int getNextAccountNumber() {
		return accountId+1;
	}
	
	public void updateCustomerDetails(BankAccount account,long contactNumber,LocalDate dateOfBirth, String customerName,String emailId) {
		account.accountHolder.setContactNumber(contactNumber);
		account.accountHolder.setDateOfBirth(dateOfBirth);
		account.accountHolder.setCustomerName(customerName);;
		account.accountHolder.setEmailId(emailId);
		
	}
	
	@Override
	public String toString() {
		return "BankAccount [accountNumber=" + accountNumber + ", accountHolderName=" + accountHolder
				+ ", accountBalance=" + accountBalance + "]";
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

}

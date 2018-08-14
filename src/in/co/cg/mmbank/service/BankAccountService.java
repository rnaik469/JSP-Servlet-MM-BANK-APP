package in.co.cg.mmbank.service;

import java.time.LocalDate;
import java.util.Collection;

import in.co.cg.mmbank.dao.BankAccountDAO;
import in.co.cg.mmbank.dao.BankAccountDAOI;
import in.co.cg.mmbank.pojo.BankAccount;
import in.co.cg.mmbank.pojo.SavingsAccount;

/**
 * @author Rohit Naik
 *
 */
public class BankAccountService implements BankAccountServiceI {

	private BankAccountDAOI accountDAO = new BankAccountDAO(); // Instantiating BankAccountDAO
	private BankAccount customer = null; // creating reference of BankAccount
	private BankAccount Bsender; // creating reference of BankAccount
	private BankAccount Breceiver; // creating reference of BankAccount

	/*
	 * (non-Javadoc) Add New account
	 * 
	 * @see
	 * in.co.cg.mmbank.service.BankAccountServiceI#AddNewAccount(in.co.cg.mmbank.
	 * pojo.BankAccount)
	 * 
	 */
	@Override
	public void AddNewAccount(BankAccount account) {
		accountDAO.AddNewAccount(account);
	}

	/*
	 * (non-Javadoc) Search account
	 * 
	 * @return object of BankAccount if found or null if not
	 * 
	 * @see in.co.cg.mmbank.service.BankAccountServiceI#searchAccount(int)
	 */
	@Override
	public BankAccount searchAccount(int accountNO) {
		for (BankAccount bankAccount : viewAccount()) {
			if (bankAccount.getAccountNumber() == accountNO) {
				customer = bankAccount;
				break;
			}
		}
		return customer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @@return account number
	 * 
	 * @see in.co.cg.mmbank.service.BankAccountServiceI#getAccountNo()
	 */
	@Override
	public int getAccountNo() {
		System.out.println(BankAccount.getNextAccountNumber());
		return BankAccount.getNextAccountNumber();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @returns all accounts
	 * 
	 * @see in.co.cg.mmbank.service.BankAccountServiceI#viewAccount()
	 */
	@Override
	public Collection<BankAccount> viewAccount() {

		return accountDAO.viewAccount().values();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @returns all customers
	 * 
	 * @see in.co.cg.mmbank.service.BankAccountServiceI#viewCustomer()
	 */
	@Override
	public Collection<BankAccount> viewCustomer() {

		return accountDAO.viewCustomer().values();
	}

	/*
	 * (non-Javadoc) Deposit to account
	 * 
	 * @return account object
	 * 
	 * @see in.co.cg.mmbank.service.BankAccountServiceI#deposit(double, int)
	 */
	@Override
	public BankAccount deposit(double amount, int accNo) {
		customer = searchAccount(accNo);
		if (customer == null) {
			return customer;
		} else {
			customer.deposit(amount);
			return customer;
		}
	}

	/*
	 * (non-Javadoc) withdraw to account
	 * 
	 * @return account object
	 * 
	 * @see in.co.cg.mmbank.service.BankAccountServiceI#withdrawl(double, int)
	 */
	@Override
	public BankAccount withdrawl(double amount, int accNo) {
		customer = searchAccount(accNo);
		if (customer != null && customer.withdraw(amount).equals("yes")) {
			return customer;
		} else {
			return null;

		}
	}

	/*
	 * (non-Javadoc) update customer info
	 * 
	 * @see in.co.cg.mmbank.service.BankAccountServiceI#updateInfo(int, long,
	 * java.time.LocalDate, java.lang.String, java.lang.String)
	 */
	@Override
	public void updateInfo(int accountNO, long contactNumber, LocalDate dateOfBirth, String customerName,
			String emailId) {
		customer.updateCustomerDetails(searchAccount(accountNO), contactNumber, dateOfBirth, customerName, emailId);

	}

	/*
	 * (non-Javadoc) transfer amount
	 * 
	 * @returns false if account not found or insufficient amount
	 * 
	 * @see in.co.cg.mmbank.service.BankAccountServiceI#Fundtransfer(int, int,
	 * double, java.lang.String)
	 */
	@Override
	public boolean Fundtransfer(int sender, int reciever, double amount, String remarks) {
		boolean stat = false;
		Bsender = searchAccount(sender);
		Breceiver = searchAccount(reciever);
		if (Bsender != null && Breceiver != null && Bsender.withdraw(amount).equals("yes")) {
			System.out.println(Breceiver);
			stat = true;
			Breceiver.deposit(amount);
		} else {
			stat = false;
		}
		return stat;
	}

}

package in.co.cg.mmbank.dao;

import java.util.HashMap;
import java.util.Map;

import in.co.cg.mmbank.pojo.BankAccount;
import in.co.cg.mmbank.pojo.SavingsAccount;

/**
 * @author Rohit Naik
 *
 */
public class BankAccountDAO implements BankAccountDAOI  {
	static Map<Integer, BankAccount> bankAcc = new HashMap<Integer, BankAccount>();

	/* (non-Javadoc)
	 * @see in.co.cg.mmbank.dao.BankAccountDAOI#AddNewAccount(in.co.cg.mmbank.pojo.BankAccount)
	 */
	@Override
	public void AddNewAccount(BankAccount account) {
		bankAcc.put(account.getAccountNumber(), account);
	}
	
	public void AddNewCurrentAccount(SavingsAccount account) {
		bankAcc.put(account.getAccountNumber(), account);
	}
	
	public void AddNewSavingAccount(SavingsAccount account) {
		bankAcc.put(account.getAccountNumber(), account);
	}

	/* (non-Javadoc)
	 * @see in.co.cg.mmbank.dao.BankAccountDAOI#searchAccount()
	 */
	@Override
	public  Map<Integer, BankAccount> searchAccount() {
		return bankAcc;
	}

	/* (non-Javadoc)
	 * @see in.co.cg.mmbank.dao.BankAccountDAOI#viewAccount()
	 */
	@Override
	public  Map<Integer, BankAccount> viewAccount() {
		return bankAcc;
	}

	/* (non-Javadoc)
	 * @see in.co.cg.mmbank.dao.BankAccountDAOI#viewCustomer()
	 */
	@Override
	public Map<Integer, BankAccount> viewCustomer() {
		return bankAcc;
	}
}

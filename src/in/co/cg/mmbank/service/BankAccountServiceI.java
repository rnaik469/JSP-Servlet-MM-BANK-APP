package in.co.cg.mmbank.service;

import java.time.LocalDate;
import java.util.Collection;

import in.co.cg.mmbank.pojo.BankAccount;

public interface BankAccountServiceI {

	void AddNewAccount(BankAccount account);

	BankAccount searchAccount(int accountNO);

	int getAccountNo();

	Collection<BankAccount> viewAccount();

	Collection<BankAccount> viewCustomer();

	BankAccount deposit(double amount, int accNo);

	BankAccount withdrawl(double amount, int accNo);

	void updateInfo(int accountNO, long contactNumber, LocalDate dateOfBirth, String customerName, String emailId);

	boolean Fundtransfer(int sender, int reciever, double amount, String remarks);

}
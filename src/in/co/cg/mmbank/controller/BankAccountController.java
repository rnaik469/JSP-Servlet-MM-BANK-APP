package in.co.cg.mmbank.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.co.cg.mmbank.pojo.BankAccount;
import in.co.cg.mmbank.pojo.CurrentAccount;
import in.co.cg.mmbank.pojo.Customer;
import in.co.cg.mmbank.pojo.SavingsAccount;
import in.co.cg.mmbank.service.BankAccountService;
import in.co.cg.mmbank.service.BankAccountServiceI;

/**
 * Servlet implementation class BankAccountController
 */
/**
 * @author rohit naik
 *
 */
@WebServlet("*.app")
public class BankAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		BankAccountServiceI accountService = new BankAccountService(); // Instantiating BankAccountServiceI

		String action = request.getServletPath(); // store servlet path in action

		switch (action) {
		case "/bank.app":
			response.sendRedirect("home.jsp"); // redirecting to home page
			break;

		case "/add.app": //Action add new account
			DateTimeFormatter JAVAFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Date format pattern for date of
																						// birth i.e. yyyy/MM/dd
			LocalDate dateOfBirth = LocalDate.parse(request.getParameter("c_dob"), JAVAFormat); // initializing customer
																								// date of birth to
																								// dateOfBirth
			String customerName = request.getParameter("c_Name"); // initializing customer name to customerName
			String emailId = request.getParameter("c_Email"); // initializing customer Emailto emailId

			long contactNumber = Long.parseLong(request.getParameter("c_contact"));
			String permanentAddress = request.getParameter("c_Address");
			String gender = request.getParameter("gender");
			Customer customer = new Customer(customerName, emailId, contactNumber, dateOfBirth, permanentAddress,
					gender);// invoking constructor of Customer Class

			if (request.getParameter("c_AccType").equals("sav")) { // checks if account is Saving Account

				if (request.getParameter("c_salary").equals("salary")) { // checks if Saving Account is salaried
					
					SavingsAccount savingsAccount = new SavingsAccount(customer, true, "Savings"); // invoking constructor of SavingsAccount Class
					
					accountService.AddNewAccount(savingsAccount); //Invoking AddNewAccount
					
					request.setAttribute("accNO", accountService.getAccountNo() - 1);  //Invoking getAccountNo
					
					RequestDispatcher dispatcher = request.getRequestDispatcher("createSuccess.jsp");// sending response and request to createSuccess.jsp
					dispatcher.forward(request, response);
				}

				else {// checks if Saving Account is Not salaried
					double accountBalance = Double.parseDouble(request.getParameter("c_amount"));
					
					SavingsAccount savingsAccount = new SavingsAccount(customer, accountBalance, "Savings", false);// invoking constructor of SavingsAccount Class
					
					accountService.AddNewAccount(savingsAccount);  //Invoking AddNewAccount
					
					request.setAttribute("accNO", accountService.getAccountNo() - 1); //Invoking getAccountNo
					
					RequestDispatcher dispatcher = request.getRequestDispatcher("createSuccess.jsp"); // sending response and request to createSuccess.jsp
					dispatcher.forward(request, response);

				}
			}

			else {
				double accountBalance = Double.parseDouble(request.getParameter("c_amount"));
				double odLimit = Double.parseDouble(request.getParameter("c_ODLimit"));
				
				CurrentAccount currentAccount = new CurrentAccount(customer, accountBalance, "Current", odLimit); // invoking constructor of CurrentAccount Class
				
				accountService.AddNewAccount(currentAccount); //Invoking AddNewAccount
				
				request.setAttribute("accNO", accountService.getAccountNo() - 1);
				RequestDispatcher dispatcher = request.getRequestDispatcher("createSuccess.jsp"); // sending response and request to createSuccess.jsp
				dispatcher.forward(request, response);
			}
			break;

		case "/viewaccount.app": //Action View All Account
			request.setAttribute("viewaccount", accountService.viewAccount()); //Invoking viewAccount

			RequestDispatcher dispatcher = request.getRequestDispatcher("viewaccount.jsp"); // sending response and request to viewaccount.jsp
			dispatcher.forward(request, response); 
			break;
		case "/viewcust.app": //Action View All Customer
			request.setAttribute("viewcust", accountService.viewCustomer());  //Invoking viewCustomer

			dispatcher = request.getRequestDispatcher("ViewAllCustomers.jsp"); // sending response and request to ViewAllCustomers.jsp
			dispatcher.forward(request, response);
			break;
		case "/deposit.app": //Action to deposit amount
			int accno = Integer.parseInt(request.getParameter("acNO"));
			double amt = Double.parseDouble(request.getParameter("amt"));

			request.setAttribute("viewcust", accountService.deposit(amt, accno));  //Invoking deposit

			dispatcher = request.getRequestDispatcher("depositSuccess.jsp"); // sending response and request to depositSuccess.jsp
			dispatcher.forward(request, response);
			break;
		case "/withdraw.app"://Action to withdraw amount
			int accNo = Integer.parseInt(request.getParameter("acNo"));
			double amount = Double.parseDouble(request.getParameter("amt"));
			double amountT=amount;
			Map<Integer, Integer> deno= new TreeMap<>(); //map to store notecount and value
			int notes[]= {2000,500,200,100,50,20,10,5,2,1};//all available notes
			int totalNotes=0,eachNoteCount=0;
			
			for(int i=0;i<10;i++) {
				eachNoteCount=(int) (amount/notes[i]);  //count no. of notes
				if(eachNoteCount!=0) {
					deno.put(notes[i], eachNoteCount); //put note value and count in map
				}
				totalNotes+=eachNoteCount; //total note count
				amount%=notes[i]; //remaining amount
				
			}
			request.setAttribute("toatlNotes",totalNotes); //Setting total number of notes withdrawSuccess.jsp
			request.setAttribute("deno",deno); //Setting deno attribute for denomination map to withdrawSuccess.jsp
			request.setAttribute("amount",amountT); //Setting deno attribute for denomination map to withdrawSuccess.jsp
			request.setAttribute("viewcust", accountService.withdrawl(amountT, accNo)); //Invoking deposit
			dispatcher = request.getRequestDispatcher("withdrawSuccess.jsp"); // sending response and request to withdrawSuccess.jsp
			dispatcher.forward(request, response);
			break;

		case "/fundtransfer.app":  //Action to fund Transfer 

			int sender = Integer.parseInt(request.getParameter("sender"));
			
			int reciever = Integer.parseInt(request.getParameter("reciever"));
			
			String remarks = request.getParameter("remarks");
			amount = Double.parseDouble(request.getParameter("amt"));

			request.setAttribute("transfer", accountService.Fundtransfer(sender, reciever, amount, remarks)); //Invoking Fundtransfer

			request.setAttribute("reciever", reciever);
			request.setAttribute("sender", sender);
			request.setAttribute("remarks", remarks);
			request.setAttribute("amount", amount);
 
			dispatcher = request.getRequestDispatcher("transferSuccess.jsp"); // sending response and request to transferSuccess.jsp
			dispatcher.forward(request, response);
			break;

		case "/searchCust.app": //Action to search Customer

			accno = Integer.parseInt(request.getParameter("acS"));

			request.setAttribute("searchCust", accountService.searchAccount(accno)); //Invoking searchAccount

			System.out.println(accno + "" + accountService.searchAccount(accno)); //Invoking searchAccount

			dispatcher = request.getRequestDispatcher("searchResult.jsp"); // sending response and request to searchResult.jsp
			dispatcher.forward(request, response);
			break;

		case "/updateInfo.app":  //Action to  update Customer Info
			accno = Integer.parseInt(request.getParameter("accId"));

			request.setAttribute("updateCust", accountService.searchAccount(accno)); //Invoking searchAccount

			dispatcher = request.getRequestDispatcher("UpdateCustomerForm.jsp"); // sending response and request to UpdateCustomerForm.jsp
			dispatcher.forward(request, response);
			break;

		case "/updateSuccess.app": //Action to view updated Customer Info
			accno = Integer.parseInt(request.getParameter("accId"));
			JAVAFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			dateOfBirth = LocalDate.parse(request.getParameter("c_dob"), JAVAFormat);
			customerName = request.getParameter("c_Name");
			emailId = request.getParameter("c_Email");
			contactNumber = Long.parseLong(request.getParameter("c_contact"));
			System.out.println(accno + "" + accountService.searchAccount(accno));
			
			accountService.updateInfo(accno, contactNumber, dateOfBirth, customerName, emailId); //Invoking updateInfo

			request.setAttribute("updatesuccess", accountService.searchAccount(accno));//Invoking searchAccount

			dispatcher = request.getRequestDispatcher("UpdateSucess.jsp"); // sending response and request to UpdateSucess.jsp
			dispatcher.forward(request, response);

			break;

		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

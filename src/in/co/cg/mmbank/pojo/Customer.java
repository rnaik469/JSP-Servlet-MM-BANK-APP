//This class maintains the Customer details of a bank.

package in.co.cg.mmbank.pojo;

import java.time.LocalDate;

/**
 * @author rohit naik
 *
 */
public class Customer {
	private final int customerId;
	private String customerName;
	private long contactNumber;
	private String emailId;
	private LocalDate dateOfBirth;
	private String Address;
	private String nationality;
	private String gender;
		
	//static block intializing custID; 
	static {
		custId = 200;
	}

		//this block increments customerId
	{
		this.customerId = ++custId;
	}

	/**
	 * @param customerName
	 * @param emailId
	 * @param contactNumber
	 * @param dateOfBirth
	 * @param permanentAddress
	 * @param gender
	 */
	public Customer(String customerName, String emailId, long contactNumber, LocalDate dateOfBirth,
			String permanentAddress, String gender) {
		this.customerName = customerName;
		this.contactNumber = contactNumber;
		this.emailId = emailId;
		this.dateOfBirth = dateOfBirth;

		this.gender = gender;
	}
		
	//Getters and setters
	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getGender() {
		return gender;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public int getCustomerId() {
		return customerId;
	}

	private static int custId;

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", contactNumber="
				+ contactNumber + ", emailId=" + emailId + ", dateOfBirth=" + dateOfBirth + ", Address=" + Address
				+ ", nationality=" + nationality + ", gender=" + gender + "]";
	}

}

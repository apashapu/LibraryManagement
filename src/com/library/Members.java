package com.library;
import java.util.Scanner;

public class Members {
	private int memberID;
	private String name, firstName, lastName, phoneNumber;
	// constructor to create a user
	Members(){
		memberID = 0;
	}
	// parameter constructor to simplify the creation of member
	Members(String fname, String lname, String pNo, int id){
		setFirstName(fname);
		setLastName(lname);
		setName(fname, lname);
		setPhoneNumber(pNo);
		setMemberID(id);
	}

	// mutator methods
	
	// set member full name by adding first name and last name
	void setName(String fname , String lname) {
		name = fname + " " + lname;
	}
	// set member last name
	void setFirstName(String fname) {
		firstName = fname;
	}
	// set member last name
	void setLastName(String lname) {
		lastName = lname;
	}
	// set member phone number
	void setPhoneNumber(String pNo) {
		phoneNumber = pNo;
	}
	// set member id increasing order
	void setMemberID(int id) {
		memberID = id;
	}
	
	// accessor methods
	
	// return member id
	int getMemberID() {
		return memberID;
	}
	// return name
	public String getName() {
		name = firstName + " " + lastName;
		return name;
	}
	// return last name/surname
	String getFirstName() {
		return firstName;
	}
	// return last name/surname
	String getLastName() {
		return lastName;
	}
	// return member phone number
	String getPhoneNumber() {
		return phoneNumber;
	}
	
	// print member details
	public String toString() {
		return ("Member ID: " + memberID + " | Member Name: " + name + " | Member Phone Number: " + phoneNumber);
	}
}

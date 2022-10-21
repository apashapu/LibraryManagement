package com.library;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Loans {
	int member_id, book_id;
	String member_name, book_title, borrow_date, return_date;
	//private static ArrayList<Loan> loans = new ArrayList<Loan>();
	Members member = new Members();
	GregorianCalendar cal = new GregorianCalendar();
	Loans(){
		member_id = 0;
		book_id = 0;
	}
	Loans(ArrayList<Members> members, ArrayList<Books> books){
		addLoan(members, books);
	}
	
	// add a loan
	Loans addLoan(ArrayList<Members> members, ArrayList<Books> books) {
		Scanner in = new Scanner(System.in);
		boolean f = false;
		int i = 0, j = 0;
		// get the user input
		System.out.print("Member ID number Who is Borrowing: ");
		int mid = in.nextInt();
		System.out.print("Book ID number Which is Borrowing: ");
		int bid = in.nextInt();
		// get borrowing date from user
		in.nextLine();
		System.out.print("Borrow Date(mm-dd-yyyy): ");
	    borrow_date = in.nextLine();
	    // get return date from user
	    System.out.print("Return Date(mm-dd-yyyy): ");
	 	return_date = in.nextLine();
		// check the member is in list or not
		for ( i=0 ; i<members.size(); i++) {
			if (members.get(i).getMemberID() == mid) {
				f = true;
				break;
			}
		}
		if(f == false) {
			System.out.println("Member ID " + mid + " do not have Entry");
			return null;
		}
		// check the book is in list or not
		for ( j=0 ; j<books.size(); j++) {
			if (books.get(j).getBookID() == bid) {
				f = true;
				break;
			}
		}
		if(f == false) {
			System.out.println("Book ID " + bid + " do not have Entry");
			return null;
		}
		member_id = mid;
		book_id = bid;
		member_name = members.get(i).getName();
		book_title = books.get(j).getTitle();
		System.out.println("Book ID number " + book_id + " Borrowed by Member with ID number: " + member_id);
		return new Loans();
	}

	// list all loans
	public String toString() {
		return ("Member ID: " + member_id + " | Book ID " + book_id + " | Member Name: " + member_name + " | Book Title: " + book_title + " | Borrow Date: " + borrow_date + " | Return Date: " + return_date);
	}
	
}

package com.library;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	// define member and book id
	static int member_id, book_id;
	// declare ArrayList for Members, Books and Loans
	private static ArrayList<Members> members = new ArrayList<Members>();
	private static ArrayList<Books> books = new ArrayList<Books>();
	private static ArrayList<Loans> loans = new ArrayList<Loans>();
	
	// create member and book ArrayList of Members and Books class respectively
	public Main(){
		member_id = 0;
		book_id = 0;
	}
	
	//main method
	public static void main(String[] args) {
		System.out.println("######LIBRARY MANAGEMENT SYSTEM######");
		if (adminAuthenticate()) {
			adminOptions();
		}
		else {
			memberOptions();
		}
	}
	
	static Boolean adminAuthenticate() {
		Scanner in = new Scanner(System.in);
		while (true){
			System.out.println("\nEnter 'admin' to log in as administrator otherwise enter your name");
			System.out.print("Enter User: ");
			String user = in.nextLine();
			if (user.equals("admin")){
				System.out.print("Enter admin Password: ");
				String passwd = in.nextLine();
				// admin password is admin
				if (passwd.equals("admin")) {
					System.out.println("@@ Welcome to Your Libarary Management System " + user);
					return true;
				}
				else {
					System.out.println("Worng Password for admin! Try Again..");
				}
			}
			else {
				System.out.println("@@ Welcome to Libarary Management System " + user);
				return false;
			}
		}
	}
	
	// option menu for admin
	static void adminOptions() {
		Scanner in = new Scanner(System.in);
		boolean f = true;
		while(f) {
			// Main methods
			System.out.println("\n#Options#");
			System.out.println("[a] Add a New Member  [b] Show Member details by ID [c] Show ALL Members");
			System.out.println("[d] Add a New Book    [e] Show Book details by ID   [f] Show ALL Books");
			System.out.println("[g] Edit Member by ID [h] Search Member By Surname  [i] Remove Member by ID");
			System.out.println("[j] Edit Book by ID   [k] Search Book By Title      [l] Remove Book by ID");
			System.out.println("[m] Add a Loan        [n] Remove a Loan             [o] Show All Loans [p] Show Overdue Loans");
			System.out.println("[q] EXIT");
			System.out.print("\nChoose Option: ");
			String str = in.nextLine();
			System.out.print("\n");
			char ch = Character.toLowerCase(str.charAt(0));
			switch(ch) {
				case 'a':
					addMember();
			  		break;
			  	case 'b':
			  		showMemberByID();
			  		break;
			  	case 'c':
			  		showMembers();
			  		break;
			  	case 'd':
			  		addBook();
			  		break;
			  	case 'e':
			  		showBookByID();
					break;
			  	case 'f':
			  		showBooks();
					break;
				case 'g':
					editMemberByID();
					break;
				case 'h':
					searchMemberBySurname();
					break;
				case 'i':
					removeMemberByID();
					break;
				case 'j':
					editBookByID();
					break;
				case 'k':
					searchBookByTitle();
					break;
				case 'l':
					removeBookByID();
					break;
				case 'm':
					loans.add( new Loans(members, books));
					break;
				case 'n':
					removeLoanByID();
					break;
				case 'o':
					showLoans();
					break;
				case 'p':
					showDueLoans();
					break;
				case 'q':
					f = false;
					System.out.println("Exited.");
					break;
			  	default:
				  System.out.println("Wrong Choice\n");
				  break;
			  }
		}
	}
	
	// option menu for other member
	static void memberOptions() {
		Scanner in = new Scanner(System.in);
		boolean f = true;
		// Main methods
		System.out.println("\n#Main Options#");
		System.out.println("[a] Add a Loan [r] Return Books by ID [q] for EXIT");
		System.out.print("\nChoose Option: ");
		String str = in.nextLine();
		System.out.print("\n");
		char ch = Character.toLowerCase(str.charAt(0));
		while (f) {
			switch(ch) {
				case 'a':
					loans.add( new Loans(members, books));
					break;
				case 'r':
					removeLoanByID();
					break;
				case 'q':
					f = false;
					System.out.println("Exited.");
					break;
				default:
					System.out.println("Wrong Choice\n");
					break;
				}
		}
	}
	
	/*
	 * Membership records:
	 */
	
	// a create a user
	static void addMember() {
		Scanner in = new Scanner(System.in);
		// get the user input
		System.out.print("First Name: ");
		String fname = in.nextLine();
		System.out.print("Last Name: ");
		String lname = in.nextLine();
		System.out.print("Phone Number: ");
		String pNo = in.nextLine();
		member_id++;
		//add the new user to the arraylist
		members.add(new Members(fname, lname, pNo, member_id));
		System.out.println("New Member : " + members.get(members.size()-1).getName() + " Added.");
	}
	// b. for a given member ID number print the member’s details
	static void showMemberByID() {
		if (members.isEmpty()) {
			System.out.println("Members List is Empty");
		}
		else {
			Scanner in = new Scanner(System.in);
			boolean f = false;
			System.out.print("Enter Members ID: ");
			int item = in.nextInt();
			for ( int i=0 ; i<members.size(); i++) {
				if (members.get(i).getMemberID() == item) {
					System.out.println(members.get(i).toString());
					f = true;
					break;
				}
			}
			if(f==false) {
				System.out.println("Members ID: " + item + " Do not have Entry.");
			}
		}
	}
	// c. print a list of all members
	static void showMembers() {
		if (members.isEmpty()) {
			System.out.println("Members List is Empty");
		}
		else {
			System.out.println("List of Memberss:");
	//		for (Members m:members) {
	//		System.out.println(m.toString());
	//	}	
			for ( int i=0 ; i<members.size(); i++) {
				System.out.println(members.get(i).toString());
			}
		}
	}
	
	/*
	 * Books Records
	 */
	
	// d. add a new book
	static void addBook() {
		Scanner in = new Scanner(System.in);
		// get the user input
		System.out.print("Book Author Name: ");
		String bauthor = in.nextLine();
		System.out.print("Book Title: ");
		String btitle = in.nextLine();
		System.out.print("Book Category: ");
		String category = in.nextLine();
		// create new Books object
		Books new_book = new Books();
		// set the user input to new new Books object
		new_book.setBookID(book_id);
		new_book.setAuthor(bauthor);
		new_book.setTitle(btitle);
		new_book.setCategory(category);
		// increase book_id 
		book_id++;
		//add the new user to the arraylist
		books.add(new_book);
		System.out.println("New Book: " + books.get(books.size()-1).getTitle() + " Added.");
	}
	
	// e. for a given book ID number print the book’s details
	static void showBookByID() {
		if (books.isEmpty()) {
			System.out.println("Books List is Empty");
		}
		else {
			Scanner in = new Scanner(System.in);
			boolean f = false;
			System.out.print("Enter Books ID: ");
			int item = in.nextInt();
			for ( int i=0 ; i<books.size(); i++) {
				if (books.get(i).getBookID() == item) {
					System.out.println(books.get(i).toString());
					f = true;
					break;
				}
			}
			if(f==false) {
				System.out.println("Books ID: " + item + " Do not have Entry.");
			}
		}
	}
	
		
	// f. print a list of all books
	static void showBooks() {
		if (books.isEmpty()) {
			System.out.println("Books List is Empty");
		}
		else {
			System.out.println("List of Bookss:");
			for ( int i=0 ; i<books.size(); i++) {
				System.out.println(books.get(i).toString());
			}
		}
	}	
	
	/*
	 * Membersship records:
	 */
	
	// g. return a member with a particular member ID number
	static void editMemberByID() {
		if (members.isEmpty()) {
			System.out.println("Members List is Empty");
		}
		else {
			Scanner in = new Scanner(System.in);
			System.out.print("Enter User ID: ");
			int item = in.nextInt();
			for ( int i=0 ; i<members.size(); i++) {
				if (members.get(i).getMemberID() == item) {
					// get the user input to edit member
					System.out.print("Edit First Name: " + members.get(i).getFirstName() + " =>: ");
					in.nextLine();
					String fname = in.nextLine();
					System.out.print("Edit Last Name: " + members.get(i).getLastName() + " =>: ");
					String lname = in.nextLine();
					System.out.print("Edit Phone Number: " + members.get(i).getPhoneNumber() + " =>: ");
					String pNo = in.nextLine();
					members.remove(i);
					//add the new user to the arraylist
					members.add(new Members(fname, lname, pNo, item));
					System.out.println("Member with ID: " + item + " Edited.");
					return;
				}
			}
			System.out.println("No Members with ID: " + item);
		}
	}
	
	// h. search for and print all members where their surname contains a particular search string
	static void searchMemberBySurname() {
		if (members.isEmpty()) {
			System.out.println("Members List is Empty");
		}
		else {
			Scanner in = new Scanner(System.in);
			boolean f = false;
			System.out.print("Enter Members Surname: ");
			String surname = in.nextLine();
			for ( int i=0 ; i<members.size(); i++) {
				if (members.get(i).getLastName().contains(surname)) {
					System.out.println(members.get(i).toString());
					f = true;
				}
			}
			if(f==false) {
				System.out.println("User with: " + surname + " surname Do not have Entry.");
			}
		}
	}
	
	// i. remove a member with a particular member ID number
	static void removeMemberByID() {
		if (members.isEmpty()) {
			System.out.println("Members List is Empty");
		}
		else {
			boolean f = false;
			Scanner in = new Scanner(System.in);
			System.out.print("Enter User ID: ");
			int item = in.nextInt();
			for ( int i=0 ; i<members.size(); i++) {
				if (members.get(i).getMemberID() == item) {
					members.remove(i);
					System.out.println("Members with ID: " + item + " Removed");
					f = true;
					break;
				}
			}
			if(f==false) {
				System.out.println("No Members with ID: " + item);
			}
		}
	}
	
	/*
	 * Books Records
	 */
	
	// j. return a book with a particular book ID number
	static void editBookByID() {
		if (books.isEmpty()) {
			System.out.println("Books List is Empty");
		}
		else {
			Scanner in = new Scanner(System.in);
			System.out.print("Enter Books ID: ");
			int item = in.nextInt();
			for ( int i=0 ; i<books.size(); i++) {
				if (books.get(i).getBookID() == item) {
					// get the user input for edit
					System.out.print("Edit Book Author Name: " + books.get(i).getAuthor() + " =>: ");
					in.nextLine();
					String bauthor = in.nextLine();
					System.out.print("Edit Book Title: " + books.get(i).getTitle() + " =>: ");
					String btitle = in.nextLine();
					System.out.print("Edit Book Category: " + books.get(i).getCategory() + " =>: ");
					String category = in.nextLine();
					// create new Books object
					Books new_book = new Books();
					// set the user input to new new Books object
					new_book.setBookID(i);
					new_book.setAuthor(bauthor);
					new_book.setTitle(btitle);
					new_book.setCategory(category);
					books.remove(i);
					//add the new user to the arraylist
					books.add(new_book);
					System.out.println("Book with ID: " + item + " Edited.");
					return;
				}
			}
			System.out.println("No Book with ID: " + item);
		}
	}
		
	// k. search for and print all books whose title contains a particular search string
	static void searchBookByTitle() {
		if (books.isEmpty()) {
			System.out.println("Books List is Empty");
		}
		else {
			Scanner in = new Scanner(System.in);
			boolean f = false;
			System.out.print("Enter Books Title String: ");
			String title = in.nextLine();
			for ( int i=0 ; i<books.size(); i++) {
				if (books.get(i).getTitle().contains(title)) {
					System.out.println(books.get(i).toString());
					f = true;
				}
			}
			if(f==false) {
				System.out.println("Books with: " + title + " title Do not have Entry.");
			}
		}
	}

	// l. remove a book with a particular book ID number
	static void removeBookByID() {
		if (books.isEmpty()) {
			System.out.println("Books List is Empty");
		}
		else {
			boolean f = false;
			Scanner in = new Scanner(System.in);
			System.out.print("Enter Books ID: ");
			int item = in.nextInt();
			for ( int i=0 ; i<books.size(); i++) {
				if (books.get(i).getBookID() == item) {
					books.remove(i);
					System.out.println("Books with ID: " + item + " Removed");
					f = true;
					break;
				}
			}
			if(f==false) {
				System.out.println("No Books with ID: " + item);
			}
		}
	}
	
	/*
	 * Loan records
	 */
	
	// m. add a loan for a given member and book ID numbers
	
	// n. remove a loan for a given member and book ID numbers
	static void removeLoanByID() {
		if (loans.isEmpty()) {
			System.out.println("Loans List is Empty");
		}
		else {
			boolean f = false;
			Scanner in = new Scanner(System.in);
			// get the user input
			System.out.print("Members ID number who was Borrower: ");
			int mid = in.nextInt();
			System.out.print("Books ID number Which was Borrowed: ");
			int bid = in.nextInt();
			for ( int i=0 ; i<loans.size(); i++) {
				if (loans.get(i).member_id == mid && loans.get(i).book_id == bid) {
					loans.remove(i);
					System.out.println("Loans with Members ID: " + mid + " and Books ID " + bid + " Removed");
					f = true;
					break;
				}
			}
			if(f == false) {
				System.out.println("No Loans with Members ID: " + mid + " and Books ID " + bid);
			}
		}
	}
	
	// o. list all loans giving book and member details
	static void showLoans() {
		if (loans.isEmpty()) {
			System.out.println("Loans List is Empty");
		}
		else {
			System.out.println("List of Due Loanss:");
			for ( int i=0 ; i<loans.size(); i++) {
				System.out.println(loans.get(i).toString());
			}
		}
	}
	/*
	 * Loans records
	 */
	
	// p. print a list of overdue loans giving book and member details.
	static void showDueLoans() {
		new GregorianCalendar();
		// create a GregorianCalendar with current date
		Calendar  current = Calendar.getInstance();
		int current_week = current.get(Calendar.WEEK_OF_YEAR);
		boolean f = false;
		for ( int i=0 ; i<loans.size(); i++) {
		    // create a GregorianCalendar object with the borrow date
			String bdates[] = loans.get(i).borrow_date.split("-");
			int bday = Integer.parseInt(bdates[0]);
			int bmonth = Integer.parseInt(bdates[1]);
			int byear = Integer.parseInt(bdates[2]);
			Calendar bdate = new GregorianCalendar(byear, bmonth-1, bday);
			// get the week of the borrow date
			int borrow_week = bdate.get(Calendar.WEEK_OF_YEAR);
			// if borrow week is over than 3 weeks print those loans
			System.out.println("List of Due Loanss:");
		    if (current_week - borrow_week > 3) {
		    	System.out.println(loans.get(i).toString());
		    	f = true;
		    }
		}
		if (f==false) {
		    System.out.println("No Due Loanss");
		}
	}
}


package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Library extends Observable {

	private List<Copy> copies;
	private List<Customer> customers;
	private List<Loan> loans;
	private List<Book> books;
	



	public Library() {
		copies = new ArrayList<Copy>();
		customers = new ArrayList<Customer>();
		loans = new ArrayList<Loan>();
		books = new ArrayList<Book>();
	}

	public Loan createAndAddLoan(Customer customer, Copy copy) {
		if (!isCopyLent(copy)) {
			Loan l = new Loan(customer, copy);
			loans.add(l);
			doNotify();
			return l;
		} else {
			System.out.println("kein buch mehr vorthanden");
			return null;
		}
	}

	public Customer createAndAddCustomer(String name, String surname) {
		Customer c = new Customer(name, surname);
		customers.add(c);
		return c;
	}

	public Book createAndAddBook(String name) {
		Book b = new Book(name);
		books.add(b);
		doNotify();
		return b;
	}

	public Book createAndAddBook(Book book) {
		Book b = book;
		books.add(b);
		doNotify();
		return b;
	}
	
	public Copy createAndAddCopy(Book title) {
		Copy c = new Copy(title);
		copies.add(c);
		doNotify();
		return c;
	}

	public Book findByBookTitle(String title) {
		for (Book b : books) {
			if (b.getName().equals(title)) {
				return b;
			}
		}
		return null;
	}

	public boolean isCopyLent(Copy copy) {
		for (Loan l : loans) {
			if (l.getCopy().equals(copy) && l.isLent()) {
				return true;
			}
		}
		return false;
	}

	public List<Copy> getCopiesOfBook(Book book) {
		List<Copy> res = new ArrayList<Copy>();
		for (Copy c : copies) {
			if (c.getBook().equals(book)) {
				res.add(c);
			}
		}

		return res;
	}

	public List<Loan> getLentCopiesOfBook(Book book) {
		List<Loan> lentCopies = new ArrayList<Loan>();
		for (Loan l : loans) {
			if (l.getCopy().getBook().equals(book) && l.isLent()) {
				lentCopies.add(l);
			}
		}
		return lentCopies;
	}

	public List<Loan> getCustomerLoans(Customer customer) {
		List<Loan> lentCopies = new ArrayList<Loan>();
		for (Loan l : loans) {
			if (l.getCustomer().equals(customer)) {
				lentCopies.add(l);
			}
		}
		return lentCopies;
	}
	
	public List<Loan> getActiveCustomerLoans(Customer customer) {
		
		List<Loan> lentCopies = new ArrayList<Loan>();
		for (Loan l : loans) {
			if (l.getCustomer().equals(customer) && l.isLent()) {
				lentCopies.add(l);
			}
		}
		return lentCopies;
		
	} 
	
	public boolean hasCustomerOverduedLoans(Customer customer){
		List<Loan> overduedCopies = new ArrayList<Loan>();
		for (Loan l : loans) {
			if (l.getCustomer().equals(customer) && l.isLent() && l.isOverdue()) {
				overduedCopies.add(l);
			}
		}
		return overduedCopies.size() > 0;
	}
	
	public List<Loan> getOverdueLoans() {
		List<Loan> overdueLoans = new ArrayList<Loan>();
		for ( Loan l : getLoans() ) {
			if (l.isOverdue())
				overdueLoans.add(l);
		}
		return overdueLoans;
	}
	
	public List<Copy> getAvailableCopies(){
		return getCopies(false);
	}
	
	public List<Copy> getLentOutBooks(){
		return getCopies(true);
	}

	private List<Copy> getCopies(boolean isLent) {
		List<Copy> retCopies = new ArrayList<Copy>();
		for (Copy c : copies) {
			if (isLent == isCopyLent(c)) {
				retCopies.add(c);
			}
		}
		return retCopies;
	}
	
	
	public void doNotify(){
		setChanged();
		notifyObservers();
	}   
	

	public List<Copy> getCopies() {
		return copies;
	}

	public List<Loan> getLoans() {
		return loans;
	}
	public List<Loan> getActualLoans(){
		List<Loan> actualLoans = new ArrayList<>();
		for(Loan actualLoan : loans){
			if(actualLoan.isLent()){
				actualLoans.add(actualLoan);
			}
		}
		return actualLoans;
	}

	public void removeFromActualLoanList(Loan loanToRemove){
		ArrayList<Loan> actualLoans = (ArrayList<Loan>) getActualLoans();
		for (int i=actualLoans.size(); i > 0; i--) {
			Loan actualLoan = actualLoans.get(i - 1);
			if(actualLoan.getCopy().getInventoryNumber() == loanToRemove.getCopy().getInventoryNumber()){
				actualLoans.remove(actualLoan);
				doNotify();
			}
		}
	}

	public List<Book> getBooks() {
		return books;
	}
	

	public List<Customer> getCustomers() {
		return customers;
	}
	public void removeCopy(Copy c){
		copies.remove(c);
		doNotify();
	}
	
	public void removeBook(Book book){
		books.remove(book);
		doNotify();
	}


}

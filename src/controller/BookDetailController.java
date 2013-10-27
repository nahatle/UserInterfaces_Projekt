package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import view.BookDetail;
import domain.Book;
import domain.Library;

public class BookDetailController implements Observer{
	

	private Library lib;
	private BookDetail bookDetail;
	private JFrame frame;
	private Book selectedBook;
	
	public BookDetailController(Library library, BookDetail bookDetail){
		this.lib = library;
		this.bookDetail = bookDetail;
		this.frame = new JFrame();
		initialize();
		updateUI();
		displayFrame();
	}
	
	
	public BookDetailController(Library library, BookDetail bookDetail, Book selectedBook){
		this.lib = library;
		this.bookDetail = bookDetail;
		this.frame = new JFrame();
		this.selectedBook = selectedBook;
		setBookDetailInTextfield();
		initialize();
		updateUI();
		displayFrame();
	}

	public void setBookDetailInTextfield() {
		
		bookDetail.setTxtFieldTitle(new String(selectedBook.getName()));
		bookDetail.setTxtFieldAuthor(selectedBook.getAuthor());
		bookDetail.setTxtFieldPublisher(selectedBook.getPublisher());
		
	}


	//Actionlistener kommen hier rein
	public void initialize(){
	
	 bookDetail.getBtnAddACopy().addActionListener((new ActionListener() {

		 @Override
		 public void actionPerformed(ActionEvent e) {
			 BookDetailController bookDetailController = new BookDetailController(lib, new BookDetail());
		 }})
			 );
		
		
		
	}
 

	public void updateUI(){
//		bookDetail.getNumberOfBooksLabel().setText(new Integer(lib.getBooks().size()).toString());
//		bookDetail.getNumberOfCopiesLabel().setText(new Integer(lib.getCopies().size()).toString());
//		bookDetail.getTable().updateUI();
	}
	
	public void displayFrame(){
		frame.setContentPane(bookDetail.getContentPane());
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	@Override
	public void update(Observable o, Object arg) {
		updateUI();	
	}
	
	
}

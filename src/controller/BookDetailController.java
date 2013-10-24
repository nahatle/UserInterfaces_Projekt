package controller;

import javax.swing.JFrame;

import view.BookDetail;
import domain.Library;

public class BookDetailController {
	

	private Library lib;
	private BookDetail bookDetail;
	private JFrame frame;
	
	public BookDetailController(Library library, BookDetail bookDetail){
		this.lib = library;
		this.bookDetail = bookDetail;
		this.frame = new JFrame();
		initialize();
		updateUI();
		displayFrame();
	}

	public void initialize(){
//		bookDetail.
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
	
	
}

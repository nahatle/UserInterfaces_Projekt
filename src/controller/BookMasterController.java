package controller;

import javax.swing.JFrame;

import domain.Library;
import view.BookMaster;

public class BookMasterController {
	
	private Library lib;
	private BookMaster bookMaster;
	private JFrame frame;
	
	public BookMasterController(Library library, BookMaster bookMaster){
		this.lib = library;
		this.bookMaster = bookMaster;
		this.frame = new JFrame();
		updateUI();
		displayFrame();
		
		
	}
	
	private void updateUI(){
		bookMaster.getNumberOfBooksLabel().setText(new Integer(lib.getBooks().size()).toString());
	}
	
	private void displayFrame(){
		frame.setContentPane(bookMaster.getContentPane());
		frame.pack();
		frame.setVisible(true);
	}
	
	
//Soll Model und BookMaster verbinden
//
}

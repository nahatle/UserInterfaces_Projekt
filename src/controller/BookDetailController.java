package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;

import view.BookDetail;
import domain.Library;

public class BookDetailController implements Observer{
	

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

	//Actionlistener kommen hier rein
 void initialize(){
		
		bookDetail.getBtnAddACopy().addActionListener((new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BookDetailController bookDetailController = new BookDetailController(lib, new BookDetail());
			}

		})
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

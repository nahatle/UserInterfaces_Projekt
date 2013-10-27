package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.table.AbstractTableModel;

import view.BookDetail;
import domain.Book;
import domain.Copy;
import domain.Library;

public class BookDetailController implements Observer{
	

	private Library lib;
	private BookDetail bookDetail;
	private JFrame frame;
	private Book selectedBook;
	private String[] names = {"ID", "Buchzustand"};
	
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
		
		
	 bookDetail.getConditionTable().setModel( new AbstractTableModel() {

			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				
				switch(columnIndex) {
				case 0:
					return lib.getCopiesOfBook(selectedBook);
				case 1:
					return lib.getCopiesOfBook(selectedBook);
				}
				return 0;
			
			}
			@Override
			public int getRowCount() {
				return lib.getCopies().size();
			}

			@Override
			public String getColumnName(int columnIndex) {
				return names[columnIndex];
			}

			@Override
			public int getColumnCount() {		
				return names.length;
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				return getValueAt(0, columnIndex).getClass();
			}
		
	});
	}
 

	public void updateUI(){
		bookDetail.getConditionTable().updateUI();
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

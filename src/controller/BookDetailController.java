package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.AbstractTableModel;

import view.BookDetail;
import domain.Book;
import domain.Copy;
import domain.Library;
import domain.Shelf;

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
		
	 
		bookDetail.getTxtFieldTitle().getDocument().addDocumentListener(new DocumentListener() {
		
		@Override
		public void removeUpdate(DocumentEvent e) {
			isTextfieldValid();
		}
		
		@Override
		public void insertUpdate(DocumentEvent e) {
			isTextfieldValid();
		}
		
		@Override
		public void changedUpdate(DocumentEvent e) {
			isTextfieldValid();
		}
	});
	 
	 
	 bookDetail.getTxtFieldAuthor().getDocument().addDocumentListener(new DocumentListener() {
		
		@Override
		public void removeUpdate(DocumentEvent e) {
			isTextfieldValid();
		}
		
		@Override
		public void insertUpdate(DocumentEvent e) {
			isTextfieldValid();
		}
		
		@Override
		public void changedUpdate(DocumentEvent e) {
			isTextfieldValid();
		}
	});
	 
	 
	 bookDetail.getTxtFieldPublisher().getDocument().addDocumentListener(new DocumentListener() {
		
		@Override
		public void removeUpdate(DocumentEvent e) {
			isTextfieldValid();
		}
		
		@Override
		public void insertUpdate(DocumentEvent e) {
			isTextfieldValid();
		}
		
		@Override
		public void changedUpdate(DocumentEvent e) {
			isTextfieldValid();
		}
	});
	
	 bookDetail.getBtnSave().addActionListener((new ActionListener() {

		 @Override
		 public void actionPerformed(ActionEvent e) {
//			 bookDetail.getBtnAddACopy().setEnabled(true);
//			 bookDetail.getTxtFieldTitle().setEditable(false);
//			 bookDetail.getTxtFieldAuthor().setEditable(false);
//			 bookDetail.getTxtFieldPublisher().setEditable(false);
//			 bookDetail.getComboBox().setEnabled(false);
			 selectedBook = new Book(bookDetail.getTxtFieldTitle().getText());
			 selectedBook.setAuthor(bookDetail.getTxtFieldAuthor().getText());
			 selectedBook.setPublisher(bookDetail.getTxtFieldPublisher().getText());
			 selectedBook.setShelf((Shelf)bookDetail.getComboBox().getSelectedItem());
			 lib.createAndAddBook(selectedBook);

		 }})
			 );
		
		
	 bookDetail.getConditionTable().setModel( new AbstractTableModel() {

		private static final long serialVersionUID = 1L;

			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				
				switch(columnIndex) {
				case 0:
					return lib.getCopiesOfBook(selectedBook).get(rowIndex).getInventoryNumber();
				case 1:
					return lib.getCopiesOfBook(selectedBook).get(rowIndex).getCondition();
				}
				return 0;
			}
			
			@Override
			public int getRowCount() {
				return lib.getCopiesOfBook(selectedBook).size();
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
		
		if(isTextfieldValid()){
			bookDetail.getBtnSave().setEnabled(true);
		} else {
			bookDetail.getBtnSave().setEnabled(false);
		}
	}
	
	public boolean isTextfieldValid(){
		if (!bookDetail.getTxtFieldTitle().getText().equals("")){
			return true;
		}
		if (!bookDetail.getTxtFieldAuthor().getText().equals("")){
			return true;
		}
		if (!bookDetail.getTxtFieldPublisher().getText().equals("")){
			return true;
		} else
		return false;
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

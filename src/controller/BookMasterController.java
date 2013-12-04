package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.regex.Pattern;

import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import view.BookDetail;
import view.BookMaster;
import domain.Book;
import domain.Library;

public class BookMasterController implements Observer {

	private Library lib;
	private BookMaster bookMaster;
	private HashMap<Book, BookDetailController> framesDetail;
	private String[] names = {"Anzahl Kopien", "Titel", "Autor", "Verlag"};
	public final int COLUMN_EXEMPLAR_MAXWIDTH = 100;
	public final int TABLE_ROWHEIGHT = 25;


	public BookMasterController(Library library, BookMaster bookMaster){
		framesDetail = new HashMap<Book, BookDetailController>();
		this.lib = library;
		this.bookMaster = bookMaster;
		initialize();
		updateUI();
		lib.addObserver(this);
	}


	private void initialize(){
		
		bookMaster.getBtnBearbeiten().setEnabled(false);
		bookMaster.getCheckBoxNurVerfuegbare().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setTableItems();
			}
		});
		
		
		bookMaster.getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent e) {
				bookMaster.setLblAnzSelektiert(bookMaster.getTable().getSelectedRowCount());
				if(bookMaster.getTable().getSelectedRows().length > 0){
					bookMaster.getBtnBearbeiten().setEnabled(true);
				} else
					bookMaster.getBtnBearbeiten().setEnabled(false);
				
			}
			
		});
			
		bookMaster.getButton().addActionListener((new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				new BookDetailController(lib, new BookDetail());
			}

		})
				);
		
		bookMaster.getBtnBearbeiten().addActionListener((new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int rowId:bookMaster.getTable().getSelectedRows()){
					final Book book = lib.getBooks().get(bookMaster.getTable().convertRowIndexToModel(rowId));
					if(framesDetail.containsKey(book)) {
						framesDetail.get(book).bringToFront();
						continue;
					}
					BookDetailController bookDetailController = new BookDetailController(lib, new BookDetail(), book);				
					framesDetail.put(book, bookDetailController);
					
					bookDetailController.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosed(WindowEvent e) {
							framesDetail.remove(book);
						}
					});
				}
				}

		})
				);

		
		
		bookMaster.getTable().setModel(new AbstractTableModel() {

			private static final long serialVersionUID = 1L;

			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				switch(columnIndex) {
				case 0:
					return lib.getCopiesOfBook(lib.getBooks().get(rowIndex)).size();
				case 1:
					return lib.getBooks().get(rowIndex).getName();
				case 2:
					return lib.getBooks().get(rowIndex).getAuthor();
				case 3:
					return lib.getBooks().get(rowIndex).getPublisher();
				}
				
				return null;
			}

			@Override
			public int getRowCount() {
				return lib.getBooks().size();
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

		bookMaster.getTable().setDefaultRenderer(Object.class, new TableRowRenderer());
		bookMaster.getTable().setDefaultRenderer(Integer.class, new TableRowRenderer());
		bookMaster.getTable().setShowVerticalLines(true);
		bookMaster.getTable().setShowHorizontalLines(false);
		bookMaster.getTable().setRowHeight(TABLE_ROWHEIGHT);
		bookMaster.getTable().setGridColor(Color.lightGray);
		

		bookMaster.getTextField().getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				updateUI();	
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				updateUI();
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				updateUI();
			}
		});
	}


	private void updateUI(){
		//Dynamisch Buecher zaehlen
		bookMaster.getNumberOfBooksLabel().setText(new Integer(lib.getBooks().size()).toString());
		bookMaster.getNumberOfCopiesLabel().setText(new Integer(lib.getCopies().size()).toString());
		bookMaster.setLblAnzSelektiert(bookMaster.getTable().getSelectedRowCount());
		
		//Tabelle ins Frame 
		bookMaster.getTable().updateUI();
		
		setTableItems();

	}
	
	public void setTableItems(){
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>();
		bookMaster.getTable().setRowSorter(sorter);	
		sorter.setModel(bookMaster.getTable().getModel());
		sorter.setRowFilter(RowFilter.regexFilter("(?i)" + Pattern.quote(bookMaster.getTextField().getText())));
		
		//Wenn checkbox selektiert wird
		if (bookMaster.getCheckBoxNurVerfuegbare().isSelected()){
			RowFilter<Object,Object> filter = new RowFilter<Object, Object>(){
				public boolean include(@SuppressWarnings("rawtypes") Entry entry){
					int i =  (int) entry.getIdentifier();
					return !(lib.getLoans().get(i).isLent());
				}
			};
			sorter.setRowFilter(filter);
		} 
		
	}
	
	
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("BookmasterContoller UpdateUI ausgefuehrt");
		updateUI();
	}

	public BookMaster getBookMaster() {
		return bookMaster;
	}

}

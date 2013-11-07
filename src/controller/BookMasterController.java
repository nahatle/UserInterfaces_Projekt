package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import domain.Library;
import view.BookDetail;
import view.BookMaster;

public class BookMasterController implements Observer {

	private Library lib;
	private BookMaster bookMaster;
	private String[] names = {"Anzahl Kopien", "Titel", "Autor", "Verlag"};


	public BookMasterController(Library library, BookMaster bookMaster){
		this.lib = library;
		this.bookMaster = bookMaster;
		initialize();
		updateUI();
		lib.addObserver(this);
	}


	private void initialize(){
		
		bookMaster.getBtnBearbeiten().setEnabled(false);
		
		
		
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
				BookDetailController bookDetailController = new BookDetailController(lib, new BookDetail());
			}

		})
				);
		
		bookMaster.getBtnBearbeiten().addActionListener((new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int rowId:bookMaster.getTable().getSelectedRows()){
					BookDetailController bookDetailController = new BookDetailController(lib, new BookDetail(), lib.getBooks().get(bookMaster.getTable().convertRowIndexToModel(rowId)));
				}
				}

		})
				);

		bookMaster.getTable().setModel(new AbstractTableModel() {

			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				switch(columnIndex) {
				//case 0 noch umschreiben nach verfuegbarkeit
				case 0:
					return lib.getCopiesOfBook(lib.getBooks().get(rowIndex)).size();
				case 1:
					return lib.getBooks().get(rowIndex).getName();
				case 2:
					return lib.getBooks().get(rowIndex).getAuthor();
				case 3:
					return lib.getBooks().get(rowIndex).getPublisher();
				}
				
				return 0;
			}

			@Override
			public int getRowCount() {
				return lib.getBooks().size();
			}

			@Override
			public String getColumnName(int columnIndex) {
//				return null;
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
		
		//Sortieren der Tabelle
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>();
		bookMaster.getTable().setRowSorter(sorter);
		sorter.setModel(bookMaster.getTable().getModel());
		//Filtern der Tabelle, Suchfunktion
		sorter.setRowFilter(RowFilter.regexFilter(bookMaster.getTextField().getText()));
		
		

	}


	@Override
	public void update(Observable o, Object arg) {
		updateUI();
	}

	public BookMaster getBookMaster() {
		return bookMaster;
	}

}

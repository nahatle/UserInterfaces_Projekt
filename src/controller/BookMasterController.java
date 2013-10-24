package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;

import domain.Library;
import view.BookDetail;
import view.BookMaster;

public class BookMasterController implements Observer {

	private Library lib;
	private BookMaster bookMaster;
	private JFrame frame;
	private MouseEvent e;
	private String[] names = {"Titel", "Autor"};


	public BookMasterController(Library library, BookMaster bookMaster){
		this.lib = library;
		this.bookMaster = bookMaster;
		this.frame = new JFrame();
		initialize();
		updateUI();
		displayFrame();
		lib.addObserver(this);
	}


	private void initialize(){
		
		bookMaster.getBtnBearbeiten().setEnabled(false);
		
		bookMaster.getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent e) {
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
				BookDetailController filledBookDetailController = new BookDetailController(lib, new BookDetail());
			}

		})
				);

		bookMaster.getTable().setModel(new AbstractTableModel() {



			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				switch(columnIndex) {
				case 0:
					return lib.getBooks().get(rowIndex).getName();

				case 1:
					return lib.getBooks().get(rowIndex).getAuthor();
				}
				return 0;
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
	}

	private void updateUI(){
		bookMaster.getNumberOfBooksLabel().setText(new Integer(lib.getBooks().size()).toString());
		bookMaster.getNumberOfCopiesLabel().setText(new Integer(lib.getCopies().size()).toString());
		bookMaster.getTable().updateUI();

	}

	private void displayFrame(){
		frame.setContentPane(bookMaster.getContentPane());
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}


	@Override
	public void update(Observable o, Object arg) {
		updateUI();
	}

	//Soll Model und BookMaster verbinden
	//
}

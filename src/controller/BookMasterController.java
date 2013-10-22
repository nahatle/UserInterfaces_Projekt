package controller;

import javax.swing.JFrame;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

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
		initialize();
		updateUI();
		displayFrame();
		
		
		
	}
	
	private void initialize(){
		bookMaster.getTable().setModel(new TableModel() {
			
			@Override
			public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void removeTableModelListener(TableModelListener l) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean isCellEditable(int rowIndex, int columnIndex) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				switch(columnIndex) {
				case 0:
					return lib.getBooks().get(rowIndex).getName();
					
				case 1:
					return lib.getBooks().get(rowIndex).getAuthor();
				}
				return "";
			}
			
			@Override
			public int getRowCount() {
				return lib.getBooks().size();
			}
			
			@Override
			public String getColumnName(int columnIndex) {
				String[] names = {"Titel", "Autor"};
				return names[columnIndex];
			}
			
			@Override
			public int getColumnCount() {		
				return 2;
			}
			
			@Override
			public Class<?> getColumnClass(int columnIndex) {
				return getValueAt(0, columnIndex).getClass();
			}
			
			@Override
			public void addTableModelListener(TableModelListener l) {
				// TODO Auto-generated method stub
				
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
	}
	
	
//Soll Model und BookMaster verbinden
//
}

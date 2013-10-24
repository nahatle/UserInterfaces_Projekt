package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import domain.Library;
import view.BookDetail;
import view.BookMaster;

public class BookMasterController {
	
	private Library lib;
	private BookMaster bookMaster;
	private JFrame frame;
	private MouseEvent e;
	
	public BookMasterController(Library library, BookMaster bookMaster){
		this.lib = library;
		this.bookMaster = bookMaster;
		this.frame = new JFrame();
		initialize();
		updateUI();
		displayFrame();
		mouseClicked(e);
	}
	
	
	private void initialize(){
		bookMaster.getButton().addActionListener((new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
            	BookDetailController bookDetailController = new BookDetailController(lib, new BookDetail());
            }

        })
 );
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
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	  public void mouseClicked(MouseEvent e) {
		  System.out.println("test");
	      if (e.getClickCount() == 2) {
	         JTable target = (JTable)e.getSource();
	         int row = target.getSelectedRow();
	         int column = target.getSelectedColumn();
	         BookDetailController bookDetailController = new BookDetailController(lib, new BookDetail());
	         }
	   }
	
//Soll Model und BookMaster verbinden
//
}

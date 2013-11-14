package controller;

import java.awt.Component;
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
import view.LoanDetailView;
import view.LoanMaster;

public class LoanMasterController implements Observer {

	private Library lib;
	private String[] names = {"Anzahl Kopien", "Titel", "Autor", "Verlag"};
	private LoanMaster loanMaster;


	public LoanMasterController(Library library, LoanMaster loanMaster){
		this.lib = library;
		this.loanMaster = loanMaster;
		initialize();
		updateUI();
		lib.addObserver(this);
	}


	private void initialize(){
		
		loanMaster.getBtnSelektierteAusleiheAnzeigen().setEnabled(false);
		
		
		
		
		loanMaster.getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent e) {
				loanMaster.setLblAnzSelektiert(loanMaster.getTable().getSelectedRowCount());
				if(loanMaster.getTable().getSelectedRows().length > 0){
					loanMaster.getBtnSelektierteAusleiheAnzeigen().setEnabled(true);
				} else
					loanMaster.getBtnSelektierteAusleiheAnzeigen().setEnabled(false);
				
			}
			
		});
			
		loanMaster.getBtnSelektierteAusleiheAnzeigen().addActionListener((new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LoanDetailController loanDetailController = new LoanDetailController(lib, new LoanDetailView());
			}

		})
				);
		
		loanMaster.getBtnAusleiheErfassen().addActionListener((new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				for(int rowId:loanMaster.getTable().getSelectedRows()){
					LoanDetailController loanDetailController = new LoanDetailController(lib, new LoanDetailView());
				}
				}

		})
				);

		loanMaster.getTable().setModel(new AbstractTableModel() {

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
		
		loanMaster.getTextField().getDocument().addDocumentListener(new DocumentListener() {
			
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
//		loanMaster.getNumberOfBooksLabel().setText(new Integer(lib.getBooks().size()).toString());
//		loanMaster.getNumberOfCopiesLabel().setText(new Integer(lib.getCopies().size()).toString());
		loanMaster.setLblAnzSelektiert(loanMaster.getTable().getSelectedRowCount());
		
		//Tabelle ins Frame 
		loanMaster.getTable().updateUI();
		
		//Sortieren der Tabelle
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>();
		loanMaster.getTable().setRowSorter(sorter);
		sorter.setModel(loanMaster.getTable().getModel());
		//Filtern der Tabelle, Suchfunktion
		sorter.setRowFilter(RowFilter.regexFilter(loanMaster.getTextField().getText()));
		
		

	}


	@Override
	public void update(Observable o, Object arg) {
		updateUI();
	}


	public Component getContentPane() {
		return loanMaster.getContentPane();
	}

	public LoanMaster getloanMaster() {
		return loanMaster;
	}

}

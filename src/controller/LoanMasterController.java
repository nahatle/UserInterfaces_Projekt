package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import view.BookDetail;
import view.LoanDetailView;
import view.LoanMaster;
import domain.Library;
import domain.Loan;

public class LoanMasterController implements Observer {

	private Library lib;
	private String[] names = {"Status", "Exemplar ID", "Titel", "Ausgeliehen bis", "an Kunde"};
	private LoanMaster loanMaster;
	private GregorianCalendar returnDate;
	private LoanDetailView loanDetailView;


	public LoanMasterController(Library library, LoanMaster loanMaster){
		this.lib = library;
		this.loanMaster = loanMaster;
		initialize();
		updateUI();
		lib.addObserver(this);
		
	}


	private void initialize(){
		
		loanMaster.getBtnSelektierteAusleiheAnzeigen().setEnabled(false);
		
		loanMaster.getBtnAusleiheErfassen().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				LoanDetailController loanDetailController = new LoanDetailController(lib, new LoanDetailView() );
			}
		});
		
		
		
		
		loanMaster.getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if(loanMaster.getTable().getSelectedRows().length > 0){
					loanMaster.getBtnSelektierteAusleiheAnzeigen().setEnabled(true);
				} else
					loanMaster.getBtnSelektierteAusleiheAnzeigen().setEnabled(false);
				
			}
			
		});
			
		loanMaster.getBtnSelektierteAusleiheAnzeigen().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int rowIndex = loanMaster.getTable().getSelectedRow();
					LoanDetailController loanDetailController = new LoanDetailController(lib, new LoanDetailView(), lib.getLoans().get(loanMaster.getTable().convertRowIndexToModel(rowIndex)));
				}
		});


		loanMaster.getTable().setModel(new AbstractTableModel() {

			private static final long serialVersionUID = 1L;

			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
			Loan loan = lib.getLoans().get(rowIndex);
				switch(columnIndex) {
				//case 0 noch umschreiben nach verfuegbarkeit
				case 0:
					   GregorianCalendar returnDate = loan.getOverdueDate();
			            if (loan.isOverdue()) {
			                int daysOverdue = loan.getDaysOverdue();
			                return ("(Fällig - seit " + daysOverdue + " Tagen)");
			            } else {
			                return ("OK");
			            }
				case 1:
					return loan.getCopy().getInventoryNumber();
				case 2:
					return loan.getCopy().getTitle();
				case 3:
					return loan.getOverdueDate().getTime();
				case 4:
					return loan.getCustomer().getName() + ", " + loan.getCustomer().getSurname();
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
				if(columnIndex != 1){
					return getValueAt(0, columnIndex).getClass();
				}else{
					return String.class;
				}
			}

		});
		
		
		loanMaster.getTable().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		loanMaster.getSearchTextField().getDocument().addDocumentListener(new DocumentListener() {
			
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
		
		//Tabelle ins Frame 
		loanMaster.getTable().updateUI();
		
		//Sortieren der Tabelle
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>();
		loanMaster.getTable().setRowSorter(sorter);
		sorter.setModel(loanMaster.getTable().getModel());
	
		//Filtern der Tabelle, Suchfunktion
		//sorter.setRowFilter(RowFilter.regexFilter("(?i)" + loanMaster.getTextField().getText()));
		
		

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

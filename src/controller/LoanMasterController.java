package controller;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.RowFilter.Entry;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import application.LibraryApp;
import view.LoanDetailView;
import view.LoanMaster;
import domain.Book;
import domain.Customer;
import domain.Library;
import domain.Loan;

public class LoanMasterController implements Observer {

	private final Library lib;
	private final String[] names = { "Status", "Exemplar ID", "Titel", "Ausgeliehen bis", "an Kunde" };
	private final LoanMaster loanMaster;
	private HashMap<Loan, LoanDetailController> framesDetail;

	public LoanMasterController(Library library, LoanMaster loanMaster) {
		framesDetail = new HashMap<Loan, LoanDetailController>();
		this.lib = library;
		this.loanMaster = loanMaster;
		lib.addObserver(this);
		initialize();
		updateUI();


	}

	private void initialize() {

		loanMaster.getBtnSelektierteAusleiheAnzeigen().setEnabled(false);

		loanMaster.getCheckboxNurUeberfaellige().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setTableItems();
			}
		});

		loanMaster.getBtnAusleiheErfassen().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new LoanDetailController(lib, new LoanDetailView());
			}
		});

		loanMaster.getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (loanMaster.getTable().getSelectedRows().length > 0) {
					loanMaster.getBtnSelektierteAusleiheAnzeigen().setEnabled(true);
				} else
					loanMaster.getBtnSelektierteAusleiheAnzeigen().setEnabled(false);

			}

		});

		loanMaster.getBtnSelektierteAusleiheAnzeigen().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int rowIndex = loanMaster.getTable().getSelectedRow();
				final Loan loan = lib.getActualLoans().get(loanMaster.getTable().convertRowIndexToModel(rowIndex));
				if(framesDetail.containsKey(loan)){
					framesDetail.get(loan).bringToFront();
				} else {
					LoanDetailController loanDetailController = new LoanDetailController(lib, new LoanDetailView(), loan);
					framesDetail.put(loan, loanDetailController);

					loanDetailController.addWindowListener(new WindowAdapter() {
						@Override
						public void windowClosed(WindowEvent e) {
							framesDetail.remove(loan);
						}
					});
				}
			}
		});

		loanMaster.getTable().setModel(new AbstractTableModel() {

			private static final long serialVersionUID = 1L;

			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {
				Loan actualLoan = lib.getActualLoans().get(rowIndex);
				switch (columnIndex) {
				case 0:
					if (actualLoan.isOverdue()){
						int daysOverdue = actualLoan.getDaysOverdue();
						return ("Faellig - seit " + daysOverdue + " Tagen");
					}else {
						return ("OK");
					}
				case 1:
					return actualLoan.getCopy().getInventoryNumber();
				case 2:
					return actualLoan.getCopy().getBook().getName();
				case 3:
					return actualLoan.getOverdueDate().getTime();
				case 4:
					return actualLoan.getCustomer().getName() + ", " + actualLoan.getCustomer().getSurname();
				}

				return 0;
			}

			@Override
			public int getRowCount() {
				return lib.getActualLoans().size();
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

	public void setTableItems(){
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>();
		loanMaster.getTable().setRowSorter(sorter);
		sorter.setModel(loanMaster.getTable().getModel());
		sorter.setRowFilter(RowFilter.regexFilter("(?i)" + loanMaster.getSearchTextField().getText()));

		//Wenn checkbox selektiert wird
		if (loanMaster.getCheckboxNurUeberfaellige().isSelected()){
			RowFilter<Object,Object> filter = new RowFilter<Object, Object>(){
				public boolean include(Entry entry){
					int i =  (int) entry.getIdentifier();
					return lib.getActualLoans().get(i).isOverdue();
				}
			};
			sorter.setRowFilter(filter);
		} 

	}


	private void updateUI() {
		loanMaster.setNumAktuellAusgeliehen(lib.getActualLoans().size());
		loanMaster.setNumUeberfaelligeAusleihen(lib.getOverdueLoans().size());

		// Tabelle ins Frame
		loanMaster.getTable().updateUI();
		setTableItems();

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

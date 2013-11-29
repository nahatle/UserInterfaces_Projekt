package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.util.GregorianCalendar;
import java.util.Observable;
import java.util.Observer;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.AbstractTableModel;
import view.LoanDetailView;
import domain.Copy;
import domain.Customer;
import domain.Library;
import domain.Loan;

public class LoanDetailController implements Observer {

	private final Library lib;
	private final LoanDetailView loanDetailView;
	private final EscapableFrame frame;
	private final String[] names = { "Exemplar-ID", "Titel", "Author" };


	public LoanDetailController(Library library, LoanDetailView loanDetailView) {
		frame = new EscapableFrame();
		this.lib = library;
		this.loanDetailView = loanDetailView;
		lib.addObserver(this);
		initialize();
		updateUI();
		displayFrame();
	}

	public LoanDetailController(Library library, LoanDetailView loanDetailView, Loan selectedLoan) {
		frame = new EscapableFrame();
		this.lib = library;
		lib.addObserver(this);
		this.loanDetailView = loanDetailView;
		lib.addObserver(this);
		initialize();
		updateUI();
		setCustomerInCombobox(selectedLoan);
		displayFrame();
	}


	public void initialize() {
		loanDetailView.getBtnExemplarAusleihen().setEnabled(false);
		loanDetailView.getComboBox().setModel(new DefaultComboBoxModel<Customer>(lib.getCustomers().toArray(new Customer[0])));

		loanDetailView.getComboBox().addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				updateUI();
			}
		});

		loanDetailView.getBtnExemplarAusleihen().addActionListener(new ActionListener() {
			Integer currentId;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(isTextfieldValid()){
					currentId = Integer.valueOf(loanDetailView.getTxtFldExemplarId().getText());
					for (Copy currentCopy : lib.getCopies()) {
						if (currentCopy.getInventoryNumber() == currentId) {
							lib.createAndAddLoan((Customer) loanDetailView.getComboBox().getSelectedItem(), currentCopy);
							loanDetailView.getBtnExemplarAusleihen().setEnabled(isTextfieldValid());
						}
					}	
				}
			}
		});

		loanDetailView.getTxtFldExemplarId().getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void removeUpdate(DocumentEvent e) {
				loanDetailView.getBtnExemplarAusleihen().setEnabled(isTextfieldValid());
			}

			@Override
			public void insertUpdate(DocumentEvent e) {
				loanDetailView.getBtnExemplarAusleihen().setEnabled(isTextfieldValid());
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				loanDetailView.getBtnExemplarAusleihen().setEnabled(isTextfieldValid());
			}
		});


		loanDetailView.getLoanTable().setModel(new AbstractTableModel() {

			private static final long serialVersionUID = 1L;

			@Override
			public Object getValueAt(int rowIndex, int columnIndex) {

				switch (columnIndex) {
				case 0:
					return lib.getActiveCustomerLoans((Customer) (loanDetailView.getComboBox().getSelectedItem())).get(rowIndex).getCopy().getInventoryNumber();
				case 1:
					return lib.getActiveCustomerLoans((Customer) (loanDetailView.getComboBox().getSelectedItem())).get(rowIndex).getCopy().getBook().getName();
				case 2:
					return lib.getActiveCustomerLoans((Customer) (loanDetailView.getComboBox().getSelectedItem())).get(rowIndex).getCopy().getBook().getAuthor();
				}
				return 0;
			}

			@Override
			public int getRowCount() {
				return lib.getActiveCustomerLoans((Customer) (loanDetailView.getComboBox().getSelectedItem())).size();
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
		
		//Rueckgabe einer Ausleihe
		loanDetailView.getBtnExemplarRueckgabe().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int[] selectedRows = loanDetailView.getLoanTable().getSelectedRows();
				lib.getActiveCustomerLoans((Customer) (loanDetailView.getComboBox().getSelectedItem())).get(selectedRows[0]).setReturnDate(new GregorianCalendar());

				updateUI();
			}
		});

		loanDetailView.setLblFktAnzAusleihen(Integer.valueOf(lib.getActiveCustomerLoans((Customer) (loanDetailView.getComboBox().getSelectedItem())).size()));

	}
	
	//Benutzer in die Combobox setzen
	public void setCustomerInCombobox(Loan selectedLoan) {
		loanDetailView.getComboBox().setSelectedItem(selectedLoan.getCustomer());
	}

	// VALIDIERUNG EXEMPLAR BUTTON
	private boolean isTextfieldValid(){
		try{
			int id = Integer.parseInt(loanDetailView.getTxtFldExemplarId().getText());
			for (Copy actualCopy : lib.getAvailableCopies()){
				if(id == actualCopy.getInventoryNumber()){
					return true;
				}
			}
			return false;
		}
		catch (NumberFormatException ne){
			return false;
		}
	}



	private void updateUI() {
		loanDetailView.getLoanTable().updateUI();


	}

	public void displayFrame() {
		frame.setContentPane(loanDetailView.getContentPane());
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("LoanDetailController updateUI ausgefuehrt");
		updateUI();
	}

	public void bringToFront() {
		frame.toFront();
	}

	public void addWindowListener(WindowListener l) {
		frame.addWindowListener(l);
	}
}

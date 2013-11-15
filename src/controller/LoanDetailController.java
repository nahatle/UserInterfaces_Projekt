package controller;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.JFrame;

import view.LoanDetail;
import view.LoanDetailView;
import domain.Customer;
import domain.Library;

public class LoanDetailController implements Observer{

	private Library lib;
	private LoanDetailView loanDetailView;
	private JFrame frame;
	private String[] loanColumns = {"Ausleihdatum", "Rueckgabedatum", "Name", "Vorname"};
	

	public LoanDetailController(Library library, LoanDetailView loanDetailView){
		frame = new JFrame();
		this.lib = library;
		this.loanDetailView = loanDetailView;
		initialize();
		updateUI();
		lib.addObserver(this);
		displayFrame();
	}
	
	@SuppressWarnings("unchecked")
	public void initialize(){
		loanDetailView.getComboBox().setModel(getCustomerModel());

		
	}
	
	//Methode: Model fuer die Combobox
	public DefaultComboBoxModel getCustomerModel() {
		DefaultComboBoxModel customerModel = new DefaultComboBoxModel();
		List<Customer> customerList = lib.getCustomers();
		for (Customer c : customerList) {
			customerModel.addElement(c);
		}
		return customerModel;
	}
	
	
	private void updateUI() {
		loanDetailView.getLoanTable().updateUI();
		
	}
	
	
	public void displayFrame(){
		frame.setContentPane(loanDetailView.getContentPane());
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		updateUI();
	}

	


}

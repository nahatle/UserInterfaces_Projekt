package controller;

import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;

import view.LoanDetailView;
import domain.Customer;
import domain.Library;

public class LoanDetailController {

	private Library lib;
	private LoanDetailView loanDetailView;
	private String[] loanColumns = {"Ausleihdatum", "Rueckgabedatum", "Name", "Vorname"};
	

	public LoanDetailController(Library library, LoanDetailView loanDetailView){
		this.lib = library;
		this.loanDetailView = loanDetailView;
		initialize();
	}
	
	@SuppressWarnings("unchecked")
	public void initialize(){

		loanDetailView.getComboBox().setModel(getCustomerModel());
		
	}
	
	
	public DefaultComboBoxModel getCustomerModel() {
		DefaultComboBoxModel customerModel = new DefaultComboBoxModel();
		List<Customer> customerList = lib.getCustomers();
		for (Customer c : customerList) {
			customerModel.addElement(c);
		}
		return customerModel;
	}
	
	
	public JComponent getContentPane() {
		return loanDetailView;
	}


}

package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComponent;
import javax.swing.event.ListDataListener;

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
	
	
	public DefaultComboBoxModel<Customer> getCustomerModel() {
		DefaultComboBoxModel<Customer> customerModel = new DefaultComboBoxModel<Customer>();
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

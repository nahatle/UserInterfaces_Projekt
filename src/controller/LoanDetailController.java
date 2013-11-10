package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ComboBoxModel;
import javax.swing.JComponent;
import javax.swing.event.ListDataListener;

import view.LoanDetailView;
import domain.Customer;
import domain.Library;

public class LoanDetailController {

	private Library lib;
	private LoanDetailView loanDetailView;
	

	public LoanDetailController(Library library, LoanDetailView loanDetailView){
		this.lib = library;
		this.loanDetailView = loanDetailView;
		initialize();
	}
	
	@SuppressWarnings("unchecked")
	public void initialize(){
		
		loanDetailView.getComboBox().setModel(new ComboBoxModel<Customer>() {
			private int index;

			@Override
			public int getSize() {
				return lib.getCustomers().size();
			}

			@Override
			public Customer getElementAt(int index) {
				this.index = index;
				return lib.getCustomers().get(index);
			}

			@Override
			public void addListDataListener(ListDataListener l) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void removeListDataListener(ListDataListener l) {
				// TODO Auto-generated method stub
				
			}


			@Override
			public Customer getSelectedItem() {
				return this.getElementAt(index);
			}

			@Override
			public void setSelectedItem(Object anItem) {			
			}

		});
		
		
		loanDetailView.getComboBox().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("hallo");
//				loanDetailView.getComboBox().getSelectedIndex();
				
			}
		});
		
		
		
	}
	
	
	public JComponent getContentPane() {
		return loanDetailView;
	}


}

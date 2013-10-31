package controller;

import javax.swing.JComponent;
import javax.swing.JFrame;

import view.LoanDetailView;
import domain.Library;

public class LoanDetailController {

	private Library lib;
	private LoanDetailView loanDetailView;


	public LoanDetailController(Library library, LoanDetailView loanDetailView){
		this.lib = library;
		this.loanDetailView = loanDetailView;
	}
	
	
	public JComponent getContentPane() {
		return loanDetailView;
	}


}

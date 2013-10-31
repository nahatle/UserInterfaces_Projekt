package controller;

import javax.swing.JFrame;

import view.LoanDetailView;
import domain.Library;

public class LoanDetailController {

	private Library lib;
	private LoanDetailView LoanDetailView;


	public LoanDetailController(Library library, LoanDetailView loadController){
		this.lib = library;
		this.LoanDetailView = loadController;
	}
	
	
	public JFrame getLoadController() {
		// TODO Auto-generated method stub
		return null;
	}


}

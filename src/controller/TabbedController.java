package controller;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class TabbedController {
	private JTabbedPane tabbedPane;
	private JFrame frame;
	private BookMasterController bookMaster;
	


	public TabbedController(BookMasterController bookMaster, LoanMasterController loanMaster){
		this.bookMaster = bookMaster;
		tabbedPane = new JTabbedPane();
		tabbedPane.add(bookMaster.getBookMaster().getContentPane(), "Buecher");
		tabbedPane.add(loanMaster.getContentPane(), "Ausleihe");
		frame = new JFrame();
		displayFrame();
		
	}
	
	private void displayFrame(){
		frame.setContentPane(tabbedPane);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

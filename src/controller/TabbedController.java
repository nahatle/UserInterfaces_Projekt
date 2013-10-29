package controller;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class TabbedController {
	private JTabbedPane tabbedPane;
	private JFrame frame;
	private BookMasterController bookMaster;
	


	public TabbedController(BookMasterController bookMaster){
		this.bookMaster = bookMaster;
		tabbedPane = new JTabbedPane();
		tabbedPane.add(bookMaster.getBookMaster().getContentPane(), "Buecher");
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

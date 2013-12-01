package controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.KeyStroke;

public class TabbedController {
	private JTabbedPane tabbedPane;
	private JFrame frame;

	


	public TabbedController(BookMasterController bookMaster, LoanMasterController loanMaster){
		tabbedPane = new JTabbedPane();
		tabbedPane.add(bookMaster.getBookMaster().getContentPane(), "Buecher");
		tabbedPane.add(loanMaster.getContentPane(), "Ausleihe");
		frame = new JFrame();
		displayFrame();
		
	}
	
	private void displayFrame(){
		frame.setContentPane(tabbedPane);
		frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		frame.setMinimumSize(new Dimension(850, 450));
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tabbedPane.registerKeyboardAction(new AbstractAction() {
			
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		}, KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
		
		tabbedPane.registerKeyboardAction(new AbstractAction() {
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		}, KeyStroke.getKeyStroke(KeyEvent.VK_F2, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
	}
	

}

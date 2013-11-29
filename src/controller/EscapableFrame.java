package controller;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

public class EscapableFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("serial")
	public EscapableFrame(){
		// on ESC key close frame
		getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "Cancel"); //$NON-NLS-1$
		getRootPane().getActionMap().put("Cancel", new AbstractAction(){ //$NON-NLS-1$
			public void actionPerformed(ActionEvent e)
			{
				close();
			}
		});

		// on close window the close method is called
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) 
			{
				close();
			}
		});
	}

	public void close() {
		this.dispose();
	}
}


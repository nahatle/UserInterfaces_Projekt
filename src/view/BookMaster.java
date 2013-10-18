package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.border.TitledBorder;

import java.awt.Insets;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import domain.Book;
import domain.Library;

public class BookMaster {
	/**
	 * Create the application.
	 * @param library 
	 */
	public BookMaster(Library library) {
		this.library = library;
		initialize();
	}

	private static Library library;
	public JFrame frame;

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane);
		
		JPanel Tab1 = new JPanel();
		tabbedPane.addTab("B\u00FCcher", null, Tab1, null);
		GridBagLayout gbl_Tab1 = new GridBagLayout();
		gbl_Tab1.columnWidths = new int[]{0, 0};
		gbl_Tab1.rowHeights = new int[]{0, 0};
		gbl_Tab1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_Tab1.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		Tab1.setLayout(gbl_Tab1);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		Tab1.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{50, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setMaximumSize(new Dimension(50, 200));
		panel_4.setBorder(new TitledBorder(null, "Inventar Statistiken", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 0;
		panel_1.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{431, 0};
		gbl_panel_4.rowHeights = new int[]{24, 0};
		gbl_panel_4.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		panel_4.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{5, 0, 0, 0, 0, 40, 8, 45, 109, 0};
		gbl_panel_2.rowHeights = new int[]{10, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblAnzahlBcher = new JLabel("Anzahl B\u00FCcher: ");
		lblAnzahlBcher.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblAnzahlBcher = new GridBagConstraints();
		gbc_lblAnzahlBcher.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblAnzahlBcher.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnzahlBcher.gridx = 1;
		gbc_lblAnzahlBcher.gridy = 1;
		panel_2.add(lblAnzahlBcher, gbc_lblAnzahlBcher);
		lblAnzahlBcher.setHorizontalAlignment(SwingConstants.LEFT);
		
		
		JLabel lblNewLabel = new JLabel(new Integer(library.getBooks().size()).toString());
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 1;
		panel_2.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblAnzahlBcher2 = new JLabel("Anzahl Exemplare: ");
		GridBagConstraints gbc_lblAnzahlBcher2 = new GridBagConstraints();
		gbc_lblAnzahlBcher2.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblAnzahlBcher2.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnzahlBcher2.gridx = 3;
		gbc_lblAnzahlBcher2.gridy = 1;
		panel_2.add(lblAnzahlBcher2, gbc_lblAnzahlBcher2);
		
		
		JLabel lblNewLabel2 = new JLabel(new Integer(library.getCopies().size()).toString());
		GridBagConstraints gbc_lblNewLabel2 = new GridBagConstraints();
		gbc_lblNewLabel2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel2.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel2.gridx = 4;
		gbc_lblNewLabel2.gridy = 1;
		panel_2.add(lblNewLabel2, gbc_lblNewLabel2);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "Buch Inventar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 1;
		panel_1.add(panel_5, gbc_panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{0, 0};
		gbl_panel_5.rowHeights = new int[]{0, 0};
		gbl_panel_5.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 0;
		panel_5.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0};
		gbl_panel_3.rowHeights = new int[]{0};
		gbl_panel_3.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		

		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		//BorderPanel.add(panel, gbc_panel);
		
		JPanel Tab2 = new JPanel();
		tabbedPane.addTab("Ausleihen", null, Tab2, null);
	}

}

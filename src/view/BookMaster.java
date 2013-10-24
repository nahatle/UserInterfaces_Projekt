package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.ScrollPaneConstants;

public class BookMaster {
	/**
	 * Create the application.
	 * @param library 
	 */
	public BookMaster() {
		initialize();
	}



	private JTextField textField;
	private JTable table;
	private JLabel numOfCopiesLabel;
	private JLabel numOfBooksLabel;
	private JPanel contentPane;
	private JButton button_1;
	private JButton btnBearbeiten;



	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		JPanel inventoryStatsPanel = new JPanel();
		inventoryStatsPanel.setBorder(new TitledBorder(null, "Inventar Statistik", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(inventoryStatsPanel, BorderLayout.NORTH);
		GridBagLayout gbl_inventoryStatsPanel = new GridBagLayout();
		gbl_inventoryStatsPanel.columnWidths = new int[]{110, 40, 140};
		gbl_inventoryStatsPanel.rowHeights = new int[]{0, 0};
		gbl_inventoryStatsPanel.columnWeights = new double[]{0.0, 0.0, 0.0};
		gbl_inventoryStatsPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		inventoryStatsPanel.setLayout(gbl_inventoryStatsPanel);
		
		JLabel lblAnzahlBcher = new JLabel("Anzahl B\u00FCcher: ");
		lblAnzahlBcher.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblAnzahlBcher_1 = new GridBagConstraints();
		gbc_lblAnzahlBcher_1.anchor = GridBagConstraints.WEST;
		gbc_lblAnzahlBcher_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblAnzahlBcher_1.gridx = 0;
		gbc_lblAnzahlBcher_1.gridy = 0;
		inventoryStatsPanel.add(lblAnzahlBcher, gbc_lblAnzahlBcher_1);
		
		numOfBooksLabel = new JLabel();
		GridBagConstraints gbc_numOfBooksLabel = new GridBagConstraints();
		gbc_numOfBooksLabel.insets = new Insets(0, 0, 0, 5);
		gbc_numOfBooksLabel.gridx = 1;
		gbc_numOfBooksLabel.gridy = 0;
		inventoryStatsPanel.add(numOfBooksLabel, gbc_numOfBooksLabel);
		
		JLabel lblAnzahlExemplare = new JLabel("Anzahl Exemplare: ");
		GridBagConstraints gbc_lblAnzahlExemplare = new GridBagConstraints();
		gbc_lblAnzahlExemplare.insets = new Insets(0, 0, 0, 5);
		gbc_lblAnzahlExemplare.gridx = 2;
		gbc_lblAnzahlExemplare.gridy = 0;
		inventoryStatsPanel.add(lblAnzahlExemplare, gbc_lblAnzahlExemplare);
		
		numOfCopiesLabel = new JLabel();
		GridBagConstraints gbc_numOfCopiesLabel = new GridBagConstraints();
		gbc_numOfBooksLabel.insets = new Insets(0, 0, 5, 0);
		gbc_numOfBooksLabel.gridx = 3;
		gbc_numOfBooksLabel.gridy = 0;
		inventoryStatsPanel.add(numOfCopiesLabel, gbc_numOfCopiesLabel);
		
		JPanel inventoryBooksPanel = new JPanel();
		inventoryBooksPanel.setBorder(new TitledBorder(null, "Buch Inventar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(inventoryBooksPanel, BorderLayout.CENTER);
		inventoryBooksPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel bookSearchPanel = new JPanel();
		inventoryBooksPanel.add(bookSearchPanel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("Buch suchen:");
		bookSearchPanel.add(label);
		label.setHorizontalAlignment(SwingConstants.LEFT);
		
		textField = new JTextField();
		bookSearchPanel.add(textField);
		textField.setColumns(10);
		
		JCheckBox checkBox = new JCheckBox("Nur Verfuegbare");
		bookSearchPanel.add(checkBox);
		
		button_1 = new JButton("Neues Buch hinzufuegen");
		bookSearchPanel.add(button_1);
		
		btnBearbeiten = new JButton("Bearbeiten...");
		bookSearchPanel.add(btnBearbeiten);

		
		JScrollPane scrollPane = new JScrollPane(table);
		inventoryBooksPanel.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		scrollPane.setViewportView(table);
	
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;

	}
	
	public JButton getBtnBearbeiten() {
		return btnBearbeiten;
	}

	public JButton getButton() {
		return button_1;
	}
	
	public JLabel getNumberOfCopiesLabel() {
		return numOfCopiesLabel;
	}

	public JLabel getNumberOfBooksLabel() {
		return numOfBooksLabel;
	}

	public JPanel getContentPane() {
		return contentPane;
	}
	public JTable getTable() {
		return table;
	}

}

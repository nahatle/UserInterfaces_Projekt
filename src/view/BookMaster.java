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

public class BookMaster {
	/**
	 * Create the application.
	 * @param library 
	 */
	public BookMaster() {
		initialize();
	}

	private static Library library;
	public JFrame frame;
	private JTable table;
	private JTextField textField;
	private JTable table_1;
	private JLabel numberOfCopiesLabel;
	private JLabel numberOfBooksLabel;
	private JPanel contentPane;
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		contentPane = new JPanel();
		
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{737, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.WEST;
		gbc_panel_1.fill = GridBagConstraints.VERTICAL;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{735, 0};
		gbl_panel_1.rowHeights = new int[]{108, 184, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JPanel inventoryStats = new JPanel();
		inventoryStats.setMaximumSize(new Dimension(50, 200));
		inventoryStats.setBorder(new TitledBorder(null, "Inventar Statistiken", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_inventoryStats = new GridBagConstraints();
		gbc_inventoryStats.fill = GridBagConstraints.BOTH;
		gbc_inventoryStats.insets = new Insets(0, 0, 5, 0);
		gbc_inventoryStats.gridx = 0;
		gbc_inventoryStats.gridy = 0;
		panel_1.add(inventoryStats, gbc_inventoryStats);
		GridBagLayout gbl_inventoryStats = new GridBagLayout();
		gbl_inventoryStats.columnWidths = new int[]{300, 0};
		gbl_inventoryStats.rowHeights = new int[]{24, 0, 0};
		gbl_inventoryStats.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_inventoryStats.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		inventoryStats.setLayout(gbl_inventoryStats);
		
		JPanel booksAndCopies = new JPanel();
		GridBagConstraints gbc_booksAndCopies = new GridBagConstraints();
		gbc_booksAndCopies.insets = new Insets(0, 0, 5, 0);
		gbc_booksAndCopies.fill = GridBagConstraints.BOTH;
		gbc_booksAndCopies.gridx = 0;
		gbc_booksAndCopies.gridy = 0;
		inventoryStats.add(booksAndCopies, gbc_booksAndCopies);
		GridBagLayout gbl_booksAndCopies = new GridBagLayout();
		gbl_booksAndCopies.columnWidths = new int[]{5, 0, 40, 0, 0, 40, 8, 45, 109, 0};
		gbl_booksAndCopies.rowHeights = new int[]{10, 0, 0, 0};
		gbl_booksAndCopies.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_booksAndCopies.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		booksAndCopies.setLayout(gbl_booksAndCopies);
		
		JLabel lblAnzahlBcher = new JLabel("Anzahl B\u00FCcher: ");
		lblAnzahlBcher.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblAnzahlBcher = new GridBagConstraints();
		gbc_lblAnzahlBcher.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblAnzahlBcher.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnzahlBcher.gridx = 1;
		gbc_lblAnzahlBcher.gridy = 1;
		booksAndCopies.add(lblAnzahlBcher, gbc_lblAnzahlBcher);
		lblAnzahlBcher.setHorizontalAlignment(SwingConstants.LEFT);
		
		
		numberOfBooksLabel = new JLabel();
		GridBagConstraints gbc_numberOfBooksLabel = new GridBagConstraints();
		gbc_numberOfBooksLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_numberOfBooksLabel.insets = new Insets(0, 0, 5, 5);
		gbc_numberOfBooksLabel.gridx = 2;
		gbc_numberOfBooksLabel.gridy = 1;
		booksAndCopies.add(numberOfBooksLabel, gbc_numberOfBooksLabel);
		
		JLabel lblAnzahlBcher2 = new JLabel("Anzahl Exemplare: ");
		GridBagConstraints gbc_lblAnzahlBcher2 = new GridBagConstraints();
		gbc_lblAnzahlBcher2.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblAnzahlBcher2.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnzahlBcher2.gridx = 3;
		gbc_lblAnzahlBcher2.gridy = 1;
		booksAndCopies.add(lblAnzahlBcher2, gbc_lblAnzahlBcher2);
		
		
		numberOfCopiesLabel = new JLabel();
		GridBagConstraints gbc_numberOfCopiesLabel = new GridBagConstraints();
		gbc_numberOfCopiesLabel.insets = new Insets(0, 0, 5, 5);
		gbc_numberOfCopiesLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_numberOfCopiesLabel.gridx = 4;
		gbc_numberOfCopiesLabel.gridy = 1;
		booksAndCopies.add(numberOfCopiesLabel, gbc_numberOfCopiesLabel);
		
		JPanel bookInventory = new JPanel();
		bookInventory.setBorder(new TitledBorder(null, "Buch Inventar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_bookInventory = new GridBagConstraints();
		gbc_bookInventory.anchor = GridBagConstraints.NORTH;
		gbc_bookInventory.fill = GridBagConstraints.HORIZONTAL;
		gbc_bookInventory.gridx = 0;
		gbc_bookInventory.gridy = 1;
		panel_1.add(bookInventory, gbc_bookInventory);
		GridBagLayout gbl_bookInventory = new GridBagLayout();
		gbl_bookInventory.columnWidths = new int[]{124, 0, 0, 0};
		gbl_bookInventory.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_bookInventory.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0};
		gbl_bookInventory.rowWeights = new double[]{1.0, 1.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		bookInventory.setLayout(gbl_bookInventory);
		
		JLabel label = new JLabel("Buch suchen:");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		bookInventory.add(label, gbc_label);
		
		textField = new JTextField();
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		bookInventory.add(textField, gbc_textField);
		
		JCheckBox checkBox = new JCheckBox("Nur Verfuegbare");
		GridBagConstraints gbc_checkBox = new GridBagConstraints();
		gbc_checkBox.anchor = GridBagConstraints.WEST;
		gbc_checkBox.insets = new Insets(0, 0, 5, 5);
		gbc_checkBox.gridx = 2;
		gbc_checkBox.gridy = 0;
		bookInventory.add(checkBox, gbc_checkBox);
		
		JButton button_1 = new JButton("Neues Buch hinzufuegen");
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.anchor = GridBagConstraints.WEST;
		gbc_button_1.insets = new Insets(0, 0, 5, 0);
		gbc_button_1.gridx = 3;
		gbc_button_1.gridy = 0;
		bookInventory.add(button_1, gbc_button_1);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 4;
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		bookInventory.add(scrollPane, gbc_scrollPane);
		
		table_1 = new JTable();
		scrollPane.setColumnHeaderView(table_1);

		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;

	}
	
	public JLabel getNumberOfCopiesLabel() {
		return numberOfCopiesLabel;
	}

	public JLabel getNumberOfBooksLabel() {
		return numberOfBooksLabel;
	}

	public JPanel getContentPane() {
		return contentPane;
	}
	public JTable getTable() {
		return table_1;
	}

}

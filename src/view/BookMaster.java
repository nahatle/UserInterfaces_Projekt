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
		frame.setBounds(100, 100, 600, 300);
		frame.setMinimumSize(new Dimension(525, 250));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane);
		
		JPanel bookTabPanel = new JPanel();
		tabbedPane.addTab("B\u00FCcher", null, bookTabPanel, null);
		GridBagLayout gbl_bookTabPanel = new GridBagLayout();
		gbl_bookTabPanel.columnWidths = new int[]{300, 0};
		gbl_bookTabPanel.rowHeights = new int[]{0, 0};
		gbl_bookTabPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_bookTabPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		bookTabPanel.setLayout(gbl_bookTabPanel);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		bookTabPanel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{50, 0, 0};
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
		gbl_inventoryStats.rowHeights = new int[]{24, 0};
		gbl_inventoryStats.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_inventoryStats.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		inventoryStats.setLayout(gbl_inventoryStats);
		
		JPanel booksAndCopies = new JPanel();
		GridBagConstraints gbc_booksAndCopies = new GridBagConstraints();
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
		
		
		JLabel lblNewLabel = new JLabel(new Integer(library.getBooks().size()).toString());
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 1;
		booksAndCopies.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblAnzahlBcher2 = new JLabel("Anzahl Exemplare: ");
		GridBagConstraints gbc_lblAnzahlBcher2 = new GridBagConstraints();
		gbc_lblAnzahlBcher2.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblAnzahlBcher2.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnzahlBcher2.gridx = 3;
		gbc_lblAnzahlBcher2.gridy = 1;
		booksAndCopies.add(lblAnzahlBcher2, gbc_lblAnzahlBcher2);
		
		
		JLabel lblNewLabel2 = new JLabel(new Integer(library.getCopies().size()).toString());
		GridBagConstraints gbc_lblNewLabel2 = new GridBagConstraints();
		gbc_lblNewLabel2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel2.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel2.gridx = 4;
		gbc_lblNewLabel2.gridy = 1;
		booksAndCopies.add(lblNewLabel2, gbc_lblNewLabel2);
		
		JPanel bookInventory = new JPanel();
		bookInventory.setBorder(new TitledBorder(null, "Buch Inventar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_bookInventory = new GridBagConstraints();
		gbc_bookInventory.fill = GridBagConstraints.BOTH;
		gbc_bookInventory.gridx = 0;
		gbc_bookInventory.gridy = 1;
		panel_1.add(bookInventory, gbc_bookInventory);
		GridBagLayout gbl_bookInventory = new GridBagLayout();
		gbl_bookInventory.columnWidths = new int[]{0, 100};
		gbl_bookInventory.rowHeights = new int[]{98, 0, 0};
		gbl_bookInventory.columnWeights = new double[]{1.0, 0.0};
		gbl_bookInventory.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		bookInventory.setLayout(gbl_bookInventory);
		
		JPanel bookSearch = new JPanel();
		GridBagConstraints gbc_bookSearch = new GridBagConstraints();
		gbc_bookSearch.insets = new Insets(0, 0, 5, 0);
		gbc_bookSearch.fill = GridBagConstraints.BOTH;
		gbc_bookSearch.gridx = 0;
		gbc_bookSearch.gridy = 0;
		bookInventory.add(bookSearch, gbc_bookSearch);
		GridBagLayout gbl_bookSearch = new GridBagLayout();
		gbl_bookSearch.columnWidths = new int[]{0, 0, 0, 0, 20, 0};
		gbl_bookSearch.rowHeights = new int[]{0, 0};
		gbl_bookSearch.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_bookSearch.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		bookSearch.setLayout(gbl_bookSearch);
		
		JLabel lblBuchSuchen = new JLabel("Buch suchen:");
		GridBagConstraints gbc_lblBuchSuchen = new GridBagConstraints();
		gbc_lblBuchSuchen.insets = new Insets(0, 0, 0, 5);
		gbc_lblBuchSuchen.gridx = 1;
		gbc_lblBuchSuchen.gridy = 0;
		bookSearch.add(lblBuchSuchen, gbc_lblBuchSuchen);
		
		JTextField textFieldSearch = new JTextField();
		GridBagConstraints gbc_textFieldSearch = new GridBagConstraints();
		gbc_textFieldSearch.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldSearch.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldSearch.gridx = 2;
		gbc_textFieldSearch.gridy = 0;
		bookSearch.add(textFieldSearch, gbc_textFieldSearch);
		textFieldSearch.setColumns(10);
		
		JPanel bookList = new JPanel();
		GridBagConstraints gbc_bookList = new GridBagConstraints();
		gbc_bookList.insets = new Insets(0, 0, 0, 5);
		gbc_bookList.fill = GridBagConstraints.BOTH;
		gbc_bookList.gridx = 0;
		gbc_bookList.gridy = 1;
		bookInventory.add(bookList, gbc_bookList);
		

		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		//BorderPanel.add(panel, gbc_panel);
		
		JPanel loanTabPanel = new JPanel();
		tabbedPane.addTab("Ausleihen", null, loanTabPanel, null);
	}

}

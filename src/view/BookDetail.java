package view;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;

import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;

import domain.Library;
import javax.swing.SwingConstants;

public class BookDetail {

	public JFrame frame;
	private JPanel BookTitleInformationPanel;
	private JPanel InventoryPanel;
	private JLabel lblIsbn;
	private JLabel lblTitle;
	private JLabel lblAuthor;
	private JLabel lblPublisher;
	private JLabel lblCondition;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JComboBox comboBox;
	private JLabel lblNewLabel;
	private JButton btnAddACopy;
	private JButton btnDeleteBook;

	public BookDetail(Library library) {
		this.library = library;
		initialize();
		//test
	}
	private static Library library;
	private JLabel lblNewLabel_1;
	private JScrollPane scrollPane;
	private JTable table;

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(
				new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

		BookTitleInformationPanel = new JPanel();
		BookTitleInformationPanel.setBorder(new TitledBorder(null, "Book Title Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		frame.getContentPane().add(BookTitleInformationPanel);
		GridBagLayout gbl_BookTitleInformationPanel = new GridBagLayout();
		gbl_BookTitleInformationPanel.columnWidths = new int[] { 0, 0, 0 };
		gbl_BookTitleInformationPanel.rowHeights = new int[] { 0, 0, 0, 0, 35, 0, 0 };
		gbl_BookTitleInformationPanel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_BookTitleInformationPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		BookTitleInformationPanel.setLayout(gbl_BookTitleInformationPanel);

		lblIsbn = new JLabel("ISBN");
		GridBagConstraints gbc_lblIsbn = new GridBagConstraints();
		gbc_lblIsbn.anchor = GridBagConstraints.EAST;
		gbc_lblIsbn.insets = new Insets(0, 0, 5, 5);
		gbc_lblIsbn.gridx = 0;
		gbc_lblIsbn.gridy = 1;
		BookTitleInformationPanel.add(lblIsbn, gbc_lblIsbn);

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		BookTitleInformationPanel.add(textField, gbc_textField);
		textField.setColumns(10);

		lblTitle = new JLabel("Title");
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle.gridx = 0;
		gbc_lblTitle.gridy = 2;
		BookTitleInformationPanel.add(lblTitle, gbc_lblTitle);

		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.anchor = GridBagConstraints.NORTH;
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 2;
		BookTitleInformationPanel.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);

		lblAuthor = new JLabel("Author");
		GridBagConstraints gbc_lblAuthor = new GridBagConstraints();
		gbc_lblAuthor.anchor = GridBagConstraints.EAST;
		gbc_lblAuthor.insets = new Insets(0, 0, 5, 5);
		gbc_lblAuthor.gridx = 0;
		gbc_lblAuthor.gridy = 3;
		BookTitleInformationPanel.add(lblAuthor, gbc_lblAuthor);

		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 3;
		BookTitleInformationPanel.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);

		lblPublisher = new JLabel("Publisher");
		GridBagConstraints gbc_lblPublisher = new GridBagConstraints();
		gbc_lblPublisher.anchor = GridBagConstraints.EAST;
		gbc_lblPublisher.insets = new Insets(0, 0, 5, 5);
		gbc_lblPublisher.gridx = 0;
		gbc_lblPublisher.gridy = 4;
		BookTitleInformationPanel.add(lblPublisher, gbc_lblPublisher);

		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 4;
		BookTitleInformationPanel.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);

		lblCondition = new JLabel("Condition");
		GridBagConstraints gbc_lblCondition = new GridBagConstraints();
		gbc_lblCondition.insets = new Insets(0, 0, 0, 5);
		gbc_lblCondition.gridx = 0;
		gbc_lblCondition.gridy = 5;
		BookTitleInformationPanel.add(lblCondition, gbc_lblCondition);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(
				new String[] { "1", "2", "3" }));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 5;
		BookTitleInformationPanel.add(comboBox, gbc_comboBox);

		InventoryPanel = new JPanel();
		InventoryPanel.setBorder(new TitledBorder(null, "Inventory",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		frame.getContentPane().add(InventoryPanel);
		GridBagLayout gbl_InventoryPanel = new GridBagLayout();
		gbl_InventoryPanel.columnWidths = new int[]{95, 19, 0, 0, 0};
		gbl_InventoryPanel.rowHeights = new int[]{29, 0, 0, 0};
		gbl_InventoryPanel.columnWeights = new double[]{1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_InventoryPanel.rowWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		InventoryPanel.setLayout(gbl_InventoryPanel);
				
						lblNewLabel = new JLabel("Anzahl:");
						lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
						GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
						gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
						gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);										
						gbc_lblNewLabel.gridx = 0;
						gbc_lblNewLabel.gridy = 0;
						InventoryPanel.add(lblNewLabel, gbc_lblNewLabel);
				
				lblNewLabel_1 = new JLabel(new Integer(library.getBooks().size()).toString());
				GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
				gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_1.gridx = 1;
				gbc_lblNewLabel_1.gridy = 0;
				InventoryPanel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
				btnDeleteBook = new JButton("Ausgewählte entfernen");
				GridBagConstraints gbc_btnDeleteBook = new GridBagConstraints();
				gbc_btnDeleteBook.insets = new Insets(0, 0, 5, 5);
				gbc_btnDeleteBook.anchor = GridBagConstraints.WEST;
				gbc_btnDeleteBook.gridx = 2;
				gbc_btnDeleteBook.gridy = 0;
				InventoryPanel.add(btnDeleteBook, gbc_btnDeleteBook);

		btnAddACopy = new JButton("Add a copy");
		GridBagConstraints gbc_btnAddACopy = new GridBagConstraints();
		gbc_btnAddACopy.insets = new Insets(0, 0, 5, 0);
		gbc_btnAddACopy.anchor = GridBagConstraints.WEST;
		gbc_btnAddACopy.gridx = 3;
		gbc_btnAddACopy.gridy = 0;
		InventoryPanel.add(btnAddACopy, gbc_btnAddACopy);
		

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		InventoryPanel.add(scrollPane, gbc_scrollPane);



	}

}

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



	public BookDetail() {
		initialize();
	}




	private JPanel BookTitleInformationPanel;
	private JPanel InventoryPanel;
	private JLabel lblTitle;
	private JLabel lblAuthor;
	private JLabel lblPublisher;
	private JLabel lblCondition;
	private JTextField txtFieldPublisher;
	private JTextField txtFieldTitle;
	private JTextField txtFieldAuthor;
	private JComboBox comboBox;
	private JLabel lblNewLabel;
	private JButton btnAddACopy;
	private JButton btnDeleteBook;
	private JLabel lblNumberOfCopies;
	private JScrollPane detailScrollPane;
	private JTable conditionTable;
	private JPanel contentPane;
	private JPanel inventoryActionPanel;


	private void initialize() {

		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));

		BookTitleInformationPanel = new JPanel();
		BookTitleInformationPanel.setBorder(new TitledBorder(null, "Book Title Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(BookTitleInformationPanel, BorderLayout.NORTH);

		GridBagLayout gbl_BookTitleInformationPanel = new GridBagLayout();
		gbl_BookTitleInformationPanel.columnWidths = new int[] { 0, 0, 0 };
		gbl_BookTitleInformationPanel.rowHeights = new int[] { 0, 0, 0, 0, 35, 0, 0 };
		gbl_BookTitleInformationPanel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_BookTitleInformationPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		BookTitleInformationPanel.setLayout(gbl_BookTitleInformationPanel);

		lblTitle = new JLabel("Titel");
		GridBagConstraints gbc_lblTitle = new GridBagConstraints();
		gbc_lblTitle.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
		gbc_lblTitle.gridx = 0;
		gbc_lblTitle.gridy = 2;
		BookTitleInformationPanel.add(lblTitle, gbc_lblTitle);

		txtFieldTitle = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.anchor = GridBagConstraints.NORTH;
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 1;
		gbc_textField_3.gridy = 2;
		BookTitleInformationPanel.add(txtFieldTitle, gbc_textField_3);
		txtFieldTitle.setColumns(10);

		lblAuthor = new JLabel("Author");
		GridBagConstraints gbc_lblAuthor = new GridBagConstraints();
		gbc_lblAuthor.anchor = GridBagConstraints.EAST;
		gbc_lblAuthor.insets = new Insets(0, 0, 5, 5);
		gbc_lblAuthor.gridx = 0;
		gbc_lblAuthor.gridy = 3;
		BookTitleInformationPanel.add(lblAuthor, gbc_lblAuthor);

		txtFieldAuthor = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 1;
		gbc_textField_4.gridy = 3;
		BookTitleInformationPanel.add(txtFieldAuthor, gbc_textField_4);
		txtFieldAuthor.setColumns(10);

		lblPublisher = new JLabel("Verlag");
		GridBagConstraints gbc_lblPublisher = new GridBagConstraints();
		gbc_lblPublisher.anchor = GridBagConstraints.EAST;
		gbc_lblPublisher.insets = new Insets(0, 0, 5, 5);
		gbc_lblPublisher.gridx = 0;
		gbc_lblPublisher.gridy = 4;
		BookTitleInformationPanel.add(lblPublisher, gbc_lblPublisher);

		txtFieldPublisher = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 4;
		BookTitleInformationPanel.add(txtFieldPublisher, gbc_textField_2);
		txtFieldPublisher.setColumns(10);

		lblCondition = new JLabel("Zustand");
		GridBagConstraints gbc_lblCondition = new GridBagConstraints();
		gbc_lblCondition.insets = new Insets(0, 0, 0, 5);
		gbc_lblCondition.gridx = 0;
		gbc_lblCondition.gridy = 5;
		BookTitleInformationPanel.add(lblCondition, gbc_lblCondition);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"NEW", "GOOD", "DAMAGED", "WASTE", "LOST" }));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 5;
		BookTitleInformationPanel.add(comboBox, gbc_comboBox);

		InventoryPanel = new JPanel();
		InventoryPanel.setBorder(new TitledBorder(null, "Inventory", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(InventoryPanel, BorderLayout.CENTER);
		InventoryPanel.setLayout(new BorderLayout(0, 0));
		

		inventoryActionPanel = new JPanel();
		InventoryPanel.add(inventoryActionPanel, BorderLayout.NORTH);

		lblNewLabel = new JLabel("Anzahl Kopien:");
		inventoryActionPanel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);

		lblNumberOfCopies = new JLabel();
		inventoryActionPanel.add(lblNumberOfCopies);

		btnDeleteBook = new JButton("Ausgewählte entfernen");
		inventoryActionPanel.add(btnDeleteBook);

		btnAddACopy = new JButton("Buch hinzufuegen");
		inventoryActionPanel.add(btnAddACopy);
		
		
		conditionTable = new JTable();
		
		detailScrollPane = new JScrollPane(conditionTable);
		InventoryPanel.add(detailScrollPane, BorderLayout.CENTER);
		detailScrollPane.setViewportView(conditionTable);
		
//
//		JScrollPane scrollPane = new JScrollPane(table);
//		inventoryBooksPanel.add(scrollPane, BorderLayout.CENTER);
//
//		table = new JTable();
//		scrollPane.setViewportView(table);
//		scrollPane = new JScrollPane();
//		InventoryPanel.add(scrollPane);

	}

	public JTable getConditionTable() {
		return conditionTable;
	}

	public JButton getBtnAddACopy() {
		return btnAddACopy;
	}

	public JButton getBtnDeleteBook(){
		return btnDeleteBook;
	}
	
	public JPanel getContentPane() {
		return contentPane;
	}

	public void setTxtFieldPublisher(String publisher) {
		this.txtFieldPublisher.setText(publisher);
	}

	public void setTxtFieldTitle(String title) {
		this.txtFieldTitle.setText(title);
	}

	public void setTxtFieldAuthor(String author) {
		this.txtFieldAuthor.setText(author);
	}

	public JTextField getTxtFieldPublisher() {
		return txtFieldPublisher;
	}

	public JTextField getTxtFieldTitle() {
		return txtFieldTitle;
	}

	public JTextField getTxtFieldAuthor() {
		return txtFieldAuthor;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}

	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}
	
}

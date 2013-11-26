package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class BookMaster {

	private JTextField textField;
	private JTable table;
	private JLabel numOfCopiesLabel;
	private JLabel numOfBooksLabel;
	private JPanel contentPane;
	private JButton btnNeu;
	private JButton btnBearbeiten;
	private JLabel lblAnzSelektiert;
	private JCheckBox checkBoxNurVerfuegbare;
	
	
	
	public BookMaster() {
		initialize();
	}


	private void initialize() {

		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel inventoryStatsPanel = new JPanel();
		inventoryStatsPanel.setBorder(new TitledBorder(null, "Inventar Statistik", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(inventoryStatsPanel, BorderLayout.NORTH);
		GridBagLayout gbl_inventoryStatsPanel = new GridBagLayout();
		gbl_inventoryStatsPanel.columnWidths = new int[] { 110, 40, 140 };
		gbl_inventoryStatsPanel.rowHeights = new int[] { 0, 0 };
		gbl_inventoryStatsPanel.columnWeights = new double[] { 1.0, 1.0, 1.0 };
		gbl_inventoryStatsPanel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
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
		FlowLayout flowLayout = (FlowLayout) bookSearchPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		inventoryBooksPanel.add(bookSearchPanel, BorderLayout.NORTH);

		lblAnzSelektiert = new JLabel();
		lblAnzSelektiert.setHorizontalAlignment(SwingConstants.LEFT);
		bookSearchPanel.add(lblAnzSelektiert);

		JLabel label = new JLabel("Buch suchen: ");
		bookSearchPanel.add(label);
		label.setHorizontalAlignment(SwingConstants.LEFT);

		textField = new JTextField();
		bookSearchPanel.add(textField);
		textField.setColumns(10);

		checkBoxNurVerfuegbare = new JCheckBox("Nur Verfuegbare");
		bookSearchPanel.add(checkBoxNurVerfuegbare);

		btnNeu = new JButton("Neues Buch hinzufuegen");
		bookSearchPanel.add(btnNeu);

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

	public JTextField getTextField() {
		return textField;
	}

	public JButton getBtnBearbeiten() {
		return btnBearbeiten;
	}

	public JButton getButton() {
		return btnNeu;
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

	public void setLblAnzSelektiert(int number) {
		lblAnzSelektiert.setText("Ausgewaehlt: " + number);
	}


	public JCheckBox getCheckBoxNurVerfuegbare() {
		return checkBoxNurVerfuegbare;
	}

	
}

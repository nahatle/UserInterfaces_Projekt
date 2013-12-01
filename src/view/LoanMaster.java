package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

public class LoanMaster {
	
	private JTextField searchTextField;
	private JTable table;
	private JLabel numAktuellAusgeliehen;
	private JPanel contentPane;
	private JButton btnNeueAusleiheErfassen;
	private JButton btnSelektierteAusleiheAnzeigen;
	private JLabel numUeberfaelligeAusleihen;
	private JCheckBox checkboxNurUeberfaellige;
	
	public LoanMaster() {
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

		JLabel lbUeberberfaelligeAusleihen = new JLabel("\u00DCberf\u00E4llige Ausleihen: ");
		lbUeberberfaelligeAusleihen.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lbUeberberfaelligeAusleihen = new GridBagConstraints();
		gbc_lbUeberberfaelligeAusleihen.anchor = GridBagConstraints.WEST;
		gbc_lbUeberberfaelligeAusleihen.insets = new Insets(0, 0, 0, 5);
		gbc_lbUeberberfaelligeAusleihen.gridx = 0;
		gbc_lbUeberberfaelligeAusleihen.gridy = 0;
		inventoryStatsPanel.add(lbUeberberfaelligeAusleihen, gbc_lbUeberberfaelligeAusleihen);

		numUeberfaelligeAusleihen = new JLabel();
		GridBagConstraints gbc_numUeberfaelligeAusleihen = new GridBagConstraints();
		gbc_numUeberfaelligeAusleihen.insets = new Insets(0, 0, 0, 5);
		gbc_numUeberfaelligeAusleihen.gridx = 1;
		gbc_numUeberfaelligeAusleihen.gridy = 0;
		inventoryStatsPanel.add(numUeberfaelligeAusleihen, gbc_numUeberfaelligeAusleihen);

		JLabel lblAktuellAusgeliehen = new JLabel("Aktuell Ausgeliehen:");
		GridBagConstraints gbc_lblAktuellAusgeliehen = new GridBagConstraints();
		gbc_lblAktuellAusgeliehen.anchor = GridBagConstraints.WEST;
		gbc_lblAktuellAusgeliehen.insets = new Insets(0, 0, 0, 5);
		gbc_lblAktuellAusgeliehen.gridx = 2;
		gbc_lblAktuellAusgeliehen.gridy = 0;
		inventoryStatsPanel.add(lblAktuellAusgeliehen, gbc_lblAktuellAusgeliehen);

		numAktuellAusgeliehen = new JLabel();
		GridBagConstraints gbc_numAktuellAusgeliehen = new GridBagConstraints();
		gbc_numAktuellAusgeliehen.gridx = 3;
		gbc_numAktuellAusgeliehen.gridy = 0;
		inventoryStatsPanel.add(numAktuellAusgeliehen, gbc_numAktuellAusgeliehen);

		JPanel inventoryBooksPanel = new JPanel();
		inventoryBooksPanel.setBorder(new TitledBorder(null, "Buch Inventar", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(inventoryBooksPanel, BorderLayout.CENTER);
		inventoryBooksPanel.setLayout(new BorderLayout(0, 0));

		JPanel bookSearchPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) bookSearchPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		inventoryBooksPanel.add(bookSearchPanel, BorderLayout.NORTH);

		JLabel label = new JLabel("Buch suchen:");
		bookSearchPanel.add(label);
		label.setHorizontalAlignment(SwingConstants.LEFT);

		searchTextField = new JTextField();
		bookSearchPanel.add(searchTextField);
		searchTextField.setColumns(10);

		checkboxNurUeberfaellige = new JCheckBox("Nur \u00DCberf\u00E4llige");
		bookSearchPanel.add(checkboxNurUeberfaellige);

		btnNeueAusleiheErfassen = new JButton("Neue Ausleihe Erfassen");
		bookSearchPanel.add(btnNeueAusleiheErfassen);

		btnSelektierteAusleiheAnzeigen = new JButton("Selektierte Ausleihe anzeigen");
		bookSearchPanel.add(btnSelektierteAusleiheAnzeigen);

		JScrollPane scrollPane = new JScrollPane(table);
		inventoryBooksPanel.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		scrollPane.setViewportView(table);

	}

	public JTextField getSearchTextField() {
		return searchTextField;
	}

	public JButton getBtnSelektierteAusleiheAnzeigen() {
		return btnSelektierteAusleiheAnzeigen;
	}

	public JButton getBtnAusleiheErfassen() {
		return btnNeueAusleiheErfassen;
	}


	public JLabel getNumAktuellAusgeliehen() {
		return numAktuellAusgeliehen;
	}


	public JLabel getNumUeberfaelligeAusleihen() {
		return numUeberfaelligeAusleihen;
	}


	public JPanel getContentPane() {
		return contentPane;
	}

	public JTable getTable() {
		return table;
	}

	public JCheckBox getCheckboxNurUeberfaellige() {
		return checkboxNurUeberfaellige;
	}



}

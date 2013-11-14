package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
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
	/**
	 * Create the application.
	 * @param library 
	 */
	public LoanMaster() {
		initialize();
	}


	private int number;
	private JTextField textField;
	private JTable table;
	private JLabel numAktuellAusgeliehen;
	private JLabel numAnzahlAusleihen;
	private JPanel contentPane;
	private JButton btnNeueAusleiheErfassen;
	private JButton btnSelektierteAusleiheAnzeigen;
	private JLabel lblAnzSelect;




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
		gbl_inventoryStatsPanel.rowHeights = new int[]{0, 0, 0};
		gbl_inventoryStatsPanel.columnWeights = new double[]{1.0, 1.0, 1.0};
		gbl_inventoryStatsPanel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		inventoryStatsPanel.setLayout(gbl_inventoryStatsPanel);
		
		JLabel lblAnzahlAusleihen = new JLabel("Anzahl Ausleihen: ");
		lblAnzahlAusleihen.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblAnzahlAusleihen = new GridBagConstraints();
		gbc_lblAnzahlAusleihen.anchor = GridBagConstraints.WEST;
		gbc_lblAnzahlAusleihen.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnzahlAusleihen.gridx = 0;
		gbc_lblAnzahlAusleihen.gridy = 0;
		inventoryStatsPanel.add(lblAnzahlAusleihen, gbc_lblAnzahlAusleihen);
		
		numAnzahlAusleihen = new JLabel();
		GridBagConstraints gbc_numAnzahlAusleihen = new GridBagConstraints();
		gbc_numAnzahlAusleihen.insets = new Insets(0, 0, 5, 5);
		gbc_numAnzahlAusleihen.gridx = 1;
		gbc_numAnzahlAusleihen.gridy = 0;
		inventoryStatsPanel.add(numAnzahlAusleihen, gbc_numAnzahlAusleihen);
		
		JLabel lblAktuellAusgeliehen = new JLabel("Aktuell Ausgeliehen:");
		GridBagConstraints gbc_lblAktuellAusgeliehen = new GridBagConstraints();
		gbc_lblAktuellAusgeliehen.anchor = GridBagConstraints.WEST;
		gbc_lblAktuellAusgeliehen.insets = new Insets(0, 0, 5, 5);
		gbc_lblAktuellAusgeliehen.gridx = 2;
		gbc_lblAktuellAusgeliehen.gridy = 0;
		inventoryStatsPanel.add(lblAktuellAusgeliehen, gbc_lblAktuellAusgeliehen);
		
		numAktuellAusgeliehen = new JLabel();
		GridBagConstraints gbc_numAktuellAusgeliehen = new GridBagConstraints();
		gbc_numAktuellAusgeliehen.insets = new Insets(0, 0, 5, 0);
		gbc_numAktuellAusgeliehen.gridx = 3;
		gbc_numAktuellAusgeliehen.gridy = 0;
		gbc_numAnzahlAusleihen.insets = new Insets(0, 0, 5, 0);
		gbc_numAnzahlAusleihen.gridx = 3;
		gbc_numAnzahlAusleihen.gridy = 0;
		inventoryStatsPanel.add(numAktuellAusgeliehen, gbc_numAktuellAusgeliehen);
		
		JLabel lblberflligeAusleihen = new JLabel("\u00DCberf\u00E4llige Ausleihen: ");
		lblberflligeAusleihen.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblberflligeAusleihen = new GridBagConstraints();
		gbc_lblberflligeAusleihen.anchor = GridBagConstraints.WEST;
		gbc_lblberflligeAusleihen.insets = new Insets(0, 0, 0, 5);
		gbc_lblberflligeAusleihen.gridx = 0;
		gbc_lblberflligeAusleihen.gridy = 1;
		inventoryStatsPanel.add(lblberflligeAusleihen, gbc_lblberflligeAusleihen);
		
		JLabel numberflligeAusleihen = new JLabel();
		GridBagConstraints gbc_numberflligeAusleihen = new GridBagConstraints();
		gbc_numberflligeAusleihen.insets = new Insets(0, 0, 0, 5);
		gbc_numberflligeAusleihen.gridx = 1;
		gbc_numberflligeAusleihen.gridy = 1;
		inventoryStatsPanel.add(numberflligeAusleihen, gbc_numberflligeAusleihen);
		
		lblAnzSelect = new JLabel();
		lblAnzSelect.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblAnzSelect = new GridBagConstraints();
		gbc_lblAnzSelect.anchor = GridBagConstraints.WEST;
		gbc_lblAnzSelect.insets = new Insets(0, 0, 0, 5);
		gbc_lblAnzSelect.gridx = 2;
		gbc_lblAnzSelect.gridy = 1;
		inventoryStatsPanel.add(lblAnzSelect, gbc_lblAnzSelect);
		
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
		
		textField = new JTextField();
		bookSearchPanel.add(textField);
		textField.setColumns(10);
		
		JCheckBox chckbxNurberfllige = new JCheckBox("Nur \u00DCberf\u00E4llige");
		bookSearchPanel.add(chckbxNurberfllige);
		
		btnNeueAusleiheErfassen = new JButton("Neue Ausleihe Erfassen");
		bookSearchPanel.add(btnNeueAusleiheErfassen);
		
		btnSelektierteAusleiheAnzeigen = new JButton("Selektierte Ausleihe anzeigen");
		bookSearchPanel.add(btnSelektierteAusleiheAnzeigen);

		
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

	public JButton getBtnSelektierteAusleiheAnzeigen() {
		return btnSelektierteAusleiheAnzeigen;
	}

	public JButton getBtnAusleiheErfassen() {
		return btnNeueAusleiheErfassen;
	}
	
	public JLabel getNumAktuellAusgeliehen() {
		return numAktuellAusgeliehen;
	}

	public JLabel getNumAnzahlAusleihen() {
		return numAnzahlAusleihen;
	}

	public JPanel getContentPane() {
		return contentPane;
	}
	public JTable getTable() {
		return table;
	}
	public JLabel getLblAnzSelect() {
		return lblAnzSelect;
	}
	
	public void setLblAnzSelektiert(int number) {
		lblAnzSelect.setText("Ausgewaehlt: " + number);
	}

}

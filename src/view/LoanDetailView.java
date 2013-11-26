package view;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;

public class LoanDetailView {
	private JTextField txtFldExemplarId;
	private JComboBox comboBox;
	private JTable loanTable;
	private JPanel contentPane;
	private JButton btnExemplarAusleihen;
	private JLabel lblFktAnzAusleihen;
	private JButton btnExemplarRueckgabe;

	public LoanDetailView() {
		initialize();
	}

	private void initialize() {
		contentPane = new JPanel();
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel customerSelectionPanel = new JPanel();
		contentPane.add(customerSelectionPanel, BorderLayout.NORTH);
		customerSelectionPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Kundenauswahl", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gbl_customerSelectionPanel = new GridBagLayout();
		gbl_customerSelectionPanel.columnWidths = new int[] { 0, 0, 0 };
		gbl_customerSelectionPanel.rowHeights = new int[] { 0, 0 };
		gbl_customerSelectionPanel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_customerSelectionPanel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		customerSelectionPanel.setLayout(gbl_customerSelectionPanel);

		JLabel label = new JLabel("Kunde:");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.insets = new Insets(0, 0, 0, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		customerSelectionPanel.add(label, gbc_label);

		comboBox = new JComboBox();
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		customerSelectionPanel.add(comboBox, gbc_comboBox);

		JPanel loanDetailPanel = new JPanel();
		contentPane.add(loanDetailPanel, BorderLayout.CENTER);
		loanDetailPanel.setLayout(new BorderLayout(0, 0));

		JPanel setLoanPanel = new JPanel();
		loanDetailPanel.add(setLoanPanel, BorderLayout.NORTH);
		setLoanPanel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Neues Exemplar ausleihen", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gbl_setLoanPanel = new GridBagLayout();
		gbl_setLoanPanel.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_setLoanPanel.rowHeights = new int[] { 0, 0 };
		gbl_setLoanPanel.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_setLoanPanel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		setLoanPanel.setLayout(gbl_setLoanPanel);

		JLabel label_3 = new JLabel("Exemplar-ID:");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.EAST;
		gbc_label_3.insets = new Insets(0, 0, 0, 5);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 0;
		setLoanPanel.add(label_3, gbc_label_3);

		txtFldExemplarId = new JTextField();
		txtFldExemplarId.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		setLoanPanel.add(txtFldExemplarId, gbc_textField);

		JLabel label_4 = new JLabel((String) null);
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 0, 5);
		gbc_label_4.gridx = 2;
		gbc_label_4.gridy = 0;
		setLoanPanel.add(label_4, gbc_label_4);

		btnExemplarAusleihen = new JButton("Exemplar ausleihen");
		btnExemplarAusleihen.setMnemonic(KeyEvent.VK_A);
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.gridx = 3;
		gbc_button.gridy = 0;
		setLoanPanel.add(btnExemplarAusleihen, gbc_button);

		JPanel getLoanPanel = new JPanel();
		loanDetailPanel.add(getLoanPanel, BorderLayout.CENTER);
		getLoanPanel.setLayout(new BorderLayout(0, 0));

		JPanel panel_3 = new JPanel();
		getLoanPanel.add(panel_3, BorderLayout.NORTH);
		panel_3.setBorder(new TitledBorder(null, "Ausleihen", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_3.rowHeights = new int[] { 0, 0, 0 };
		gbl_panel_3.columnWeights = new double[] { 0.0, 0.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		panel_3.setLayout(gbl_panel_3);

		JLabel lblAnzAusleieh = new JLabel("Anzahl Ausleihen:");
		GridBagConstraints gbc_lblAnzAusleieh = new GridBagConstraints();
		gbc_lblAnzAusleieh.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnzAusleieh.gridx = 0;
		gbc_lblAnzAusleieh.gridy = 0;
		panel_3.add(lblAnzAusleieh, gbc_lblAnzAusleieh);

		lblFktAnzAusleihen = new JLabel("0");
		GridBagConstraints gbc_lblFktAnzAusleihen = new GridBagConstraints();
		gbc_lblFktAnzAusleihen.insets = new Insets(0, 0, 5, 5);
		gbc_lblFktAnzAusleihen.gridx = 1;
		gbc_lblFktAnzAusleihen.gridy = 0;
		panel_3.add(lblFktAnzAusleihen, gbc_lblFktAnzAusleihen);

		btnExemplarRueckgabe = new JButton("Exemplar zurueckgeben");
		btnExemplarRueckgabe.setHorizontalAlignment(SwingConstants.RIGHT);
		btnExemplarRueckgabe.setMnemonic(KeyEvent.VK_Z);
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 0);
		gbc_button_1.gridx = 5;
		gbc_button_1.gridy = 0;
		panel_3.add(btnExemplarRueckgabe, gbc_button_1);

		JScrollPane scrollPane = new JScrollPane();
		getLoanPanel.add(scrollPane, BorderLayout.CENTER);

		loanTable = new JTable();
		scrollPane.setViewportView(loanTable);

	}

	
	public JButton getBtnExemplarRueckgabe() {
		return btnExemplarRueckgabe;
	}

	public void setLblFktAnzAusleihen(Integer number) {
		lblFktAnzAusleihen.setText(number.toString());

	}

	public JTextField getTxtFldExemplarId() {
		return txtFldExemplarId;
	}

	public JComboBox getComboBox() {
		return comboBox;
	}

	public JTable getLoanTable() {
		return loanTable;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public void setTxtFldExemplarId(String txtFldExemplarId) {
		this.txtFldExemplarId.setText(txtFldExemplarId);
	}

	public JButton getBtnExemplarAusleihen() {
		return btnExemplarAusleihen;
	}

}

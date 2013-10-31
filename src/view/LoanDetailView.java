package view;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;
import java.awt.Component;

public class LoanDetailView extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public LoanDetailView() {
		
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{53, 0, 0, 20, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Kundenauswahl", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_1.anchor = GridBagConstraints.NORTH;
		gbc_panel_1.insets = new Insets(0, 0, 15, 0);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel label = new JLabel("Kunde:");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		panel_1.add(label, gbc_label);
		
		JLabel label_1 = new JLabel("Dieser Kunde hat \u00DCberf\u00E4llige Ausleihen.");
		label_1.setForeground(Color.RED);
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_label_1.gridwidth = 2;
		gbc_label_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 1;
		panel_1.add(label_1, gbc_label_1);
		
		JLabel label_2 = new JLabel((String) null);
		label_2.setForeground(Color.RED);
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 0, 5);
		gbc_label_2.anchor = GridBagConstraints.WEST;
		gbc_label_2.gridwidth = 2;
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 2;
		panel_1.add(label_2, gbc_label_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Neues Exemplar ausleihen", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 1;
		panel.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel label_3 = new JLabel("Exemplar-ID:");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.EAST;
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 0;
		panel_2.add(label_3, gbc_label_3);
		
		textField = new JTextField();
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel_2.add(textField, gbc_textField);
		
		JLabel label_4 = new JLabel((String) null);
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 2;
		gbc_label_4.gridy = 0;
		panel_2.add(label_4, gbc_label_4);
		
		JButton button = new JButton("Exemplar ausleihen");
		button.setMnemonic(KeyEvent.VK_A);
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 5, 0);
		gbc_button.gridx = 3;
		gbc_button.gridy = 0;
		panel_2.add(button, gbc_button);
		
		JLabel label_5 = new JLabel("Zur\u00FCck am:");
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.anchor = GridBagConstraints.EAST;
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 0;
		gbc_label_5.gridy = 1;
		panel_2.add(label_5, gbc_label_5);
		
		JLabel label_6 = new JLabel();
		label_6.setText((String) null);
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 1;
		gbc_label_6.gridy = 1;
		panel_2.add(label_6, gbc_label_6);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Ausleihen", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 2;
		panel.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 0.0, 4.9E-324, 0.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel label_7 = new JLabel("Anzahl Ausleihen:");
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.insets = new Insets(0, 0, 5, 5);
		gbc_label_7.gridx = 0;
		gbc_label_7.gridy = 0;
		panel_3.add(label_7, gbc_label_7);
		
		JLabel label_8 = new JLabel("0");
		GridBagConstraints gbc_label_8 = new GridBagConstraints();
		gbc_label_8.insets = new Insets(0, 0, 5, 5);
		gbc_label_8.gridx = 1;
		gbc_label_8.gridy = 0;
		panel_3.add(label_8, gbc_label_8);
		
		JButton button_1 = new JButton("Exemplar zur\u00FCckgeben");
		button_1.setMnemonic(KeyEvent.VK_Z);
		GridBagConstraints gbc_button_1 = new GridBagConstraints();
		gbc_button_1.insets = new Insets(0, 0, 5, 0);
		gbc_button_1.gridx = 4;
		gbc_button_1.gridy = 0;
		panel_3.add(button_1, gbc_button_1);
		
		JScrollPane scrollPane = new JScrollPane((Component) null);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel_3.add(scrollPane, gbc_scrollPane);

	}

}

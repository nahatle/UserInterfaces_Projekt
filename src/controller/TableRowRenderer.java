package controller;

import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class TableRowRenderer extends DefaultTableCellRenderer{
	private Color whiteColor = new Color(254, 254, 254);
    private Color alternateColor = new Color(237, 243, 254);
    private Color selectedColor = new Color(61, 128, 223);

    public Component getTableCellRendererComponent(JTable table,  Object value, boolean selected, boolean focused, int row, int column) {
        super.getTableCellRendererComponent(table, value, selected, focused, row, column);

        Color bg;
        if (!selected)
            bg = (row % 2 == 0 ? alternateColor : whiteColor);
        else
            bg = selectedColor;
        setBackground(bg);

        Color fg;
        if (selected)
            fg = Color.white;
        else
            fg = Color.black;
        setForeground(fg);

        setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));

        return this;
    }
}

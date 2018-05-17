package view;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextField;

import controller.ConstantList;

public class FrameStatus extends JFrame {

	private static final long serialVersionUID = 1L;

	private PanelTable panelTable;
	private JTextField textField;

	public FrameStatus() {
		setTitle(ConstantList.APP);
		setSize(ConstantList.WIDTH, ConstantList.HEIGHT);
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon(getClass().getResource(ConstantList.APP_ICON)).getImage());
		setLayout(new BorderLayout());
		panelTable = new PanelTable();
		add(panelTable, BorderLayout.CENTER);
		setResizable(false);
		setVisible(true);
	}
	
	public void loadList(HashSet<String> list) {
		panelTable.setList(list);
		revalidate();
	}
	
	public ArrayList<JCheckBox> getCheckBoxDownload() {
		return panelTable.getCheckBoxDownload();
	}
	
	public ArrayList<JCheckBox> getCheckBoxFilter() {
		return panelTable.getCheckBoxFilter();
	}

	public String getSearch() {
		return textField.getText().replace(' ', '+');
	}
}

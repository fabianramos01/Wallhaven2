package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.ConstantList;

public class PanelTable extends JPanel {

	private static final long serialVersionUID = 1L;
	private ArrayList<JCheckBox> checkBoxDownload;
	private ArrayList<JCheckBox> checkBoxFilter;
	
	public PanelTable() {
		checkBoxDownload = new ArrayList<>();
		checkBoxFilter = new ArrayList<>();
	}
	
	public void setList(HashSet<String> list) {
		setLayout(new GridLayout(list.size()+3/3, 3));
		add(addLabel(ConstantList.URL));
		add(addLabel(ConstantList.DOWNLOAD));
		add(addLabel(ConstantList.FILTER));
		int i = 0;
		for (String string : list) {
			add(addLabel(string));
			checkBoxDownload.add(new JCheckBox());
			add(checkBoxDownload.get(i));
			checkBoxFilter.add(new JCheckBox());
			add(checkBoxFilter.get(i));
			i++;
		}
		revalidate();
	}
	
	private JLabel addLabel(String name) {
		JLabel jLabel = UtilityList.createJLabel(name, ConstantList.AGENCY_FB, Color.BLACK);
		jLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		return jLabel;
	}
	
	public ArrayList<JCheckBox> getCheckBoxDownload() {
		return checkBoxDownload;
	}
	
	public ArrayList<JCheckBox> getCheckBoxFilter() {
		return checkBoxFilter;
	}
}
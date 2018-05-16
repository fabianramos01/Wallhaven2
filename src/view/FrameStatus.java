package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.ConstantList;

public class FrameStatus extends JFrame {

	private static final long serialVersionUID = 1L;

	private ArrayList<JCheckBox> checkBoxDownload;
	private ArrayList<JCheckBox> checkBoxFilter;
	private JPanel panelList;
	private JTextField textField;

	public FrameStatus(ActionListener listener) {
		setTitle(ConstantList.APP);
		setSize(ConstantList.WIDTH, ConstantList.HEIGHT);
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon(getClass().getResource(ConstantList.APP_ICON)).getImage());
		setLayout(new BorderLayout());
		init(listener);
		setResizable(false);
		setVisible(true);
	}

	private void init(ActionListener listener) {
		panelList = new JPanel();
		add(panelList, BorderLayout.CENTER);
	}
	
	public void loadList(HashSet<String> list) {
		panelList.removeAll();
		panelList.updateUI();
		panelList.setLayout(new GridLayout(list.size()+3/3, 3));
		panelList.add(UtilityList.createJLabel(ConstantList.URL, ConstantList.AGENCY_FB, Color.BLUE));
		panelList.add(UtilityList.createJLabel(ConstantList.DOWNLOAD, ConstantList.AGENCY_FB, Color.BLUE));
		panelList.add(UtilityList.createJLabel(ConstantList.FILTER, ConstantList.AGENCY_FB, Color.BLUE));
		checkBoxDownload = new ArrayList<>();
		checkBoxFilter = new ArrayList<>();
		int i = 0;
		for (String string : list) {
			panelList.add(UtilityList.createJLabel(string, ConstantList.AGENCY_FB, Color.BLACK));
			checkBoxDownload.add(new JCheckBox());
			panelList.add(checkBoxDownload.get(i));
			checkBoxFilter.add(new JCheckBox());
			panelList.add(checkBoxFilter.get(i));
			i++;
		}
	}
	
	public ArrayList<JCheckBox> getCheckBoxDownload() {
		return checkBoxDownload;
	}
	
	public ArrayList<JCheckBox> getCheckBoxFilter() {
		return checkBoxFilter;
	}

	public String getSearch() {
		return textField.getText().replace(' ', '+');
	}
}

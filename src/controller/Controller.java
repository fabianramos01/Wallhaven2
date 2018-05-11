package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import persistence.FileManager;
import persistence.WebImage;
import view.FrameHome;

public class Controller implements ActionListener {

	private FrameHome frameHome;
	private Timer timer;
	private long time;
	private ArrayList<WebImage> webImages;
	private File copy;

	public Controller() {
		copy = new File(ConstantList.FILE_IMG_PATH_F);
		frameHome = new FrameHome(this);
		webImages = new ArrayList<>();
		timer();
	}

	private void init() {
		removeFiles();
		timer.start();
		time = System.currentTimeMillis();
		int count = 0;
		try {
			FileManager.downloadFile(frameHome.getSearch());
			for (String image : FileManager.getImagesURL()) {
				webImages.add(new WebImage(image, String.valueOf(count)));
				count++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void removeFiles() {
		for (File file : copy.listFiles()) {
			file.delete();
		}
	}

	private void timer() {
		timer = new Timer(ConstantList.TIME_REFRESH, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frameHome.loadImages(getImageList());
				frameHome.refreshProgress(new File(ConstantList.FILE_IMG_PATH).list().length + copy.list().length, 48);
				if (new File(ConstantList.FILE_IMG_PATH).list().length + copy.list().length == 48) {
					timer.stop();
					JOptionPane.showMessageDialog(null,
							"Tiempo transcurrido: " + (System.currentTimeMillis() - time) / 1000 + "seg");
				}

			}
		});
	}

	private ArrayList<String> getImageList() {
		ArrayList<String> list = new ArrayList<>();
		for (File file : new File(ConstantList.FILE_IMG_PATH_F).listFiles()) {
			list.add(file.getAbsolutePath());
		}
		return list;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (CommandList.valueOf(e.getActionCommand())) {
		case COMMAND_SEARCH:
			init();
			break;
		}
	}
}
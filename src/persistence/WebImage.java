package persistence;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.imageio.ImageIO;

import controller.ConstantList;
import model.MyThread;

public class WebImage extends MyThread{
	
	private String imageUrl;
	private String filePath;

	public WebImage(String imageUrl, String filePath) {
		super("", ConstantList.SLEEP);
		this.imageUrl = imageUrl;
		this.filePath = filePath;
		start();
	}

	private void writeImg(String img, FileOutputStream out) throws IOException {
		URLConnection image = new URL(img).openConnection();
		image.addRequestProperty("User-Agent",
				"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
		InputStream in = image.getInputStream();
		int c;
		while ((c = in.read()) != -1) {
			out.write(c);
		}
		in.close();
		out.close();
	}

	private void addFilter(String name, BufferedImage buffImage) throws IOException {
		for (int i = 0; i < buffImage.getWidth(); i++) {
			for (int j = 0; j < buffImage.getHeight(); j++) {
				Color pixel = new Color(buffImage.getRGB(i, j));
				int newPixel = (pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3;
				buffImage.setRGB(i, j, new Color(newPixel, newPixel, newPixel).getRGB());
			}
		}
		ImageIO.write(buffImage, "jpg", new File(ConstantList.FILE_IMG_PATH_F + name));
	}

	@Override
	public void execute() {
		File image = new File(ConstantList.FILE_IMG_PATH + filePath + ConstantList.EXTENSION_JPG);
		try {
			writeImg(imageUrl, new FileOutputStream(image));
			addFilter(image.getName(), ImageIO.read(image));
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		stop();
	}

}

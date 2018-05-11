package controller;

import java.awt.Font;
import java.net.InetSocketAddress;
import java.net.Proxy;

public class ConstantList {

	public static final int WIDTH = 1000;
	public static final int HEIGHT = 900;
	public static final String APP = "ImageFilter";
	public static final String APP_ICON = "/data/appIcon.png";
	public static final Font AGENCY_FB = new Font("Agency FB", Font.BOLD, 30);

	public static final String WEB_INIT_PATH = "https://alpha.wallhaven.cc/search?q=";
	public static final String WEB_END_PATH = "&search_image=";
	public static final String FILE_PATH = "images.xml";
	public static final String EXTENSION_JPG = ".jpg";
	public static final String EXTENSION_PNG = ".png";
	public static final String FILE_IMG_PATH = "images/";
	public static final String FILE_IMG_PATH_F = "imagesWFilter/";

	public static final String SEARCH = "Busqueda";
	public static final String URL_IMG = "https://alpha.wallhaven.cc/wallpapers/full/wallhaven-";
	public static final int MAX_PROGRESS = 100;
	public static final int TIME_REFRESH = 500;
	public static final int IMG_SIZE = 366;
	
	public static final Proxy PROXY = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("172.16.0.73", 8080));
	public static final int SLEEP = 10;
}
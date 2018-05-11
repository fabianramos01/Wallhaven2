package persistence;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import controller.ConstantList;

public class FileManager {

	public static void downloadFile(String image) throws IOException {
		URLConnection website = new URL(ConstantList.WEB_INIT_PATH + image + ConstantList.WEB_END_PATH)
				.openConnection(ConstantList.PROXY);
		website.addRequestProperty("User-Agent",
				"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
		try (InputStream in = website.getInputStream()) {
			Files.copy(in, Paths.get(ConstantList.FILE_PATH), StandardCopyOption.REPLACE_EXISTING);
		}
	}

	public static HashSet<String> getImagesURL() throws IOException {
		Pattern pattern = Pattern.compile("(https://alpha\\.wallhaven\\.cc/wallpapers/thumb/small/th-)(\\d+)");
		Matcher matcher = pattern.matcher(Files.readAllLines(Paths.get(ConstantList.FILE_PATH)).get(0));
		HashSet<String> images = new HashSet<>();
		while (matcher.find()) {
			images.add(matcher.group(1) + matcher.group(2) + ConstantList.EXTENSION_JPG);
		}
		return images;
	}
}
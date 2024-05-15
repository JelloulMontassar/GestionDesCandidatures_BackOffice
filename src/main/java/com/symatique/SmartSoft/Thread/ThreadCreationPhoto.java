package com.symatique.SmartSoft.Thread;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import com.symatique.SmartSoft.config.ImageData;

public class ThreadCreationPhoto extends Thread implements Runnable {

	private List<ImageData> listPhotos = new ArrayList<>();
	private String path = null;

	public ThreadCreationPhoto(List<ImageData> listPhotos, String path) {
		this.listPhotos = listPhotos;
		this.path = path;
		this.start();
	}

	@Override
	public void run() {
		if (listPhotos != null && !listPhotos.isEmpty()) {
			for (ImageData imageData : listPhotos) {
				try {
					byte[] decodedBytes = Base64.getDecoder().decode(imageData.getBase64Image());
					String fileName = imageData.getFileName();
					saveFile(path, fileName, decodedBytes);
				} catch (IOException e) {
					System.out.println("error Image ");
				}
			}
		}
	}

	private void saveFile(String destination, String fileName, byte[] content) throws IOException {
		Path path = Paths.get(destination + fileName);
		Files.write(path, content);
	}

}

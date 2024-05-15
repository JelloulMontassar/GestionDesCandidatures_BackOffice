package com.symatique.SmartSoft.config;


import lombok.Data;

@Data
public class ImageData {

	 private String base64Image;
	    private String fileName;
		public ImageData(String base64Image, String fileName) {
			super();
			this.base64Image = base64Image;
			this.fileName = fileName;
		}
}
